require conf/machine/include/oem-sh4.inc
require conf/machine/include/wifi-sh4.inc
require conf/machine/include/normal-sh4-image.inc

BOX_BRAND = "edisionargus"

PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-${BOX_BRAND}"

IMAGE_FSTYPES += "tar.gz"

MACHINE_EXTRA_RRECOMMENDS += "\
    ntfs-3g \
"

AUDIOELF = "audio_7100.elf"
VIDEOELF = "video_7109.elf"

SOC_FAMILY = "sti7109"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    stlirc \
    evremote2 \
    stlinux24-sh4-stx7109-fdma-firmware \
"

MACHINE_FEATURES += "ci directfb"

DISTRO_FEATURES_append += "gtk-directfb"

CAN_USE_ENIGMA2_IN_FLASH = "1"
