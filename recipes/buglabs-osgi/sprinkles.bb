inherit java-library

DESCRIPTION = "Sprinkle functional elements in Java programs."
LICENSE = "BSD"

PR = "r8"
RPROVIDES += "${PN}"

SRC_URI = "git://github.com/kgilmer/Sprinkles.git;protocol=git;branch=${BRANCH}"
SRCREV = "ff53c6494f8a32865c36"
BRANCH = "master"

FILES_${PN} = "${datadir}/osgi/bundle/Sprinkles.jar"
PACKAGE_ARCH = "all"
JARFILENAME = "Sprinkles.jar"

# Default file permissions on jar.  If jar is executable that means it should be started under knapsack.
BUNDLE_PERM ?= "0644"

S = "${WORKDIR}/git"

do_compile() {	
	rm -Rf src/org/sprinkles/test
	ant 
	oe_jarinstall -s ${S}/Sprinkles.jar
}

do_install() {
	install -d ${D}/${datadir}/osgi/bundle
	install -m ${BUNDLE_PERM} ${S}/Sprinkles.jar ${D}/${datadir}/osgi/bundle/Sprinkles.jar
}
