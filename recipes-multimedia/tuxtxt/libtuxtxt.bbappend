FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS_append_sh4 += "fulan-dvb-modules-${MACHINE}"

SRC_URI_append_sh4 += "\
    file://libtuxtxt-sh4.patch \
"
