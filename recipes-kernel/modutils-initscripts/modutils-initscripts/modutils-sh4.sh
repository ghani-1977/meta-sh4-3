#!/bin/sh
### BEGIN INIT INFO
# Provides:          module-init-tools
# Required-Start:    
# Required-Stop:     
# Should-Start:      checkroot
# Should-stop:
# Default-Start:     S
# Default-Stop:
# Short-Description: Process /etc/modules.
# Description:       Load the modules listed in /etc/modules.
### END INIT INFO

LOAD_MODULE=modprobe
[ -f /proc/modules ] || exit 0
[ -f /etc/modules ] || [ -d /etc/modules-load.d ] || exit 0
[ -e /sbin/modprobe ] || LOAD_MODULE=insmod

if [ ! -f /lib/modules/`uname -r`/modules.dep ]; then
	[ "$VERBOSE" != no ] && echo "Calculating module dependencies ..."
	depmod -Ae
fi

loaded_modules=" "

BRANDCHECK=`sed -En 's|^brand=(.+)$|\1|p' /usr/lib/enigma.info`
MODELCHECK=`sed -En 's|^model=(.+)$|\1|p' /usr/lib/enigma.info`

process_file() {
	file=$1

	(cat $file; echo; ) |
	while read module args
	do
		case "$module" in
			\#*|"") continue ;;
		esac
		[ -n "$(echo $loaded_modules | grep " $module ")" ] && continue
		[ "$VERBOSE" != no ] && echo -n "$module "
		eval "$LOAD_MODULE $module $args >/dev/null 2>&1"
		loaded_modules="${loaded_modules}${module} "
		mknod -m 0660 /dev/vfd c 147 0
		if [ $MODELCHECK == "cuberevo" ] || [ $MODELCHECK == "cuberevo_250hd" ] || [ $MODELCHECK == "cuberevo_2000hd" ] || [ $MODELCHECK == "cuberevo_3000hd" ] || [ $MODELCHECK == "cuberevo_mini" ] || [ $MODELCHECK == "cuberevo_mini2" ]; then
			[ "$module" == "cuberevo_micom" ] && echo "LOAD" > /dev/vfd
		elif [ $MODELCHECK == "cuberevo_9500hd" ] || [ $MODELCHECK == "ipbox99" ] || [ $MODELCHECK == "ipbox9900" ]; then
			[ "$module" == "micom" ] && echo "LOAD" > /dev/vfd
		elif [ $BRANDCHECK == "hs" ] || [ $BRANDCHECK == "octagon" ]; then
			[ "$module" == "nuvoton" ] && echo "LOAD" > /dev/vfd
		elif [ $MODELCHECK == "vip1_v2" ] || [ $BRANDCHECK == "vip2" ]; then
			[ "$module" == "aotom" ] && echo "LOAD" > /dev/vfd
		elif [ $MODELCHECK == "vip1_v1" ] || [ $BRANDCHECK == "hl101" ]; then
			[ "$module" == "proton" ] && echo "LOAD" > /dev/vfd
		elif [ $BRANDCHECK == "fulan" ]; then
			[ "$module" == "aotom" ] && echo "LOAD" > /dev/vfd
		elif [ $MODELCHECK == "spark7162" ]; then
			mknod -m 0644 /dev/rfmod0 c 150 0
		elif [ $MODELCHECK == "ufc960" ] || [ $MODELCHECK == "ufs912" ] || [ $MODELCHECK == "ufs913" ] || [ $MODELCHECK == "ufs922" ]; then
			[ "$module" == "kathrein_micom" ] && echo "LOAD" > /dev/vfd
		elif [ $MODELCHECK == "ufs910" ]; then
			[ "$module" == "vfd" ] && echo "LOAD" > /dev/vfd
		elif [ $BRANDCHECK == "nbox" ]; then
			if [ "$module" == "boxtype" ]; then
				boxtype=`cat /proc/boxtype`
				echo "boxtype $boxtype"
				if [ $boxtype == 'bska' ] || [ $boxtype == 'bxzb' ]; then
					echo "Init VFD white"
					modprobe front_bska
				else
					echo "Init VFD black"
					modprobe front_bsla
				fi
				echo "LOAD" >/dev/vfd
				mknod -m 666 /dev/sci1 c 169 0
				mknod -m 666 /dev/sci1 c 169 1
				modprobe simu_button
				modprobe e2_proc
				modprobe stmcore-display-stx7100
				modprobe stmfb display0=1280x720-32@50:16m:pal:yuv:yuv
				modprobe embxshell
				modprobe embxmailbox mailbox0=0xb9211000:136:set2 mailbox1=0xb9212000:0
				modprobe embxshm mailbox0=shm:0:7:0x60000000:0:16:16:0:1024:0xa4000000:0x10000000
				modprobe mme_host transport0=shm
				if [ $boxtype == 'bsla' ] || [ $boxtype == 'bzzb' ]; then
					modprobe cooler
				fi
				if [ $boxtype == 'bxzb' ]; then
					modprobe avs type=fake_avs
				else
					modprobe avs type=stv6412
				fi
				modprobe mmelog
				modprobe ksound
				modprobe p2div64
				modprobe stm_v4l2
				modprobe stmvout
				modprobe stmvbi
				modprobe pseudocard
				if [ $boxtype == 'bska' ] || [ $boxtype == 'bxzb' ]; then
					modprobe fe-core
				elif [ $boxtype == 'bsla' ]; then
					modprobe fe-core-twin1
				else
					modprobe fe-core-twin2
				fi
				modprobe pti waitMS=20 videoMem=4096
				modprobe stm_monitor
				modprobe stmsysfs
				if [ $boxtype == 'bzzb' ]; then
					modprobe stmdvb TSIS_mode=serial NIMS=twin
				elif [ $boxtype == 'bsla' ]; then
					modprobe stmdvb TSIS_mode=parallel NIMS=twin
				else
					modprobe stmdvb TSIS_mode=parallel NIMS=single
				fi
				modprobe player2 discardlateframe=0
				modprobe sth264pp
				modprobe stmalloc
				modprobe platform
				modprobe silencegen
				#smartcard parametry: type=bxzb, type=bska, type=bsla, mode_sci1=nbox, mode_sci1=tda8004
				if [ $boxtype == 'bxzb' ]; then
					modprobe smartcard type=bxzb mode_sci1=nbox
				else
					modprobe smartcard type=bska mode_sci1=nbox
				fi
				modprobe bpamem
				modprobe cec_ctrl
			fi
		else
			[ "$module" == "stmfb" ] && echo "LOAD" > /dev/vfd
		fi
		# Seems evremote2.sh isn't enough for RC support.
		if [ $MODELCHECK == "tf7700" ]; then
			mknod -m 0660 /dev/rc c 62 1
		else
			mknod -m 0660 /dev/rc c 147 1
		fi
		# If we have zram.ko in Open Vision whenever user installs it.
		if [ -f /lib/modules/2.6.32.81_stm24_0218/extra/compcache/zram.ko ]; then
			[ "$module" == "zram" ] && echo "8388608" > /sys/block/zram0/disksize # Use 8Mb for swap in ram
		fi
	done
}

[ "$VERBOSE" != no ] && echo -n "Loading modules: "
[ -f /etc/modules ] && process_file /etc/modules

[ -d /etc/modules-load.d ] || exit 0

for f in /etc/modules-load.d/*.conf; do
	process_file $f
done
[ "$VERBOSE" != no ] && echo

echo "1" > /proc/sys/kernel/printk #for more log change level or remake line

if [ -e /dev/zram0 ]; then
	[ "$VERBOSE" != no ] && echo "Enable swap in ram"
	mkswap /dev/zram0
	swapon -p 100 /dev/zram0
fi

exit 0
