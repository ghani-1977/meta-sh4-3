require linux-sh4.inc

COMPATIBLE_MACHINE = "vitamin_hd5000"

STXNUMBER = "stx7111"

SRC_URI_append += "\
    file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-lmb_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
"

MACHINE_KERNEL_PR_append = ".1"
