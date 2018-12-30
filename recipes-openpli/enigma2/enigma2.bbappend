CXXFLAGS_append += " -std=c++11 -fPIC -fno-strict-aliasing "

MAINTAINER = "Open Vision Developers"

DEPENDS_append_sh4 += "\
	libmme-image libmme-host \
	"

RDEPENDS_${PN}_append_sh4 += "\
	libmme-host \
	"

EXTRA_OECONF_append_sh4 += "\
	--enable-${MACHINE} --with-lcd \
	"

PV_sh4 = "sh4+git${SRCPV}"
PKGV_sh4 = "sh4+git${GITPKGV}"

SRC_URI_sh4 = "git://github.com/OpenVisionE2/enigma2-openpli-sh4.git;branch=develop;name=enigma2"
