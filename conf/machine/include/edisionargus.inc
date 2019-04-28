require conf/machine/include/oem-sh4.inc
require conf/machine/include/wifi-sh4.inc

BOX_BRAND = "edisionargus"

PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-${BOX_BRAND}"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES += "tar.gz"

AUDIOELF = "audio_7100.elf"
VIDEOELF = "video_7109.elf"

SOC_FAMILY = "sti7109"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    stlirc \
    stlinux24-sh4-stx7109-fdma-firmware \
"

MACHINE_FEATURES += "modutils-${BOX_BRAND}"
