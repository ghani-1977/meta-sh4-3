SUMMARY = "sh4 mkdnimg tool for creating flashable image"
SECTION = "console/utils"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit native

SRC_URI = "file://mkdnimg"

S = "${WORKDIR}"

do_install () {
        install -d ${D}/${sbindir}
        install -m 775 ${S}/mkdnimg ${D}/${sbindir}
}
