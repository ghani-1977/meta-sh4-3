require linux-fulan.inc

COMPATIBLE_MACHINE = "pace7241"

STXNUMBER = "stx7105"

SRC_URI = "https://github.com/OpenVisionE2/linux-sh4-2.6.32.71/archive/stmicro.tar.gz \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
"
SRC_URI[md5sum] = "3bc5f1e12a413e9426fe6d5824225b46"
SRC_URI[sha256sum] = "d28ae0df471c29e8d13e992420ef035eb9ef2ec3443048b650e54a962c3bdd71"

MACHINE_KERNEL_PR_append = ".1"
