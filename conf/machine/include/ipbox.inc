require conf/machine/include/oem-sh4.inc
require conf/machine/include/smallflash.inc
require conf/machine/include/modutils-sh4.inc

BOX_BRAND = "ipbox"

PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-${BOX_BRAND}"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES += "tar.gz"

AUDIOELF = "audio_7100.elf"
VIDEOELF = "video_7109.elf"

SOC_FAMILY = "sti7109"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	stlinux24-sh4-stx7109-fdma-firmware \
	evremote2 \
	stlirc \
"

MACHINE_FEATURES += "ci"

CAN_USE_ENIGMA2_IN_FLASH = "0"
