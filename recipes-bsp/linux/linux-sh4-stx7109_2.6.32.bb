require linux-sh4.inc

COMPATIBLE_MACHINE = "^(cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2|cuberevo_9500hd|ipbox55|ipbox99|ipbox9900|arivalink200|vip1_v1|vip1_v2|vip2|hl101|octagon1008|tf7700|fortis_hdbox|opt9600|ufs922|ufc960)$"

SRC_URI_append = " \
	file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
	${@bb.utils.contains("BOX_BRAND", "ipbox", "file://linux-sh4-ipbox_bdinfo_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
	${@bb.utils.contains("MACHINE", "cuberevo_250hd", "file://linux-sh4-${MACHINE}_sound_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
	${@bb.utils.contains_any("MACHINE", "ipbox9900 arivalink200", "file://linux-sh4-ipbox_dvb_ca_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
	${@bb.utils.contains_any("MACHINE", "ufs922 ufc960", "file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 file://linux-sh4-fortis_hdbox_i2c_st40_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
	${@bb.utils.contains_any("MACHINE", "vip1_v1 vip1_v2 vip2 hl101 octagon1008 tf7700 fortis_hdbox opt9600", "file://linux-usbwait123_stm24.patch;patch=1 file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
	"
