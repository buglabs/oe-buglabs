DESCRIPTION = "Knapsack for Apache Felix"
LICENSE = "Apache 2.0"
PR = "r1"

BRANCH = "master"
SRCREV = "4da567c42ddad2c4697a"
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
