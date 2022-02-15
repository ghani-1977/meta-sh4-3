SUMMARY = "DGS tool to read MAC address"

SH4APPBIN = "eeprom"

require sh4-apps.inc
require sh4-bin-install.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2)$"
