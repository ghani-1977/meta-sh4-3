CXXFLAGS_append += " -std=c++11 -fPIC -fno-strict-aliasing "

DEPENDS_append_sh4 += "\
	libmme-image libmme-host \
	"

RDEPENDS_${PN}_append_sh4 += "\
	libmme-host \
	"

EXTRA_OECONF_append_sh4 += "\
	--enable-${MACHINE} --with-lcd \
	"

SRC_URI_sh4 = "${GITHUB_URI}/PLi-metas/enigma2-openpli-fulan.git;branch=master;name=enigma2"
SRC_URI_remove_sh4 += "\
	file://defaultskin.patch \
	"
