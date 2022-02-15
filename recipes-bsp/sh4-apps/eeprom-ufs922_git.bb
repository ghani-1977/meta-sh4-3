SUMMARY = "${MACHINE} tool to read MAC address"

SH4APPBIN = "eeprom"

require sh4-apps.inc
require sh4-bin-install.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(ufs922)$"
