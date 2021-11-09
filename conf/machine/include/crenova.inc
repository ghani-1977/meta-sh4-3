require conf/machine/include/oem-sh4.inc
require conf/machine/include/normal-sh4-image.inc
require conf/machine/include/sh4-jffs2.inc

BOX_BRAND = "opticum"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES = "tar.gz"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	fp-control \
	"

MACHINE_FEATURES += "ci RCA"

CAN_USE_ENIGMA2_IN_FLASH = "1"

RCTYPE = "21"
RCNAME = "opt9600"
