DESCRIPTION = "bnd is a swiss army knife for OSGi."
LICENSE = "AL2.0"
AUTHOR = "aQute"
HOMEPAGE = "http://www.aqute.biz/Bnd/Bnd"
PR = "r0"

BRANCH = "master"
SRC_URI = "git://github.com/bnd/bnd.git;protocol=git;branch=${BRANCH} \
			file://bnd \
			"
SRCREV = ${AUTOREV}

S = "${WORKDIR}/git"

inherit java-library java-native

DEPENDS = "ant-native"

do_removebinaries() {
  :
}

do_compile() {
  ant 
  cp cnf/repo/biz.aQute.bnd/biz.aQute.bnd-latest.jar bnd-${PV}.jar
  cp cnf/repo/biz.aQute.bnd/biz.aQute.bnd-latest.jar bnd.jar
}

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/bnd ${D}${bindir}
}

SRC_URI[md5sum] = "2a44ff60456cf67bb83771cfcedb8e33"
SRC_URI[sha256sum] = "1a2fceea38f04e6fea0c0cb8ad7312dc948004af4d9308b5e630d299d89dfb38"
