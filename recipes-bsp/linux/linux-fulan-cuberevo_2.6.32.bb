require linux-fulan.inc

COMPATIBLE_MACHINE = "cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2|cuberevo_9500hd"

STXNUMBER = "stx7109"

SRC_URI = "https://github.com/OpenVisionE2/linux-sh4-2.6.32.71/archive/stmicro.tar.gz \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-cuberevo_rtl8201_stm24_${STM_PATCH_STR}.patch;patch=1 \
    ${@bb.utils.contains_any("MACHINE", "cuberevo_250hd", "file://linux-sh4-${MACHINE}_sound_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
"
SRC_URI[md5sum] = "3bc5f1e12a413e9426fe6d5824225b46"
SRC_URI[sha256sum] = "d28ae0df471c29e8d13e992420ef035eb9ef2ec3443048b650e54a962c3bdd71"

MACHINE_KERNEL_PR_append = ".2"
