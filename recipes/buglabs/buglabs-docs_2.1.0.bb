DESCRIPTION = "Documentation for BUG"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "file://BUG_Guide.pdf \
	file://README \
	"

S = ${WORKDIR}

PACKAGE_ARCH = "all"

do_install() {
    install -d ${D}/root
    install -m 0644 README* ${D}/root/
    install -m 0644 BUG_Guide.pdf* ${D}/root/
}
