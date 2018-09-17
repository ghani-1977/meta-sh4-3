PREFERRED_PROVIDER_virtual/kernel = "linux-fulan-atemio"

AUDIOELF = "audio_7111.elf"
VIDEOELF = "video_7111.elf"

SOC_FAMILY = "sti7111"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    stlinux24-sh4-stx7111-fdma-firmware \
    stlinux24-sh4-stmfb-firmware-stx7111 \
"

#What we need
#extra/frontcontroller/cn_micom/cn_micom.ko /lib/modules/
#extra/frontends/lnb/lnb.ko /lib/modules/
#extra/frontends/*.ko /lib/modules/
#extra/stgfb/stmfb/stmcore-display-sti7111.ko /lib/modules/
#keymap_ufs910.xml /usr/local/share/enigma2/keymap.xml
