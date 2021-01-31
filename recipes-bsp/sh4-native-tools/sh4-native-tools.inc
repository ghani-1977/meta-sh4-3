HOMEPAGE = "https://github.com/OpenVisionE2/sh4-native-tools"
SECTION = "base"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit autotools gitpkgv native

COMPATIBLE_MACHINE = "^(adb_box|adb_2850|arivalink200|atemio520|atemio530|atevio7500|cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2|cuberevo_9500hd|pace7241|vip1_v1|vip1_v2|vip2|fortis_hdbox|hl101|hs7110|hs7119|hs7420|hs7429|hs7810a|hs7819|ipbox55|ipbox99|ipbox9900|sagemcom88|octagon1008|spark|spark7162|tf7700|ufc960|ufs910|ufs912|ufs913|ufs922|vitamin_hd5000|qboxhd|qboxhd_mini|forever_2424hd|forever_3434hd|forever_9898hd|forever_nanosmart|opt9600)$"

SRCREV = "${AUTOREV}"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://git@github.com/OpenVisionE2/sh4-native-tools.git;protocol=ssh"

S = "${WORKDIR}/git/tools/${@d.getVar('PN',1).replace('-native', '')}"

EXTRA_OECONF = "--enable-silent-rules --prefix="
LDFLAGS += "-lpthread -lrt"

do_configure_prepend() {
	touch ${S}/NEWS
	touch ${S}/README
	touch ${S}/AUTHORS
	touch ${S}/COPYING
	touch ${S}/ChangeLog
}

BBCLASSEXTEND = "native"

do_configure[nostamp] = "1"
