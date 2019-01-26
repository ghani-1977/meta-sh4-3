require stlirc.inc

COMPATIBLE_MACHINE = "cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2|cuberevo_9500hd"

SRC_URI_append += "\
           file://lircd_ipbox55.conf \
           file://stlirc_sh4.patch \
           file://lircd_sh4.init \
          "

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install ${WORKDIR}/lircexec.init ${D}${sysconfdir}/init.d/lircexec
    install -d ${D}${datadir}/lirc/
    cp -r ${S}/remotes ${D}${datadir}/lirc/
    rm -rf ${D}/dev
    rm -rf  ${D}/bin/pronto2lirc
    install ${WORKDIR}/lircd_sh4.init ${D}${sysconfdir}/init.d/lircd
    install -m 0644 ${WORKDIR}/lircd_ipbox55.conf ${D}${sysconfdir}/lircd.conf
}