FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "\
	${@bb.utils.contains("MACHINE_FEATURES", "modspark", "file://spark_modutils.patch", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "modsh4", "file://sh4_modutils.patch", "", d)} \
	"