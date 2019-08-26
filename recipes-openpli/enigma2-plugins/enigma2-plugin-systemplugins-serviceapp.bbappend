FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#SRC_URI_append_sh4 += "\
#	file://enigma2-serviceapp-0.1.patch \
#	"

CXXFLAGS_append_sh4 += " -std=c++11 -fPIC -fno-strict-aliasing "

pkg_postinst_${PN}_sh4() {
	touch $D${sysconfdir}/enigma2/serviceapp_replaceservicemp3
	if [ -e $D${sysconfdir}/enigma2/settings ]
	then
		sed -i '/config.plugins.serviceapp.servicemp3.player=/d' $D${sysconfdir}/enigma2/settings
		sed -i '/config.plugins.serviceapp.servicemp3.replace=/d' $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" >> $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	else
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" > $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	fi
}
