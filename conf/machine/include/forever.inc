require conf/machine/include/oem-sh4.inc
require conf/machine/include/ird-sh4-image.inc
require conf/machine/include/sh4-ubi.inc

BOX_BRAND = "forever"

PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-${BOX_BRAND}"

ROOTFS_FILE = "root.img"

IMAGE_FSTYPES += "tar.gz"

AUDIOELF = "companion_h205_audio.bin"
VIDEOELF = "companion_h205_video_Ax.bin"
VIDEOELF2 = "companion_h205_video_Bx.bin"

SOC_FAMILY = "stih205"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    stlinux24-sh4-stxh205-fdma-firmware \
    evremote2 \
"

MACHINE_FEATURES += "hdmicec 4thgsh4"

CAN_USE_ENIGMA2_IN_FLASH = "1"
