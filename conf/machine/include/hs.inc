require conf/machine/include/oem-sh4.inc
require conf/machine/include/sh4-ubi.inc

BOX_BRAND = "hs"

PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-hs"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

AUDIOELF = "audio_7111.elf"
VIDEOELF = "video_7111.elf"

SOC_FAMILY = "sti7111"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	stlinux24-sh4-stx7111-fdma-firmware \
	stlinux24-sh4-stmfb-firmware-stx7111 \
	evremote2 \
	flash-tools \
	fortis-eeprom \
	fp-control \
	"

MACHINE_FEATURES += "hdmicec ci"
