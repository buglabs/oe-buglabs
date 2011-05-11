# This recipe simply downloads the binary jar from the apache mirror and installs it into the bundle directory.
SRC_URI = "${APACHE_MIRROR}/felix/${PN}-${PV}.jar"

PACKAGE_ARCH = "all"
S = ${WORKDIR}
datadir_java ?= "${datadir}/java"
bundledir = "${datadir_java}/bundle"

FILES_${PN} = "${bundledir}/${PN}.jar"

# Copy the jar to the work dir
do_unpack() {
	install -m 0644 ${DL_DIR}/${PN}-${PV}.jar ${S}
}

# Do nothing
do_build() {
	:
}

# Do nothing
do_compile() {
	:
}

# Copy the jar from the work dir to the destination on the rootfs
do_install() {
	install -d ${D}${bundledir}
	install -m 0644 ${S}/${PN}-${PV}.jar ${D}${bundledir}/${PN}.jar
}

