require conf/machine/include/oem-fulan.inc
require conf/machine/include/modsh4.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-fulan-hs"

ROOTFS_FILE = "root.img"

AUDIOELF = "audio_7111.elf"
VIDEOELF = "video_7111.elf"

SOC_FAMILY = "sti7111"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    stlinux24-sh4-stx7111-fdma-firmware \
    stlinux24-sh4-stmfb-firmware-stx7111 \
    evremote2 \
"
