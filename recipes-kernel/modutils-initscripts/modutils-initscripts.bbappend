FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "\
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-cuberevo", "file://modutils-cuberevo.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-edisionargus", "file://modutils-edisionargus.patch", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "modutils-kathrein", "file://modutils-kathrein.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-kathrein-ufs910", "file://modutils-kathrein-ufs910.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-nbox", "file://modutils-nbox.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-octagon1008", "file://modutils-octagon1008.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-sh4", "file://modutils-sh4.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-spark", "file://modutils-spark.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modutils-spiderbox", "file://modutils-spiderbox.patch", "", d)} \
	"
