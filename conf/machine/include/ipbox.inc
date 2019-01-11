require conf/machine/include/oem-fulan.inc
require conf/machine/include/modsh4.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-fulan-${MACHINE}"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES += "tar.gz"

AUDIOELF = "audio_7100.elf"
VIDEOELF = "video_7109.elf"

SOC_FAMILY = "sti7109"

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
