require stlirc.inc

COMPATIBLE_MACHINE = "adb_box|arivalink200|ipbox55|ipbox99|ipbox9900|pace7241|sagemcom88|ufs910|vip1_v2|vip2_v1"

SRC_URI_append += "\
           file://lircd_${MACHINE}.conf \
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
    install -m 0644 ${WORKDIR}/lircd_${MACHINE}.conf ${D}${sysconfdir}/lircd.conf
}