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
