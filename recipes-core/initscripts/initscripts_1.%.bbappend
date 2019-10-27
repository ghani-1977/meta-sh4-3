FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_sh4 += "\
	${@bb.utils.contains("BOX_BRAND", "cuberevo", "file://cuberevo_initscripts.patch", "file://sh4_initscripts.patch", d)} \
"
