require conf/machine/include/oem-sh4.inc
require conf/machine/include/normal-sh4-image.inc
require conf/machine/include/sh4-jffs2.inc

BOX_BRAND = "nbox"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES += "tar.gz"

MACHINE_FEATURES += "hdmicec ci twintuner smallflash YUV"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	stlirc \
	evremote2 \
	firmware-sh4 \
	enigma2-plugin-extensions-adbvfd \
	"

CAN_USE_ENIGMA2_IN_FLASH = "1"
