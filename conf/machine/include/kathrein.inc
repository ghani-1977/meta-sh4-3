require conf/machine/include/oem-sh4.inc
require conf/machine/include/normal-sh4-image.inc
require conf/machine/include/sh4-jffs2.inc

BOX_BRAND = "kathrein"

PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-${MACHINE}"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES = "tar.gz"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	evremote2 \
	fp-control \
	"

MACHINE_FEATURES += "RCA YUV SCAR"

RCNAME = "ufs912"
