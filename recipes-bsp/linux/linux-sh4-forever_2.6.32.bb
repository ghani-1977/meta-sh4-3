require linux-sh4.inc

COMPATIBLE_MACHINE = "^(forever_2424hd|forever_3434hd|forever_9898hd|forever_nanosmart)$"

STXNUMBER = "stxh205"

SRC_URI = "https://github.com/OpenVisionE2/linux-sh4-${KERNELVERSION}.81/archive/stmicro-4g.tar.gz \
	file://defconfig \
	file://${OPENVISION_BASE}/meta-openvision/recipes-linux/kernel-patches/kernel-add-support-for-gcc${VISIONGCCVERSION}.patch \
	file://st-coprocessor.h \
	file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch \
	file://linux-sh4-4g-stmmac_stm24_${STM_PATCH_STR}.patch \
	file://timeconst.patch \
	"

SRC_URI[md5sum] = "abb94f3b359acb99a3481abc8fcf0db1"
SRC_URI[sha256sum] = "eefa1be8a466c6257e93dbec0e58de2b6945ba9e737795bea063ab54ac76bbe2"

S = "${WORKDIR}/linux-sh4-${KERNELVERSION}.81-stmicro-4g"
