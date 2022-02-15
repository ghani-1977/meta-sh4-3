SUMMARY = "${BOX_BRAND} tool to read MAC address"

SH4APPBIN = "eeprom"

require sh4-apps.inc
require sh4-bin-install.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(ipbox55|ipbox99|ipbox9900)$"
