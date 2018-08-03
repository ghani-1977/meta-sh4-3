SRC_URI_sh4 = "git://github.com/christophecvr/gstreamer1.0-plugin-multibox-dvbmediasink;branch=openatv-dev;protocol=git file://introduce-new-signal-get-video-codec.patch"

EXTRA_OECONF = "${DVBMEDIASINK_CONFIG} --with-gstversion=${GSTVERSION} --with-machine=${MACHINE}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
