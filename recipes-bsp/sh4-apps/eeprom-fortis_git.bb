SUMMARY = "Fortis tool to read MAC address"

SH4APPBIN = "eeprom"

require sh4-apps.inc
require sh4-bin-install.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(hs7110|hs7119|hs7420|hs7429|hs7810a|hs7819)$"
