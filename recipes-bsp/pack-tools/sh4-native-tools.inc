HOMEPAGE = "https://github.com/OpenVisionE2/sh4-native-tools"
SECTION = "base"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit autotools gitpkgv native

SRCREV = "${AUTOREV}"

PV = "1.1+git${SRCPV}"
PKGV = "1.1+git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/sh4-native-tools.git;protocol=git"

S = "${WORKDIR}/git/tools/${@d.getVar('PN',1).replace('-', '_')}"

EXTRA_OECONF = "--enable-silent-rules --prefix="
LDFLAGS += "-lpthread -lrt"
EXTRA_OEMAKE = " DRIVER_TOPDIR=${STAGING_KERNEL_DIR}"
CFLAGS_append = " -I${STAGING_KERNEL_DIR}/multicom/include"

do_configure_prepend() {
    touch ${S}/NEWS
    touch ${S}/README
    touch ${S}/AUTHORS
    touch ${S}/COPYING
    touch ${S}/ChangeLog
}
