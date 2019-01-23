DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
DESCRIPTION_append_stlirc = " This package contains the lirc daemon, libraries and tools."
DESCRIPTION_append_stlirc-exec = " This package contains a daemon that runs programs on IR signals."
DESCRIPTION_append_stlirc-remotes = " This package contains some config files for remotes."
SECTION = "console/network"
PRIORITY = "optional"
HOMEPAGE = "http://www.lirc.org"
LICENSE = "GPLv2"
DEPENDS = "virtual/kernel"
RDEPENDS_lirc-exec = "stlirc"
RRECOMMENDS_${PN} = "stlirc-exec kernel-module-uinput"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "adb_box|arivalink200|atemio520|atemio530|atevio7500|cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2|cuberevo_9500hd|vip1_v2|pace7241|vip2_v1|fortis_hdbox|hl101|hs7110|hs7119|hs7420|hs7429|hs7810a|hs7819|ipbox55|ipbox99|ipbox9900|sagemcom88|octagon1008|spark|spark7162|tf7700|ufc960|ufs910|ufs912|ufs913|ufs922|vitamin_hd5000"

RCONFLICTS_${PN} = "lirc"
RCONFLICTS_stlirc-exec = "lirc-exec"
RCONFLICTS_stlirc-remotes = "lirc-remotes"
RREPLACES_${PN} = "lirc"
RREPLACES_stlirc-exec = "lirc-exec"
RREPLACES_stlirc-remotes = "lirc-remotes"
RPROVIDES_${PN} += "lirc"
RPROVIDES_${PN}-exec += "lirc-exec"
RPROVIDES_${PN}-remotes += "lirc-remotes"
PROVIDES += "lirc lirc-exec lirc-remotes"

SRC_URI = "https://sourceforge.net/projects/lirc/files/LIRC/0.9.0/lirc-${PV}.tar.bz2 \
           file://fix-libusb-config.patch \
           file://${PN}.patch \
           file://lircd_${MACHINE}.conf \
           file://lircmd.init \
           file://lircexec.init \
          "
SRC_URI_append_hl101 += "\
           file://lircd_spark.init \
           file://lircd.conf.03_00_01 \
           file://lircd.conf.03_00_02 \
           file://lircd.conf.03_00_07 \
          "
SRC_URI_append_spark += "\
           file://lircd_spark.init \
           file://lircd.conf.09_00_07 \
           file://lircd.conf.09_00_08 \
           file://lircd.conf.09_00_0B \
           file://lircd.conf.09_00_1D \
           file://lircd.conf.09_00_0D \
          "
SRC_URI_append += "\
           file://lircd_sh4.init \
          "
SRC_URI[md5sum] = "b232aef26f23fe33ea8305d276637086"
SRC_URI[sha256sum] = "6323afae6ad498d4369675f77ec3dbb680fe661bea586aa296e67f2e2daba4ff"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

S = "${WORKDIR}/lirc-${PV}"

PARALLEL_MAKE = ""

EXTRA_OECONF += "--with-kerneldir=${STAGING_KERNEL_BUILDDIR} \
                 ${DRIVER} \
                 --without-x \
                 --with-driver=userspace \
                 --enable-sandboxed \
                "

inherit autotools module-base update-rc.d

INITSCRIPT_PACKAGES = "stlirc stlirc-exec"
INITSCRIPT_NAME = "lircd"
INITSCRIPT_PARAMS = "defaults 20"
INITSCRIPT_NAME_stlirc-exec = "lircexec"
INITSCRIPT_PARAMS_stlirc-exec = "defaults 21"

EXTRA_OEMAKE = 'SUBDIRS="daemons tools"'

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install ${WORKDIR}/lircexec.init ${D}${sysconfdir}/init.d/lircexec
    install -d ${D}${datadir}/lirc/
    cp -r ${S}/remotes ${D}${datadir}/lirc/
    rm -rf ${D}/dev
    rm -rf  ${D}/bin/pronto2lirc
    if [ "${MACHINE}" = "hl101" ]; then
        install ${WORKDIR}/lircd_spark.init ${D}${sysconfdir}/init.d/lircd
        install -m 0644 ${WORKDIR}/lircd.conf.03_00_* ${D}${sysconfdir}
    elif [ "${MACHINE}" = "spark" ]; then
        install ${WORKDIR}/lircd_spark.init ${D}${sysconfdir}/init.d/lircd
        install -m 0644 ${WORKDIR}/lircd.conf.09_00_* ${D}${sysconfdir}
    else
        install ${WORKDIR}/lircd_sh4.init ${D}${sysconfdir}/init.d/lircd
    fi
    install -m 0644 ${WORKDIR}/lircd_${MACHINE}.conf ${D}${sysconfdir}/lircd.conf
}

PACKAGES =+ "stlirc-exec stlirc-remotes"

FILES_${PN}-dbg += "${bindir}/.debug ${sbindir}/.debug"
FILES_${PN}-dev += "${libdir}/liblirc_client.so"
FILES_${PN} = "${bindir} ${sbindir} ${libdir}/lib*.so.* ${sysconfdir} ${exec_prefix}/var"
FILES_stlirc-exec = "${bindir}/irexec ${sysconfdir}/init.d/lircexec"
FILES_stlirc-remotes = "${datadir}/lirc/remotes"
