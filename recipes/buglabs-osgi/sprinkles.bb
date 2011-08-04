DESCRIPTION = "Sprinkle functional elements in Java programs."
LICENSE = "BSD"
PR = "r12"

inherit java

SRC_URI = "git://github.com/kgilmer/Sprinkles.git;protocol=git;branch=${BRANCH}"
SRCREV = "3a29739466421f03205c"
BRANCH = "master"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr/share/osgi/bundle/${PN}.jar"
PACKAGE_ARCH = "all"

DEPENDS = "ant-native"

do_compile() {
	rm -Rf src/org/sprinkles/test
	ant 
	cp Sprinkles.jar sprinkles.jar
}

do_install() {
	oe_jarinstall -s ${S}/${PN}.jar
	install -d ${D}/usr/share/osgi/bundle
	install -m 0644 ${S}/${PN}.jar ${D}/usr/share/osgi/bundle/${PN}.jar
}

do_stage(){
	install -m 0644 ${S}/${PN}.jar ${STAGING_DIR_JAVA}
}

