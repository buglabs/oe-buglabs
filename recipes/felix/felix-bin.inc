# This is 
SRC_URI = "${APACHE_MIRROR}/felix/${PN}-${PV}.jar"

S = ${WORKDIR}
datadir_java ?= "${datadir}/java"
bundledir = "${datadir_java}/bundle"

FILES_${PN} = "${bundledir}/${PN}.jar"
PACKAGE_ARCH = "all"

do_unpack() {
	install -m 0644 ${DL_DIR}/${PN}-${PV}.jar ${S}
}

do_build() {
	:
}

do_compile() {
	:
}

do_install() {
	install -d ${D}${bundledir}
	install -m 0644 ${S}/${PN}-${PV}.jar ${D}${bundledir}/${PN}.jar
}

