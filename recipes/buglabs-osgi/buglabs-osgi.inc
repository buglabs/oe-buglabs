OSGI_BASE_DIR ?= "/usr/share/osgi"

DEPENDS = "ant-native"

OSGI_BASE_DIR = "/usr/share/osgi"
SRC_URI="git://github.com/buglabs/bug-osgi.git;protocol=git;branch=${BRANCH}"
BRANCH = "master"

S = "${WORKDIR}/git/${PN}"

FILES_${PN} = "${OSGI_BASE_DIR}/bundle/${PN}.jar"
PACKAGE_ARCH = "all"

do_compile() {
	ant -Dbase.build.dir=${WORKDIR}/git/com.buglabs.osgi.build -Dcheckout.dir=${WORKDIR}/git -DexternalDirectory=${WORKDIR}/external -DdistDirectory=${WORKDIR}/dist create_dirs build.jars
}

do_install() {
	install -d ${D}/${OSGI_BASE_DIR}/bundle
	install -m 0644 ${WORKDIR}/dist/${PN}.jar ${D}/${OSGI_BASE_DIR}/bundle/${PN}.jar
}



