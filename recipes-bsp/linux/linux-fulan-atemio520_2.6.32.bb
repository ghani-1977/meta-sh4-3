require linux-fulan.inc

COMPATIBLE_MACHINE = "atemio520"

STXNUMBER = "stx7111"

SRC_URI_append += "\
    file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-lmb_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_211.patch;patch=1 \
    file://linux-squashfs-downgrade-stm24_${STM_PATCH_STR}-to-stm23.patch;patch=1 \
    file://linux-squashfs3.0_lzma_stm23.patch;patch=1 \
    file://linux-squashfs-downgrade-stm24-patch-2.6.25.patch;patch=1 \
    file://linux-squashfs-downgrade-stm24-rm_d_alloc_anon.patch;patch=1 \
"