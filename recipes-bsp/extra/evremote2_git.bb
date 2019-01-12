require ddt-apps.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

DESCRIPTION = "A tool for SH4 remotes"

SRC_URI_append += "file://evremote2.sh \
                   file://remove-branding.patch \
"

LDFLAGS += "-lpthread -lrt"

do_install_append () {
        install -d ${D}/${sysconfdir}/init.d
        install -d ${D}/${sysconfdir}/rcS.d
        install -m 0755 ${WORKDIR}/evremote2.sh ${D}${sysconfdir}/init.d
        ln -sf ../init.d/evremote2.sh ${D}${sysconfdir}/rcS.d/S40evremote2
}

