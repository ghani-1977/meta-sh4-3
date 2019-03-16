require conf/machine/include/oem-sh4.inc
require conf/machine/include/smallflash.inc

MACHINE_BRAND = "cuberevo"
PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-${MACHINE_BRAND}"

ROOTFS_FILE = "root.img"
KERNEL_FILE = "uImage"

IMAGE_FSTYPES += "tar.gz"

AUDIOELF = "audio_7100.elf"
VIDEOELF = "video_7109.elf"

SOC_FAMILY = "sti7109"

DVB1FIRMWARE = "dvb-fe-cx24116.fw"
DVB2FIRMWARE = "dvb-fe-stv6306.fw"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	stlinux24-sh4-stx7109-fdma-firmware \
	firmware-sh4 \
	evremote2 \
        enigma2-plugin-extensions-cuberevovfd \
"

MACHINE_FEATURES += "ci modutils-cuberevo"

EXTRA_OECONF_append_pn-enigma2 += " --with-cuberevostb"
