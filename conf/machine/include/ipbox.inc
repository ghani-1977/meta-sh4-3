require conf/machine/include/oem-sh4.inc
require conf/machine/include/modutils-sh4.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-ipbox"

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
