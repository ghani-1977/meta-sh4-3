IMAGEDIR ?= "enigma2"
MTD_KERNEL = "mtd5"
MTD_ROOTFS = "mtd6"
KERNEL_FILE = "uImage"
ROOTFS_FILE = "e2jffs2.img"

MACHINE_EXTRA_RRECOMMENDS += "\
    ntfs-3g \
    enigma2-plugin-systemplugins-serviceapp \
    "

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    stlirc \
    flash-tools \
    mountspark \
"

MACHINE_FEATURES += "hdmicec directfb"

DISTRO_FEATURES_append += "gtk-directfb"

require conf/machine/include/wifi-fulan.inc
