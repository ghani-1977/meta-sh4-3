require stlirc.inc

COMPATIBLE_MACHINE = "spark|spark7162"

SRC_URI_append += "\
           file://lircd_${MACHINE}.conf \
           file://stlirc_spark.patch \
           file://lircd_spark.init \
           file://lircd.conf.09_00_07 \
           file://lircd.conf.09_00_08 \
           file://lircd.conf.09_00_0B \
           file://lircd.conf.09_00_1D \
           file://lircd.conf.09_00_0D \
          "

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install ${WORKDIR}/lircexec.init ${D}${sysconfdir}/init.d/lircexec
    install -d ${D}${datadir}/lirc/
    cp -r ${S}/remotes ${D}${datadir}/lirc/
    rm -rf ${D}/dev
    rm -rf  ${D}/bin/pronto2lirc
    install ${WORKDIR}/lircd_spark.init ${D}${sysconfdir}/init.d/lircd
    install -m 0644 ${WORKDIR}/lircd.conf.09_00_* ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/lircd_${MACHINE}.conf ${D}${sysconfdir}/lircd.conf
}