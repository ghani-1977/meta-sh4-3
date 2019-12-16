require linux-sh4.inc

COMPATIBLE_MACHINE = "^(forever_2424hd|forever_3434hd|forever_9898hd|forever_nanosmart)$"

STXNUMBER = "stxh205"

SRC_URI_append += "\
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    ${@bb.utils.contains_any("MACHINE", "forever_2424hd", "file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
"
