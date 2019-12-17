require conf/machine/include/oem-sh4.inc

BOX_BRAND = "cuberevo"

PREFERRED_PROVIDER_virtual/kernel = "linux-sh4-${BOX_BRAND}"

IMAGE_FSTYPES += "tar.gz"

MACHINE_EXTRA_RRECOMMENDS += "\
    ntfs-3g \
"

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

MACHINE_FEATURES += "ci smallflash"

EXTRA_OECONF_append_pn-enigma2 += " --with-cuberevostb"

CAN_USE_ENIGMA2_IN_FLASH = "0"
