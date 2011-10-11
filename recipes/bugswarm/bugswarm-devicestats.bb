ANT_TARGETS = "create_dirs build build.jars"

require ../buglabs-osgi/buglabs-osgi.inc

BRANCH = "master"
SRC_URI = "git://github.com/buglabs/bugswarm-connector.git;protocol=git;branch=${BRANCH}"
S = "${WORKDIR}/git/com.buglabs.bug.swarm.devicestats"

DESCRIPTION = "BUGswarm-devicestats exports BUG machine state information to BUGswarm."
LICENSE = "ASL"

PR = "${INC_PR}.2"

DEPENDS += "com.buglabs.common"
BUNDLE_PERM = "0744"

do_compile() {	
	ant -v -Dbase.build.dir=${S} -Dcheckout.dir=${S} -DexternalDirectory=${STAGING_DIR_JAVA} -DdistDirectory=${WORKDIR}/dist ${ANT_TARGETS}
	oe_jarinstall -s ${WORKDIR}/dist/${PN}.jar
}

do_configure_prepend() {
	rm -Rf ${S}/test
}