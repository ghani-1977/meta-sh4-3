DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
DESCRIPTION_append_${PN} = " This package contains the lirc daemon, libraries and tools."
DESCRIPTION_append_${PN}-exec = " This package contains a daemon that runs programs on IR signals."
DESCRIPTION_append_${PN}-remotes = " This package contains some config files for remotes."
SECTION = "console/network"
PRIORITY = "optional"
HOMEPAGE = "http://www.lirc.org"
LICENSE = "GPLv2"
DEPENDS = "virtual/kernel"
RDEPENDS_${PN}-exec = "${PN}"
RRECOMMENDS_${PN} = "${PN}-exec kernel-module-uinput"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

RCONFLICTS_${PN} = "lirc"
RCONFLICTS_${PN}-exec = "lirc-exec"
RCONFLICTS_${PN}-remotes = "lirc-remotes"
RREPLACES_${PN} = "lirc"
RREPLACES_${PN}-exec = "lirc-exec"
RREPLACES_${PN}-remotes = "lirc-remotes"
RPROVIDES_${PN} += "lirc"
RPROVIDES_${PN}-exec += "lirc-exec"
RPROVIDES_${PN}-remotes += "lirc-remotes"
PROVIDES += "lirc lirc-exec lirc-remotes"

SRC_URI = "https://sourceforge.net/projects/lirc/files/LIRC/0.9.0/lirc-${PV}.tar.bz2 \
           file://fix-libusb-config.patch \
           file://lircmd.init \
           file://lircexec.init \
          "

SRC_URI[md5sum] = "b232aef26f23fe33ea8305d276637086"
SRC_URI[sha256sum] = "6323afae6ad498d4369675f77ec3dbb680fe661bea586aa296e67f2e2daba4ff"

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
INITSCRIPT_NAME_${PN}-exec = "lircexec"
INITSCRIPT_PARAMS_${PN}-exec = "defaults 21"

EXTRA_OEMAKE = 'SUBDIRS="daemons tools"'

PACKAGES =+ "${PN}-exec ${PN}-remotes"

FILES_${PN}-dbg += "${bindir}/.debug ${sbindir}/.debug"
FILES_${PN}-dev += "${libdir}/liblirc_client.so"
FILES_${PN} = "${bindir} ${sbindir} ${libdir}/lib*.so.* ${sysconfdir} ${exec_prefix}/var"
FILES_${PN}-exec = "${bindir}/irexec ${sysconfdir}/init.d/lircexec"
FILES_${PN}-remotes = "${datadir}/lirc/remotes"
