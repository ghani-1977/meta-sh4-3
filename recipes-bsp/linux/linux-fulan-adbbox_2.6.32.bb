require linux-fulan.inc

COMPATIBLE_MACHINE = "adb_box"

STXNUMBER = "stx7100"

SRC_URI = "https://github.com/Duckbox-Developers/linux-sh4-2.6.32.71/archive/stmicro.tar.gz \
    file://linux-sh4-makefile_stm24.patch;patch=1 \
    file://linux-stm-gpio-fix-build-CONFIG_BUG.patch;patch=1 \
    file://linux-kbuild-generate-modules-builtin_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-linuxdvb_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-sound_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-time_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-init_mm_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-copro_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-strcpy_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-ext23_as_ext4_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-bpa2_procfs_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-ftdi_sio.c_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-lzma-fix_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-tune_stm24.patch;patch=1  \
    file://linux-net_stm24.patch;patch=1  \
    file://linux-sh4-permit_gcc_command_line_sections_stm24.patch;patch=1 \
    file://linux-sh4-mmap_stm24.patch;patch=1  \
    file://linux-defined_is_deprecated_timeconst.pl_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-patch_swap_notify_core_support_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-add_missing_eid.patch \
    file://linux-sh4-cpuinfo.patch;patch=1 \
    file://linux-sh4-stx7100_fdma_fix_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-sata_32bit_fix_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-usbwait123_stm24.patch;patch=1 \
    file://linux-sh4-ufs910_reboot_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-pcm_noise_fix_stm24_${STM_PATCH_STR}.patch;patch=1 \
"

SRC_URI[md5sum] = "0223fefb97c690d08e9e548872d6daff"
SRC_URI[sha256sum] = "5d82e7906e5c1f42c8d97bf9e7f774138d7f52ac9923dcc10f9bf9a8d038f519"

MACHINE_KERNEL_PR_append = ".3"
