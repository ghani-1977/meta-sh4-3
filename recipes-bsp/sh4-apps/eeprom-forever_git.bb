SUMMARY = "${BOX_BRAND} tool to read MAC address"

SH4APPBIN = "eeprom"

require sh4-apps.inc
require sh4-bin-install.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(forever_2424hd|forever_3434hd|forever_9898hd|forever_nanosmart)$"
