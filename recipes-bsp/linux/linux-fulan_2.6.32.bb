SUMMARY = "Linux kernel for ${MACHINE}"
LICENSE = "GPLv2"
SECTION = "kernel"
PACKAGE_ARCH = "${MACHINE_ARCH}"

KV = "2.6.32"
SRCDATE = "20160701"

COMPATIBLE_MACHINE = "adb_box|arivalink200|atemio520|atemio530|atevio7500|cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2|fortis_hdbox|hl101|hs7110|hs7119|hs7420|hs7429|hs7810a|hs7819|ipbox55|ipbox99|ipbox9900|sagemcom88|octagon1008|spark|spark7162|tf7700|ufc960|ufs910|ufs912|ufs913|ufs922|vitamin_hd5000"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

MACHINE_KERNEL_PR_append = ".4"

inherit kernel machine_kernel_pr

DEPENDS_append_spark7162 += "\
  stlinux24-sh4-stx7105-fdma-firmware \
"

DEPENDS_append_spark += "\
  stlinux24-sh4-stx7111-fdma-firmware \
"

# By default, kernel.bbclass modifies package names to allow multiple kernels
# to be installed in parallel. We revert this change and rprovide the versioned
# package names instead, to allow only one kernel to be installed.
PKG_${KERNEL_PACKAGE_NAME}-base = "kernel-base"
PKG_${KERNEL_PACKAGE_NAME}-image = "kernel-image"
RPROVIDES_${KERNEL_PACKAGE_NAME}-base = "kernel-${KERNEL_VERSION}"
RPROVIDES_kernel-image = "kernel-image-${KERNEL_VERSION}"

STM_PATCH_STR = "0217"
LINUX_VERSION = "2.6.32.71"
SRCREV = "3ec500f4212f9e4b4d2537c8be5ea32ebf68c43b"

SRC_URI = "git://github.com/Duckbox-Developers/linux-sh4-2.6.32.71.git;protocol=git;branch=stmicro \
    file://linux-kbuild-generate-modules-builtin_stm24_${STM_PATCH_STR}.patch \
    file://linux-sh4-linuxdvb_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-linuxdvb_stm24_${STM_PATCH_STR}_ca.patch;patch=1 \
    file://linux-sh4-sound_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-time_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-init_mm_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-copro_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-strcpy_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-squashfs-lzma_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-ext23_as_ext4_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-bpa2_procfs_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-ftdi_sio.c_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-lzma-fix_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-tune_stm24.patch;patch=1 \
    file://linux-sh4-permit_gcc_command_line_sections_stm24.patch;patch=1 \
    file://linux-sh4-mmap_stm24.patch;patch=1 \
    file://linux-ratelimit-bug_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-patch_swap_notify_core_support_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-cpuinfo.patch;patch=1 \
    file://linux-sh4-add_missing_eid.patch;patch=1 \
    file://silence_conv_i2sspdif_warning.patch;patch=1 \
    file://linux-sh4-linux_yaffs2.patch;patch=1 \
    file://linux-sh4-fix-crash-usb-reboot.patch;patch=1 \
    file://timeconst_perl5.patch;patch=1 \
    file://defconfig \
    file://st-coprocessor.h \
    file://linux-net_stm24.patch;patch=1 \
    file://zram.patch;patch=1 \
"

SRC_URI_append_spark7162 += "\
    file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-lmb_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
"

SRC_URI_append_spark += "\
    file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-lmb_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-lirc_stm_stm24_${STM_PATCH_STR}.patch;patch=1 \
    file://linux-sh4-${MACHINE}-af901x-NXP-TDA18218.patch;patch=1 \
    file://linux-sh4-${MACHINE}-dvb-as102.patch;patch=1 \
"

SRC_URI_append_tf7700 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-usbwait123_stm24.patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_ufs910 += "\
    file://linux-sh4-stx7100_fdma_fix_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-sata_32bit_fix_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-sata_stx7100_B4Team_fix_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-usbwait123_stm24.patch;patch=1 \
    file://linux-sh4-${MACHINE}_reboot_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-smsc911x_dma_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-pcm_noise_fix_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_ufs912 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_ufs913 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_octagon1008 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-usbwait123_stm24.patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_atevio7500 += "\
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_mtdconcat_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_hs7110 += "\
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_hs7119 += "\
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_hs7420 += "\
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_hs7429 += "\
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_hs7810a += "\
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_hs7819 += "\
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_atemio520 += "\
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_211.patch;patch=1 \
    file://linux-squashfs-downgrade-stm24_$(STM_PATCH_STR)-to-stm23.patch;patch=1 \
    file://linux-squashfs3.0_lzma_stm23.patch;patch=1 \
    file://linux-squashfs-downgrade-stm24-patch-2.6.25.patch;patch=1 \
    file://linux-squashfs-downgrade-stm24-rm_d_alloc_anon.patch;patch=1 \
"

SRC_URI_append_atemio530 += "\
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_211.patch;patch=1 \
    file://linux-squashfs-downgrade-stm24_$(STM_PATCH_STR)-to-stm23.patch;patch=1 \
    file://linux-squashfs3.0_lzma_stm23.patch;patch=1 \
    file://linux-squashfs-downgrade-stm24-patch-2.6.25.patch;patch=1 \
    file://linux-squashfs-downgrade-stm24-rm_d_alloc_anon.patch;patch=1 \
"

SRC_URI_append_ufs922 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-fortis_hdbox_i2c_st40_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_ufc960 += "\
    file://linux-sh4-ufs922_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-fortis_hdbox_i2c_st40_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_hl101 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-usbwait123_stm24.patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_fortis_hdbox += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-usbwait123_stm24.patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_adb_box += "\
    file://linux-sh4-stx7100_fdma_fix_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-sata_32bit_fix_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-usbwait123_stm24.patch;patch=1 \
    file://linux-sh4-ufs910_reboot_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-pcm_noise_fix_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_ipbox9900 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-ipbox_bdinfo_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-ipbox_dvb_ca_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_ipbox99 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-ipbox_bdinfo_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_ipbox55 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-ipbox_bdinfo_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_cuberevo += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-cuberevo_rtl8201_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_cuberevo_mini += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-cuberevo_rtl8201_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_cuberevo_mini2 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-cuberevo_rtl8201_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_cuberevo_250hd += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-cuberevo_rtl8201_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_cuberevo_2000hd += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-cuberevo_rtl8201_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_cuberevo_3000hd += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-cuberevo_rtl8201_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_sagemcom88 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_sound_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_arivalink200 += "\
    file://linux-sh4-${MACHINE}_setup_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-i2c-st40-pio_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-ipbox_bdinfo_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-ipbox_dvb_ca_stm24_$(STM_PATCH_STR).patch;patch=1 \
"

SRC_URI_append_vitamin_hd5000 += "\
    file://linux-sh4-stmmac_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-lmb_stm24_$(STM_PATCH_STR).patch;patch=1 \
    file://linux-sh4-${MACHINE}_setup_stm24_211.patch;patch=1 \
"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

export OS = "Linux"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_IMAGETYPE = "uImage"
KERNEL_IMAGEDEST = "tmp"
KEEPUIMAGE = "yes"
PARALLEL_MAKEINST = ""

# bitbake.conf only prepends PARALLEL make in tasks called do_compile, which isn't the case for compile_modules
# So explicitly enable it for that in here
EXTRA_OEMAKE_prepend = " ${PARALLEL_MAKE} "

PACKAGES =+ "kernel-headers"
INSANE_SKIP_${PN} += "installed-vs-shipped"
FILES_kernel-headers = "${exec_prefix}/src/linux*"
FILES_${KERNEL_PACKAGE_NAME}-dev += "${includedir}/linux"
FILES_${KERNEL_PACKAGE_NAME}-image = "/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}"

do_configure_prepend() {
    oe_machinstall -m 0644 ${WORKDIR}/defconfig ${B}/.config
    sed -i "s#^\(CONFIG_EXTRA_FIRMWARE_DIR=\).*#\1\"${STAGING_DIR_HOST}/lib/firmware\"#" ${B}/.config;
}

do_shared_workdir_prepend() {
    # Workaround for missing dir required in latest oe
    mkdir -p ${B}/include/generated
    touch ${B}/include/generated/null
}

do_shared_workdir_append() {
    kerneldir=${STAGING_KERNEL_BUILDDIR}
    if [ -f include/linux/bounds.h ]; then
        mkdir -p $kerneldir/include/linux
        cp -f include/linux/bounds.h $kerneldir/include/linux/bounds.h
    fi
    if [ -f include/asm-sh/machtypes.h ]; then
        mkdir -p $kerneldir/include/asm-sh
        ln -sf $kerneldir/include/asm-sh $kerneldir/include/asm
        cp -f include/asm-sh/machtypes.h $kerneldir/include/asm-sh
    fi
    if [ -e include/linux/utsrelease.h ]; then
        mkdir -p $kerneldir/include/linux
        cp -f include/linux/utsrelease.h $kerneldir/include/linux/utsrelease.h
    fi
}

do_install_append() {
    install -d ${D}${includedir}/linux
    install -m 644 ${WORKDIR}/st-coprocessor.h ${D}${includedir}/linux
    oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix}/src/linux-${KERNEL_VERSION} ARCH=$ARCH
    mv ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION} ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
}

# hack to override kernel.bbclass...
# uimages are already built in kernel compile
do_uboot_mkimage() {
    :
}

pkg_postinst_kernel-image() {
    if [ "x$D" == "x" ]; then
        if [ -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} ] ; then
            if grep -q root=/dev/mtdblock6 /proc/cmdline; then
                flash_eraseall /dev/${MTD_KERNEL}
                nandwrite -p /dev/${MTD_KERNEL} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
                rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
            else
                flash_erase /dev/${MTD_KERNEL} 0x400000 0x20
                nandwrite -s 0x400000 -p /dev/${MTD_KERNEL} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
            fi
        fi
    fi
    true
}

do_rm_work() {
}

# extra tasks
addtask kernel_link_images after do_compile before do_install
