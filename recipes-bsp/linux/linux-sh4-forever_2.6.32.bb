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

SRC_URI[md5sum] = "d22997a7426f4f5beb5d9783a0a4ec19"
SRC_URI[sha256sum] = "b1445440aa83c647344797f0b1334c7dc5188f2663b5aedb1ab04c50d96c410e"

S = "${WORKDIR}/linux-sh4-${KERNELVERSION}.81-stmicro-4g"
