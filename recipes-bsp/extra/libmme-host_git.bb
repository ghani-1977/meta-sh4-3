DESCRIPTION = "MME image library"

require ddt-apps.inc

EXTRA_OECONF_append = " \
	 --with-multicom=${STAGING_KERNEL_DIR}/multicom \
	"

# Don't add libmme_host.so as it enables jpeg hardware acceleration, which fails on some firmware

do_install_append() {
	rm -f ${D}${libdir}/libmme_host.so
}

# FILES_${PN} += "${libdir}/libmme_host.so"
FILES_${PN}-dev = "${libdir}/libmme_host.la"

INSANE_SKIP_${PN} += "dev-so"
