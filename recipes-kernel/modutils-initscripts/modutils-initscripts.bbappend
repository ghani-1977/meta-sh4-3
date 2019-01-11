SRC_URI_append_sh4 += "\
    file://sh4_modutils.patch \
"
SRC_URI_append_spark += "\
    file://spark_modutils.patch \
"
SRC_URI_append_spark7162 += "\
    file://spark_modutils.patch \
"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
