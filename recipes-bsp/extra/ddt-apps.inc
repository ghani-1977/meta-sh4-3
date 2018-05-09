HOMEPAGE = "https://github/Duckbox-Developers/apps"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=eb723b61539feef013de476e68b5c50a"
DEPENDS = "fulan-dvb-modules-${MACHINE}"

SRCREV = "${AUTOREV}"
inherit gitpkgv

PV = "2.1+git${SRCPV}"
PKGV = "2.1+git${GITPKGV}"

SRC_URI = " \
    git://github.com/PLi-metas/apps.git;protocol=git \
    file://libtool_dont_stop.patch \
"

S = "${WORKDIR}/git/tools"

inherit autotools 

EXTRA_OECONF = "--enable-silent-rules --prefix="
LDFLAGS += "-lpthread -lrt"
EXTRA_OEMAKE = " DRIVER_TOPDIR=${STAGING_KERNEL_DIR}"
CFLAGS_append = " -I${STAGING_KERNEL_DIR}/multicom/include"

do_configure() {
    cd ${S}
    ./autogen.sh
    oe_runconf
}

do_compile() {
    cd ${S}
    oe_runmake  'DESTDIR=${D}' 'SUBDIRS=${@d.getVar('PN',1).replace('-', '_')}' 
}

do_install() {
    cd ${S}
    oe_runmake  'DESTDIR=${D}' 'SUBDIRS=${@d.getVar('PN',1).replace('-', '_')}' install
}

