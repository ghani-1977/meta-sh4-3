DESCRIPTION = "A tool for SH4 remotes"

require sh4-apps.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(adb_box|adb_2850|arivalink200|atemio520|atemio530|atevio7500|cuberevo|cuberevo_250hd|cuberevo_2000hd|cuberevo_3000hd|cuberevo_mini|cuberevo_mini2|cuberevo_9500hd|fortis_hdbox|hs7110|hs7119|hs7420|hs7429|hs7810a|hs7819|ipbox55|ipbox99|ipbox9900|octagon1008|pace7241|sagemcom88|tf7700|ufc960|ufs910|ufs912|ufs913|ufs922|vip1_v2|vip2_v1|vitamin_hd5000|qboxhd|qboxhd_mini|forever_2424hd|forever_3434hd|forever_9898hd|forever_nanosmart)$"

SRC_URI_append = " file://evremote2.sh"

LDFLAGS += "-lpthread -lrt"

do_install_append () {
        install -d ${D}/${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/evremote2.sh ${D}${sysconfdir}/init.d
        if [ "${MACHINE}" = "adb_box" -o "${MACHINE}" = "adb_2850" ]; then
            install -d ${D}/${sysconfdir}/rc3.d
            ln -sf ../init.d/evremote2.sh ${D}${sysconfdir}/rc3.d/S22evremote2
        else
            install -d ${D}/${sysconfdir}/rcS.d
            ln -sf ../init.d/evremote2.sh ${D}${sysconfdir}/rcS.d/S40evremote2
        fi
}
