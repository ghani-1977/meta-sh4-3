require conf/machine/include/oem-sh4.inc
require conf/machine/include/wifi-sh4.inc
require conf/machine/include/ird-sh4-image.inc
require conf/machine/include/sh4-ubi.inc

BOX_BRAND = "forever"

PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-${BOX_BRAND}"

ROOTFS_FILE = "root.img"

IMAGE_FSTYPES += "tar.gz"

AUDIOELF = "audio_7100.elf"
VIDEOELF = "video_h205.elf"

SOC_FAMILY = "stih205"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    stlinux24-sh4-stxh205-fdma-firmware \
    evremote2 \
"

MACHINE_FEATURES += "hdmicec 4thgsh4"

CAN_USE_ENIGMA2_IN_FLASH = "1"
