ANT_TARGETS = "create_dirs build build.jars"

require buglabs-osgi.inc

BRANCH = "master"
SRC_URI = "git://github.com/buglabs/bugswarm-connector.git;protocol=git;branch=${BRANCH} \
		   file://connector.properties \
		   "
		   
S = "${WORKDIR}/git/com.buglabs.bug.swarm.connector"

DESCRIPTION = "BUGswarm connector enables BUG applications to integrate with BUGswarm"
LICENSE = "ASL"

PR = "${INC_PR}.5"

FILES_${PN} += "${propdir_java}/connector.properties"

DEPENDS += "com.buglabs.common felix-configadmin org.apache.felix.http.jetty servlet2.3 com.buglabs.osgi.sewing smack-smackx-osgi com.buglabs.util.shell knapsack"
BUNDLE_PERM = "0744"

do_configure_prepend() {
	rm -Rf ${S}/test
}
