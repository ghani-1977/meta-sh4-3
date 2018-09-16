require linux-fulan.inc

COMPATIBLE_MACHINE = "ipbox99"

STXNUMBER = "stx7109"

SRC_URI_append += "\
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-ipbox_bdinfo_stm24_${STM_PATCH_STR}.patch;patch=1 \
"