require fulan-dvb-modules.inc

SRCDATE = "20180824"

COMPATIBLE_MACHINE = "spark"

do_install_append_spark() {
    find ${D} -name stmcore-display-sti7106.ko | xargs -r rm # we don't have a 7106 chip
}
