SUMMARY = "sh4 fup tool for creating flashable image"
SECTION = "console/utils"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit native

SRC_URI = "file://sh4-fup.zip"

S = "${WORKDIR}"

do_install () {
        install -d ${D}/${sbindir}
        install -m 775 ${S}/fup ${D}/${sbindir}
}

INSANE_SKIP_${PN} += "ldflags"
