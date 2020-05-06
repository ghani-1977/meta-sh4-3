require linux-sh4.inc

COMPATIBLE_MACHINE = "^(forever_2424hd|forever_3434hd|forever_9898hd|forever_nanosmart)$"

STXNUMBER = "stxh205"

SRC_URI_append += "\
    file://linux-add_fortis_4g_boards_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-add_STAPI_${STM_PATCH_STR}.patch;patch=1 \
    file://forever-4g.patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://generic_104_stxH271_control-pciemp.patch;patch=1 \
    file://generic_106_stxh205_wol_hom_liege.patch;patch=1 \
    file://generic_125_sbc-clock-id-for-H205.patch;patch=1 \
    file://generic_127_ddr_deep_standby.patch;patch=1 \
"
