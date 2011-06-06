DESCRIPTION = "Documentation for BUG"
LICENSE = "GPL"
PR = "r2"

SRC_URI = " \
  file://BUG_Guide.pdf \
	file://README \
"

FILES_${PN} = " \
/ \
"


PACKAGE_ARCH = "all"

do_install() {
    install -d ${D}/home/root
    install -m 0644 ${WORKDIR}/README ${D}/home/root/
    install -m 0644 ${WORKDIR}/BUG_Guide.pdf ${D}/home/root/
}
