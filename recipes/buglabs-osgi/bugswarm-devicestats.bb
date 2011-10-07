ANT_TARGETS = "create_dirs build build.jars"

require buglabs-osgi.inc

BRANCH = "master"
SRC_URI = "git://github.com/buglabs/bugswarm-connector.git;protocol=git;branch=${BRANCH}"
S = "${WORKDIR}/git/com.buglabs.bug.swarm.devicestats"

DESCRIPTION = "BUGswarm-devicestats exports BUG machine state information to BUGswarm."
LICENSE = "ASL"

PR = "${INC_PR}.0"

DEPENDS += "com.buglabs.common"
BUNDLE_PERM = "0744"

do_configure_prepend() {
	rm -Rf ${S}/test
}