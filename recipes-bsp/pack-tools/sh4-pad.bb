SUMMARY = "sh4 pad tool for creating flashable image"
SECTION = "console/utils"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit native

SRC_URI = "file://sh4-pad.zip"

S = "${WORKDIR}"

do_install () {
        install -d ${D}/${sbindir}
        install -m 775 ${S}/pad ${D}/${sbindir}
}

INSANE_SKIP_${PN} += "ldflags"
