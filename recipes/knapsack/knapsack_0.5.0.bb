DESCRIPTION = "Knapsack for Apache Felix"
LICENSE = "Apache 2.0"
PR = "r0"

BRANCH = "master"
SRCREV = "4f9dc7dafb7b9e4820aa"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/kgilmer/knapsack.git;protocol=git;branch=${BRANCH}"

FILES_${PN} = "/usr/share/osgi/${PN}.jar"
PACKAGE_ARCH = "all"

DEPENDS = "ant-native"

do_compile() {
	ant jar
}

do_install() {
	install -d ${D}/usr/share/osgi
	install -m 0644 ${S}/${PN}.jar ${D}/usr/share/osgi/${PN}.jar
}
