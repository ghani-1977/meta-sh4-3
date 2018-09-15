#MTD_KERNEL = "mtd5"
#MTD_ROOTFS = "mtd6"
KERNEL_FILE = "uImage"
#ROOTFS_FILE = "usb_update.img"

SOC_FAMILY = "sti7109"

MACHINE_FEATURES += "ipbox"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	stlinux24-sh4-stx7109-fdma-firmware \
"

#What we need
#$(SILENT)cp $(TARGET_DIR)/lib/modules/$(KERNEL_VER)/extra/frontends/*.ko $(RELEASE_DIR)/lib/modules/
#$(SILENT)cp $(TARGET_DIR)/lib/modules/$(KERNEL_VER)/extra/stgfb/stmfb/stmcore-display-stx7109c3.ko $(RELEASE_DIR)/lib/modules/
#$(SILENT)cp $(TARGET_DIR)/lib/modules/$(KERNEL_VER)/extra/siinfo/siinfo.ko $(RELEASE_DIR)/lib/modules/
#$(SILENT)rm -f $(RELEASE_DIR)/lib/firmware/*
#$(SILENT)rm -f $(RELEASE_DIR)/lib/modules/boxtype.ko
#$(SILENT)rm -f $(RELEASE_DIR)/lib/modules/stmvbi.ko
#$(SILENT)rm -f $(RELEASE_DIR)/lib/modules/stmvout.ko