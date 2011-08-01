DESCRIPTION = "Knapsack for Apache Felix"
LICENSE = "Apache 2.0"
PR = "r7"

inherit java

BRANCH = "master"
SRCREV = "1f7163ff6ffc22eae7c9"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/kgilmer/knapsack.git;protocol=git;branch=${BRANCH}"

FILES_${PN} = "/usr/share/osgi/${PN}.jar"
PACKAGE_ARCH = "all"

DEPENDS = "ant-native"

do_compile() {
	ant jar
}

do_install() {
	oe_jarinstall -s ${S}/${PN}.jar
	install -d ${D}/usr/share/osgi
	install -m 0644 ${S}/${PN}.jar ${D}/usr/share/osgi/${PN}.jar
}
do_stage(){
	install -m 0644 ${S}/${PN}.jar ${STAGING_DIR_JAVA}
}
