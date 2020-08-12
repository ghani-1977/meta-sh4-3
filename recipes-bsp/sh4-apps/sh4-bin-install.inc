do_install_append() {
	install -d ${D}${base_bindir}
	install -m 0755 ${WORKDIR}/build/${PN} ${D}${base_bindir}/
}

FILES_${PN} = "${base_bindir}"
