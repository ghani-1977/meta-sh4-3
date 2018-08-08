IMAGE_INSTALL_remove_sh4 += "\
	wscan \
	"

ENIGMA2_PLUGINS_append_sh4 += "\
	kernel-module-block2mtd libcrypto \
	enigma2-plugin-systemplugins-sparkvfdcontrol \
	enigma2-plugin-systemplugins-sh4osdadjustment \
	enigma2-plugin-systemplugins-sh4boostercontrol \
	${@bb.utils.contains("MACHINE_FEATURES", "spark7162", "enigma2-plugin-systemplugins-uniontunertype", "", d)} \
	"

ENIGMA2_PLUGINS_remove_sh4 += "\
	enigma2-plugin-systemplugins-osdpositionsetup \
"
