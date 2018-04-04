DEPENDS_append_sh4 = " \
	libmmeimage libmme-host libeplayer3 \
	"

RDEPENDS_${PN}_append_sh4 = " \
	libmme-host \
	libeplayer3 \
	"

EXTRA_OECONF_append_sh4 = "\
	--enable-${MACHINE} --with-lcd --enable-gstreamer --enable-libeplayer3 \
	"

SRC_URI_sh4 = "${GITHUB_URI}/PLi-metas/enigma2-openpli-fulan.git;branch=master"
