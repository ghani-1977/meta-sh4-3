# We know about rtc
MACHINE_FEATURES_BACKFILL_CONSIDERED += "rtc"

require conf/machine/include/libeplayer-sh4-condition.inc

IMAGEDIR = "enigma2"

KERNEL_MODULE_PACKAGE_SUFFIX = ""

TARGET_ARCH = "sh4"
DEFAULTTUNE = "sh4"

GCCVERSION = "4.9.4"
GLIBCVERSION = "2.25"

HOSTTOOLS_NONFATAL += "whoami"

OLDEST_KERNEL = "2.6.32"
PREFERRED_VERSION_kernel-module-extrawlan-rt8812au = "4.3.14"
PREFERRED_VERSION_directfb = "1.7.7"
PREFERRED_PROVIDER_lirc = "stlirc"
PREFERRED_PROVIDER_virtual/egl = "libstgles"
PREFERRED_PROVIDER_virtual/libgles1 = "libstgles"
PREFERRED_PROVIDER_virtual/enigma2-mediaservice = "enigma2-plugin-systemplugins-servicemp3epl"

SERIAL_CONSOLE = "115200 ttyAS0"

DVBPROVIDER = "kernel"

MACHINE_FEATURES += "alsa ext2 usbhost serial dvb-c switchoff textlcd usbconsole sh4stb ${MACHINE} HDMI"

DISTRO_FEATURES_append = " libsigc2"

KERNEL_IMAGETYPE = "uImage"

DVBMEDIASINK_CONFIG = "--with-wma --with-wmv --with-pcm --with-dtsdownmix --with-eac3"

IMAGE_CLASSES += "usb_image-sh4"

INITRAMFS_FSTYPES =  "ext2.gz sh4updt"

# Add uImage in tar image boot directory
IMAGE_CMD_tar_prepend = "\
    cp ${DEPLOY_DIR_IMAGE}/uImage ${IMAGE_ROOTFS}/boot/${KERNEL_FILE}; \
    "
	
MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	stslave-fw \
	ustslave \
	stfbcontrol \
	devinit \
	sh4-dvb-modules \
	wait4button \
	"

# Adding for sh4 receivers the most popular Wi-Fi chips for usb devices
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += "\
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "", " \
	kernel-module-extrawlan-mt7601u \
	firmware-mt7601u \
	kernel-module-extrawlan-rt3070 \
	firmware-rt2870 \
	kernel-module-extrawlan-rtl8188eu \
	firmware-rtl8188eu \
	kernel-module-extrawlan-rtl8192cu \
	firmware-rtl8192cu \
	kernel-module-extrawlan-rtl8192eu \
	firmware-rtl8192eu", d)} \
	"

EXTRA_IMAGEDEPENDS += "\
	libpcre \
	"

MACHINE_EXTRA_RDEPENDS += "\
	libpcre \
	"


require conf/machine/include/tune-sh4.inc
require conf/machine/include/soc-family.inc

EXTRA_OECONF_append_pn-enigma2 = " --with-sh4stb"
