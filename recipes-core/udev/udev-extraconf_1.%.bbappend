FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
#Add your box if there are mounting problems.
#COMPATIBLE_MACHINE = "^(hl101|cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2|cuberevo_9500hd|tf7700|vip1_v2|vip2_v1)$"

SRC_URI_append_sh4 = "file://usbhd-automount.rules"

do_install_append() {
	install -m 0644 ${WORKDIR}/usbhd-automount.rules ${D}${sysconfdir}/udev/rules.d/usbhd-automount.rules
}
