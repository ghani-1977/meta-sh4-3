# We know about rtc
include conf/machine/include/build-extras.inc

BRAND_OEM = "fulan"
MACHINE_NAME = "${@bb.utils.contains('MACHINE', 'spark7162', 'SPARK TRIPLEX', 'SPARK 990 LX', d)}"
MACHINE_BRAND = "GOLDEN MEDIA"
IMAGEDIR ?= "enigma2"
MTD_KERNEL = "mtd5"
MTD_ROOTFS = "mtd6"
KERNEL_FILE = "uImage"
ROOTFS_FILE = "e2jffs2.img"

MACHINE_KERNEL_PR = "r1"
KERNEL_MODULE_PACKAGE_SUFFIX = ""

TARGET_ARCH = "sh4"
DEFAULTTUNE = "sh4"

GCCVERSION = "4.9.4"

GLIBCVERSION = "2.23"
OLDEST_KERNEL = "2.6.32"

PREFERRED_PROVIDER_virtual/kernel = "linux-fulan"
PREFERRED_VERSION_linux-libc-headers = "2.6.32"
PREFERRED_VERSION_directfb = "1.7.7"
PREFERRED_VERSION_rt8812au = "4.3.14"
PREFERRED_VERSION_samba = "3.%"

PREFERRED_PROVIDER_virtual/egl = "libstgles"
PREFERRED_PROVIDER_virtual/libgles1 = "libstgles"

SERIAL_CONSOLE = "115200 ttyAS0"

DVBPROVIDER = "kernel"

OPENPLI_FEATURES += "usbconsole ci"
MACHINE_FEATURES += "ext2 serial wlan dvb-c hdmicec 3dtv switchoff textlcd fulan singlecore directfb sh4booster legacykernel"
DISTRO_FEATURES_remove = "x11 wayland"

KERNEL_IMAGETYPE = "uImage"
#KERNEL_OUTPUT = "${KERNEL_IMAGETYPE}"


JFFS2_ERASEBLOCK = "0x20000"
JFFS2_ENDIANNESS = "${@base_conditional('SITEINFO_ENDIANNESS', 'le', '--little-endian', '--big-endian', d)}"
EXTRA_IMAGECMD_jffs2 = "--pad ${JFFS2_ENDIANNESS} --eraseblock=${JFFS2_ERASEBLOCK} --no-cleanmarkers"
MKUBIFS_ARGS = "--pad ${JFFS2_ENDIANNESS} --eraseblock=${JFFS2_ERASEBLOCK} --no-cleanmarkers"
DVBMEDIASINK_CONFIG = "--with-machine=${MACHINE} --with-wma --with-wmv --with-pcm --with-dtsdownmix --with-eac3"

IMAGE_FSTYPES ?= "jffs2"

# enable this for debug
IMAGE_FSTYPES += "tar.gz"
IMAGE_FSTYPES += "spark71xxusbimg"
# INHERIT += "usb_image-spark71xx"

IMAGE_CLASSES += "usb_image-spark71xx"
INITRAMFS_FSTYPES =  "ext2.gz sparkupdt"

IMAGE_CMD_jffs2_prepend = " \
    rm -rf ${IMAGE_ROOTFS}/tmp/*; \
    "

IMAGE_CMD_jffs2_append = " ; \
    cp ${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.jffs2 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2; \
    mkdir -p ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}; \
    mv ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${ROOTFS_FILE}; \
    cp ${DEPLOY_DIR_IMAGE}/uImage ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${KERNEL_FILE}; \
    cd ${DEPLOY_DIR_IMAGE}; \
    zip ${IMAGE_NAME}_usb.zip ${IMAGEDIR}/*; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.jffs2; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.manifest; \
    rm -f ${DEPLOY_DIR_IMAGE}/.jffs2; \
    rm -f ${DEPLOY_DIR_IMAGE}/.manifest; \
    rm -rf ${IMAGEDIR}; \
    "

# Add uImage in tar image boot directory
IMAGE_CMD_tar_prepend = " \
    cp ${DEPLOY_DIR_IMAGE}/uImage ${IMAGE_ROOTFS}/boot/${KERNEL_FILE}; \
    "
	
MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
    stlinux24-sh4-stx7111-fdma-firmware \
    stslave-fw \
    ustslave \
    stfbcontrol \
    fp-control \
    stlirc \
    stinit \
    fulan-dvb-modules-${MACHINE} \
    flash-tools \
    mountspark \
    mtd-utils-jffs2 \
    libeplayer3 \
    "

MACHINE_EXTRA_RRECOMMENDS = " \
    firmware-carl9170 \
    firmware-htc7010 \
    firmware-htc9271 \
    firmware-rt2870 \
    firmware-rt73 \
    firmware-rtl8712u \
    firmware-zd1211 \
    firmware-rtl8192cu \
    firmware-rt3070 \
    firmware-mt7601u \
    firmware-rtl8188eu \
    firmware-rtl8xxxu \
    \
    gstreamer1.0-plugin-dvbmediasink \
    \
    kernel-module-rtl8187 \
    kernel-module-zd1211rw \
    kernel-module-ar9170usb \
    kernel-module-rt2500usb \
    kernel-module-rt73usb \
    kernel-module-rt2800usb \
    kernel-module-ath \
    kernel-module-rt2x00usb \
    kernel-module-rt2x00lib \
    kernel-module-mt7601usta \
    kernel-module-rt2870sta \
    kernel-module-rt3070sta \
    kernel-module-rt5370sta \
    kernel-module-8188eu \
    kernel-module-8192cu \
    kernel-module-8712u \
    mt7610u \
    rt8723a \
    rt8723bs \
    rt8812au \
    rtl8192eu \
    ntfs-3g \
    rt7777-sh4 \
    "

EXTRA_IMAGEDEPENDS += " \
    libpcre \
    libstgles \
    directfb-stgfx2 \
    aio-grab \
    "

MACHINE_EXTRA_RDEPENDS = "\
    libpcre \
    aio-grab \
    "

include conf/machine/include/autoload-filesystems.inc
require conf/machine/include/tune-sh4.inc
require conf/machine/include/soc-family.inc
