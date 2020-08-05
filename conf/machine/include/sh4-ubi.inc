IMAGE_FSTYPES ?= "ubi"

MKUBIFS_ARGS = "${@bb.utils.contains("MACHINE_FEATURES", "4thgsh4", "-m 2048 -e 129024 -c 1456 -x zlib", "-m 2048 -e 129024 -c 1024 -x zlib", d)}"
UBINIZE_ARGS = "-m 2048 -p 128KiB -s 512"

EXTRA_IMAGECMD_COMPAT = " --eraseblock=0x20000 -n -l "

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	mtd-utils-ubifs \
	"

IMAGE_CMD_ubi_prepend = " \
    rm -rf ${IMAGE_ROOTFS}/tmp/*; \
    "
