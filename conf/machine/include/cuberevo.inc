#MTD_KERNEL = "mtd5"
#MTD_ROOTFS = "mtd6"
#KERNEL_FILE = "uImage"
#ROOTFS_FILE = "usb_update.img"

SOC_FAMILY = "sti7109"

MACHINE_FEATURES += "cuberevo"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	stlinux24-sh4-stx7109-fdma-firmware \
	firmware-sh4-fulan \
"

#What we need
#extra/stgfb/stmfb/stmcore-display-stx7109c3.ko /lib/modules/
#extra/frontcontroller/ipbox/micom.ko /lib/modules/
#extra/frontends/multituner/*.ko /lib/modules/
#kernel/drivers/media/dvb/frontends/dvb-pll.ko /lib/modules/