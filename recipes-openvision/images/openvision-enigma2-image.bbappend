ENIGMA2_PLUGINS_append_sh4 += "\
	kernel-module-block2mtd libcrypto \
	enigma2-plugin-systemplugins-sparkvfdcontrol \
	${@bb.utils.contains("MACHINE_FEATURES", "sh4booster", "enigma2-plugin-systemplugins-sh4boostercontrol", "", d)} \
	"
