require linux-sh4.inc

COMPATIBLE_MACHINE = "^(ipbox55|ipbox99|ipbox9900)$"

STXNUMBER = "stx7109"

SRC_URI_append = " \
	file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
	file://linux-sh4-i2c-st40-pio_stm24_${STM_PATCH_STR}.patch;patch=1 \
	file://linux-sh4-ipbox_bdinfo_stm24_${STM_PATCH_STR}.patch;patch=1 \
	${@bb.utils.contains("MACHINE", "ipbox9900", "file://linux-sh4-ipbox_dvb_ca_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
	"
