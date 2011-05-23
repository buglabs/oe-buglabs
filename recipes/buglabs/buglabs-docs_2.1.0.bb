DESCRIPTION = "Documentation for BUG"
LICENSE = "GPL"
PR = "r1"

SRC_URI = " \
  file://BUG_Guide.pdf \
	file://README \
"

FILES_${PN} = " \
  /home/root/BUG_Guide.pdf \
  /home/root/README \
"

S = ${WORKDIR}

PACKAGE_ARCH = "all"

do_fetch() {
  echo "HI THERE"
  :
}

do_install() {
    install -d ${D}/home/root
    install -m 0644 ${S}/README* ${D}/home/root/
    install -m 0644 ${S}/BUG_Guide.pdf* ${D}/home/root/
}
