datadir_java = ${datadir}/osgi/bundle
inherit java

DESCRIPTION = "Sprinkle functional elements in Java programs."
LICENSE = "BSD"

PR = "r3"

SRC_URI = "git://github.com/kgilmer/Sprinkles.git;protocol=git;branch=${BRANCH}"
SRCREV = "de19867e1f96311b6d59"
BRANCH = "master"

FILES_Sprinkles = "${datadir_java}/Sprinkles.jar"
PACKAGE_ARCH = "all"
JARFILENAME = Sprinkles.jar

# Default file permissions on jar.  If jar is executable that means it should be started under knapsack.
BUNDLE_PERM ?= "0644"

S = "${WORKDIR}/git"

do_compile() {	
	ant 
	oe_jarinstall -s ${S}/Sprinkles.jar
}

do_install() {
	install -d ${D}/${datadir_java}
	install -m ${BUNDLE_PERM} ${S}/Sprinkles.jar ${D}/${datadir_java}/Sprinkles.jar
}
