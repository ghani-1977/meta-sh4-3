require conf/machine/include/oem-fulan.inc
require conf/machine/include/smallflash.inc
require conf/machine/include/modsh4.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-fulan-atemio"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES += "tar.gz"

AUDIOELF = "audio_7111.elf"
VIDEOELF = "video_7111.elf"

STLIRCFILE = "atemio"

SOC_FAMILY = "sti7111"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    stlinux24-sh4-stx7111-fdma-firmware \
    stlinux24-sh4-stmfb-firmware-stx7111 \
    evremote2 \
"
