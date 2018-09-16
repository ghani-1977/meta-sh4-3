FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

SRC_URI += " file://glibc-fix-with-old-kernel.patch \
             file://sh4-trap.patch \
"

