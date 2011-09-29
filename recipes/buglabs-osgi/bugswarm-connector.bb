ANT_TARGETS = "create_dirs build build.jars"

require buglabs-osgi.inc

BRANCH = "master"
SRC_URI = "git://github.com/buglabs/bugswarm-connector.git;protocol=git;branch=${BRANCH}"
S = "${WORKDIR}/git"

DESCRIPTION = "BUGswarm connector enables BUG applications to integrate with BUGswarm"
LICENSE = "ASL"

PR = "${INC_PR}.0"

DEPENDS += "com.buglabs.common felix-configadmin org.apache.felix.http.jetty servlet2.3 com.buglabs.osgi.sewing"

do_configure_prepend() {
	rm -Rf ${S}/test
}