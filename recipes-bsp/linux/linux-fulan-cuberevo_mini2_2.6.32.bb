require linux-fulan.inc

COMPATIBLE_MACHINE = "cuberevo_mini2"

STXNUMBER = "stx7109"

SRC_URI_append += "\
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-cuberevo_rtl8201_stm24_${STM_PATCH_STR}.patch;patch=1 \
"