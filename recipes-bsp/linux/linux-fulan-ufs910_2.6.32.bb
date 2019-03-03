require linux-fulan.inc

COMPATIBLE_MACHINE = "ufs910"

STXNUMBER = "stx7100"

SRC_URI = "https://github.com/OpenVisionE2/linux-sh4-2.6.32.71/archive/stmicro.tar.gz \
    file://linux-sh4-stx7100_fdma_fix_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-sata_32bit_fix_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-sata_stx7100_B4Team_fix_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-usbwait123_stm24.patch;patch=1 \
    file://linux-sh4-${MACHINE}_reboot_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-smsc911x_dma_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_${STM_PATCH_STR}.patch;patch=1 \
"

SRC_URI[md5sum] = "3bc5f1e12a413e9426fe6d5824225b46"
SRC_URI[sha256sum] = "d28ae0df471c29e8d13e992420ef035eb9ef2ec3443048b650e54a962c3bdd71"

MACHINE_KERNEL_PR_append = ".1"
