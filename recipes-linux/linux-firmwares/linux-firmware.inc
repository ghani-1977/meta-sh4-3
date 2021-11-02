LICENSE = "CLOSED"

SRC_URI = "${GITHUB_URI}/mdamt/linux-firmware.git;protocol=https"
SRC_URI = "${GITHUB_URI}/BjornLee/linux-firmware.git;protocol=https"

S = "${WORKDIR}/git"

PACKAGES = "${PN}"

FILES_${PN} += "${nonarch_base_libdir}/firmware"

inherit allarch
