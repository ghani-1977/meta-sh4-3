require linux-sh4.inc

COMPATIBLE_MACHINE = "^(spark7162|sagemcom88|atevio7500|ufs913|pace7241|opt9600prima)$"

SRC_URI_append = " \
	file://linux-sh4-${MACHINE}_setup_stm24_${STM_PATCH_STR}.patch;patch=1 \
	${@bb.utils.contains_any("MACHINE", "spark7162 sagemcom88 atevio7500 opt9600prima", "file://linux-sh4-stmmac_stm24_${STM_PATCH_STR}.patch;patch=1 file://linux-sh4-lmb_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
	${@bb.utils.contains("MACHINE", "sagemcom88", "file://linux-sh4-${MACHINE}_sound_stm24_${STM_PATCH_STR}.patch;patch=1", "", d)} \
	"
