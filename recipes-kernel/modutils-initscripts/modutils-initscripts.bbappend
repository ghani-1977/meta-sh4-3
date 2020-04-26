FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "\
	${@bb.utils.contains("BOX_BRAND", "cuberevo", "file://modutils-cuberevo.patch", "", d)} \
	${@bb.utils.contains("BOX_BRAND", "edisionargus", "file://modutils-edisionargus.patch", "", d)} \
	${@bb.utils.contains_any("MACHINE", "ufc960 ufs912 ufs913 ufs922", "file://modutils-kathrein.patch", "", d)} \
	${@bb.utils.contains("MACHINE", "ufs910", "file://modutils-kathrein-ufs910.patch", "", d)} \
	${@bb.utils.contains("BOX_BRAND", "nbox", "file://modutils-nbox.patch", "", d)} \
	${@bb.utils.contains("BOX_BRAND", "octagon", "file://modutils-octagon1008.patch", "", d)} \
	${@bb.utils.contains("BOX_BRAND", "hs", "file://modutils-hs.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-sh4", "file://modutils-sh4.patch", "", d)} \
	${@bb.utils.contains("BOX_BRAND", "fulan", "file://modutils-spark.patch", "", d)} \
	${@bb.utils.contains("BOX_BRAND", "spiderbox", "file://modutils-spiderbox.patch", "", d)} \
	"
