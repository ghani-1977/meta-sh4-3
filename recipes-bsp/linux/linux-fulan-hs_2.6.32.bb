require linux-fulan.inc

COMPATIBLE_MACHINE = "hs7110|hs7119|hs7420|hs7429|hs7810a|hs7819"

STXNUMBER = "stx7111"

SRC_URI_append += "\
    file://linux-sh4-lmb_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 \
"

MACHINE_KERNEL_PR_append = ".1"
