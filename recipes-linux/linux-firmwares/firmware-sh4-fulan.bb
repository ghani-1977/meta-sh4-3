SUMMARY = "Firmware files for sh4 fulan"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "https://raw.githubusercontent.com/PLi-metas/linux-firmwares/master/sh4-firmwares.zip"

SRC_URI[md5sum] = "61b4877cf8170832d82ec876cf6b0a56"
SRC_URI[sha256sum] = "869b07c99b77a54449ed766bdcd6ea219d1860129fe801f2d92d5d515bff69f1"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

do_install_cuberevo() {
    install -d ${D}${base_libdir}/firmware
    install -m 0644 dvb-fe-cx24116.fw ${D}${base_libdir}/firmware/
    install -m 0644 dvb-fe-stv6306.fw ${D}${base_libdir}/firmware/
}

do_install_cuberevo250hd() {
    install -d ${D}${base_libdir}/firmware
    install -m 0644 dvb-fe-cx24116.fw ${D}${base_libdir}/firmware/
    install -m 0644 dvb-fe-stv6306.fw ${D}${base_libdir}/firmware/
}

do_install_cuberevo2000hd() {
    install -d ${D}${base_libdir}/firmware
    install -m 0644 dvb-fe-cx24116.fw ${D}${base_libdir}/firmware/
    install -m 0644 dvb-fe-stv6306.fw ${D}${base_libdir}/firmware/
}

do_install_cuberevo3000hd() {
    install -d ${D}${base_libdir}/firmware
    install -m 0644 dvb-fe-cx24116.fw ${D}${base_libdir}/firmware/
    install -m 0644 dvb-fe-stv6306.fw ${D}${base_libdir}/firmware/
}

do_install_cuberevomini() {
    install -d ${D}${base_libdir}/firmware
    install -m 0644 dvb-fe-cx24116.fw ${D}${base_libdir}/firmware/
    install -m 0644 dvb-fe-stv6306.fw ${D}${base_libdir}/firmware/
}

do_install_cuberevomini2() {
    install -d ${D}${base_libdir}/firmware
    install -m 0644 dvb-fe-cx24116.fw ${D}${base_libdir}/firmware/
    install -m 0644 dvb-fe-stv6306.fw ${D}${base_libdir}/firmware/
}