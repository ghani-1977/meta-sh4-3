PREFERRED_PROVIDER_virtual/kernel = "linux-fulan-${MACHINE}"

#MTD_KERNEL = "mtd5"
#MTD_ROOTFS = "mtd6"
#KERNEL_FILE = "uImage"
#ROOTFS_FILE = "usb_update.img"

AUDIOELF = "audio_7100.elf"
VIDEOELF = "video_7109.elf"

SOC_FAMILY = "sti7109"

MACHINE_FEATURES += "ipbox"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	stlinux24-sh4-stx7109-fdma-firmware \
"

#What we need
#extra/frontends/*.ko /lib/modules/
#extra/stgfb/stmfb/stmcore-display-stx7109c3.ko /lib/modules/
#extra/siinfo/siinfo.ko /lib/modules/
#rm -f /lib/firmware/*
#rm -f /lib/modules/boxtype.ko
#rm -f /lib/modules/stmvbi.ko
#rm -f /lib/modules/stmvout.ko
#keymap_ipbox.xml /usr/local/share/enigma2/keymap.xml
