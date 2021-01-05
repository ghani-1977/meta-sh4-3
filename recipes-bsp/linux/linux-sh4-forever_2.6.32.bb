require linux-sh4.inc

COMPATIBLE_MACHINE = "^(forever_2424hd|forever_3434hd|forever_9898hd|forever_nanosmart)$"

STXNUMBER = "stxh205"

SRC_URI = "https://github.com/OpenVisionE2/linux-sh4-${KERNELVERSION}.71/archive/stmicro-4g.tar.gz \
	file://defconfig \
	file://${OPENVISION_BASE}/meta-openvision/recipes-linux/kernel-patches/kernel-add-support-for-gcc${VISIONGCCVERSION}.patch \
	file://st-coprocessor.h \
	file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch \
	file://linux-sh4-4g-stmmac_stm24_${STM_PATCH_STR}.patch \
	file://timeconst.patch \
	"

SRC_URI[md5sum] = "337e05e9dfbdac8629ecdae82985f9cd"
SRC_URI[sha256sum] = "c61eb055bd73f1d3ca10bd0ba3ada595c3d017deb957cf5f0fdd824852dd0899"

S = "${WORKDIR}/linux-sh4-${KERNELVERSION}.71-stmicro-4g"
