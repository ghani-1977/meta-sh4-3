require linux-fulan.inc

COMPATIBLE_MACHINE = "sagemcom88"

STXNUMBER = "stx7105"

SRC_URI_append += "\
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-lmb_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}_sound_stm24_${STM_PATCH_STR}.patch;patch=1 \
"