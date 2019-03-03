require linux-fulan.inc

COMPATIBLE_MACHINE = "hs7110|hs7119|hs7420|hs7429|hs7810a|hs7819"

STXNUMBER = "stx7111"

SRC_URI = "https://github.com/OpenVisionE2/linux-sh4-2.6.32.71/archive/stmicro.tar.gz \
    file://linux-sh4-lmb_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-i2c-stm-downgrade_stm24_${STM_PATCH_STR}.patch;patch=1 \
"
SRC_URI[md5sum] = "3bc5f1e12a413e9426fe6d5824225b46"
SRC_URI[sha256sum] = "d28ae0df471c29e8d13e992420ef035eb9ef2ec3443048b650e54a962c3bdd71"

MACHINE_KERNEL_PR_append = ".2"
