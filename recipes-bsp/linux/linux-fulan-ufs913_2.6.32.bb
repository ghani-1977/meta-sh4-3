require linux-fulan.inc

COMPATIBLE_MACHINE = "ufs913"

STXNUMBER = "stx7105"

SRC_URI_append += "\
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
"

MACHINE_KERNEL_PR_append = ".1"
