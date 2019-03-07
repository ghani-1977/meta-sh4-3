FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "\
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-cuberevo", "file://modutils-cuberevo.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-edisionargus", "file://modutils-edisionargus.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-octagon1008", "file://modutils-octagon1008.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-sh4", "file://modutils-sh4.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-spark", "file://modutils-spark.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-spiderbox", "file://modutils-spiderbox", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-ufs910", "file://modutils-ufs910.patch", "", d)} \
	"
