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

COMPATIBLE_MACHINE = "adb_box|arivalink200|atemio520|atemio530|atevio7500|cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2|fortis_hdbox|hl101|hs7110|hs7119|hs7420|hs7429|hs7810a|hs7819|ipbox55|ipbox99|ipbox9900|sagemcom88|octagon1008|spark|spark7162|tf7700|ufc960|ufs910|ufs912|ufs913|ufs922|vitamin_hd5000"

RCONFLICTS_${PN} = "lirc"
RCONFLICTS_stlirc-exec = "lirc-exec"
RCONFLICTS_stlirc-remotes = "lirc-remotes"
RREPLACES_${PN} = "lirc"
RREPLACES_stlirc-exec = "lirc-exec"
RREPLACES_stlirc-remotes = "lirc-remotes"

SRC_URI = "http://sourceforge.mirrorservice.org/l/li/lirc/LIRC/0.9.0/lirc-${PV}.tar.bz2 \
           file://fix-libusb-config.patch;apply=no \
           file://${PN}.patch;apply=no \
           file://lircd_${MACHINE}.conf \
           file://lircd.conf.09_00_07 \
           file://lircd.conf.09_00_08 \
           file://lircd.conf.09_00_0B \
           file://lircd.conf.09_00_1D \
           file://lircd.conf.09_00_0D \
           file://lircd.init \
           file://lircmd.init \
           file://lircexec.init \
          "
SRC_URI[md5sum] = "3afc84e79c0839823cc20e7a710dd06d"
SRC_URI[sha256sum] = "4e3f948fcdee6dce009171143f0cb7cd7be48593dd58138db4101a41f651a1dd"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

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
    install ${WORKDIR}/lircd.init ${D}${sysconfdir}/init.d/lircd
    install ${WORKDIR}/lircexec.init ${D}${sysconfdir}/init.d/lircexec
    install -d ${D}${datadir}/lirc/
    cp -r ${S}/remotes ${D}${datadir}/lirc/
    rm -rf ${D}/dev
    rm -rf  ${D}/bin/pronto2lirc
    install -m 0644 ${WORKDIR}/lircd.conf* ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/lircd_${MACHINE}.conf* ${D}${sysconfdir}/lircd.conf
}

PACKAGES =+ "stlirc-exec stlirc-remotes"

FILES_${PN}-dbg += "${bindir}/.debug ${sbindir}/.debug"
FILES_${PN}-dev += "${libdir}/liblirc_client.so"
FILES_${PN} = "${bindir} ${sbindir} ${libdir}/lib*.so.* ${sysconfdir} ${exec_prefix}/var"
FILES_stlirc-exec = "${bindir}/irexec ${sysconfdir}/init.d/lircexec"
FILES_stlirc-remotes = "${datadir}/lirc/remotes"
