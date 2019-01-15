require conf/machine/include/oem-fulan.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-fulan-cuberevo"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES += "tar.gz"

AUDIOELF = "audio_7100.elf"
VIDEOELF = "video_7109.elf"

SOC_FAMILY = "sti7109"

DVB1FIRMWARE = "dvb-fe-cx24116.fw"
DVB2FIRMWARE = "dvb-fe-stv6306.fw"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	stlinux24-sh4-stx7109-fdma-firmware \
	firmware-sh4-fulan \
	evremote2 \
"
MACHINE_FEATURES += "modcuberevo"

#What we need
#extra/stgfb/stmfb/stmcore-display-stx7109c3.ko /lib/modules/
#extra/frontcontroller/ipbox/micom.ko /lib/modules/
#extra/frontends/multituner/*.ko /lib/modules/
#kernel/drivers/media/dvb/frontends/dvb-pll.ko /lib/modules/
