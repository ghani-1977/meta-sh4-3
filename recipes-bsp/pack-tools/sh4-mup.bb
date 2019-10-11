SUMMARY = "sh4 mup tool for creating flashable image"
SECTION = "console/utils"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit native

SRC_URI = "file://sh4-mup.zip"

S = "${WORKDIR}"

do_install () {
        install -d ${D}/${sbindir}
        install -m 775 ${S}/mup ${D}/${sbindir}
}

INSANE_SKIP_${PN} += "ldflags"
