DESCRIPTION = "Knapsack for Apache Felix"
LICENSE = "Apache 2.0"
PR = "r2"

BRANCH = "master"
SRCREV = "befb57fda6b8112fe5cc"
S = "${WORKDIR}/git"

SRC_URI="git://github.com/kgilmer/knapsack.git;protocol=git;branch=${BRANCH} \
#		 file://fork-ant-utf8.patch \
		"

FILES_${PN} = "/usr/share/java/${PN}.jar"
PACKAGE_ARCH = "all"

DEPENDS = "ant-native"

do_compile() {
	ant jar
}

do_install() {
	install -d ${D}/usr/share/java
	install -m 0644 ${S}/${PN}.jar ${D}/usr/share/java/${PN}.jar
}
