DESCRIPTION = "STM ST-231 Coprocessor firmware"
LICENSE = "CLOSED"
SECTION = "base"
inherit allarch

#COMPATIBLE_MACHINE = "(spark|spark7162)"

# fix architecture mismatch QA error
INSANE_SKIP_${PN} = "arch"

SRC_URI = "file://audio_7100.elf \
    file://audio_7111.elf \
	file://audio_7162.elf \
	file://video_7100.elf \
	file://video_7109.elf \
	file://video_7111.elf \
	file://video_7162.elf \
"

# For audio_7109.elf just use audio_7100.elf

FILES_${PN} += "/boot"

do_install () {
    # Remove stuff from old packages if present
    if [ -e /etc/init.d/stslave.sh ] ; then
        rm /etc/init.d/stslave.sh
    fi
    if [ -e /etc/rcS.d/S03stslave ] ; then
        rm /etc/rcS.d/S03stslave
    fi
}

do_install_append_spark () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_spark7162 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7162.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7162.elf  ${D}/boot/video.elf
}

do_install_append_cuberevo () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_cuberevo250hd () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_cuberevo2000hd () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_cuberevo3000hd () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_cuberevo9500hd () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_cuberevomini () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_cuberevomini2 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_ipbox9900 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_ipbox99 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_ipbox55 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_ufs910 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7100.elf  ${D}/boot/video.elf
}

do_install_append_ufs912 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_ufs913 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7162.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7162.elf  ${D}/boot/video.elf
}

do_install_append_ufs922 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_ufc960 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_fortishdbox () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_atevio7500 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7162.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7162.elf  ${D}/boot/video.elf
}

do_install_append_sf1008 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_hs7110 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_hs7420 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_hs7429 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_hs7810a () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_hs7119 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_hs7819 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_atemio520 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_atemio530 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_hl101 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_adbbox () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7100.elf  ${D}/boot/video.elf
}

do_install_append_tf7700 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}

do_install_append_vitaminhd5000 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7111.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7111.elf  ${D}/boot/video.elf
}

do_install_append_sagemcom88 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7162.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7162.elf  ${D}/boot/video.elf
}

do_install_append_arivalink200 () {
    install -d ${D}/boot
    install -m 644 ${WORKDIR}/audio_7100.elf  ${D}/boot/audio.elf
    install -m 644 ${WORKDIR}/video_7109.elf  ${D}/boot/video.elf
}