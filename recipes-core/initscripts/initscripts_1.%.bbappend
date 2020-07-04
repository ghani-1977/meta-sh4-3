FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_sh4 += "\
	${@bb.utils.contains("BOX_BRAND", "cuberevo", "file://cuberevo_initscripts.patch", "", d)} \
	${@bb.utils.contains("BOX_BRAND", "hs", "file://hs_initscripts.patch", "", d)} \
	${@bb.utils.contains("BOX_BRAND", "ufs912", "file://ufs912_initscripts.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-sh4", "file://sh4_initscripts.patch", "", d)} \
"
