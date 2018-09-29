require conf/machine/include/wifi-fulan.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-fulan-${MACHINE}"

ROOTFS_FILE = "e2jffs2.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES += "sparkusbimg"

MACHINE_EXTRA_RRECOMMENDS += "\
    ntfs-3g \
    enigma2-plugin-systemplugins-serviceapp \
    "

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    stlirc \
    flash-tools \
    mountspark \
"

EXTRA_IMAGEDEPENDS += "\
    libstgles \
    "

MACHINE_FEATURES += "hdmicec directfb"

DISTRO_FEATURES_append += "gtk-directfb"
