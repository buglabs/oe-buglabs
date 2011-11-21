ANT_TARGETS = "create_dirs build build.jars"

require ../buglabs-osgi/buglabs-osgi.inc

BRANCH = "${PV}"
SRC_URI = "git://github.com/buglabs/bugswarm-connector.git;protocol=git;branch=${BRANCH} \
		   file://connector.properties \
		   "
		   
S = "${WORKDIR}/git/com.buglabs.bug.swarm.connector"

DESCRIPTION = "BUGswarm connector enables BUG applications to integrate with BUGswarm"
LICENSE = "ASL"

PR = "${INC_PR}.8"

FILES_${PN} += "${propdir_java}/connector.properties"

DEPENDS += "com.buglabs.common felix-configadmin org.apache.felix.http.jetty servlet2.3 com.buglabs.osgi.sewing smack-smackx-osgi com.buglabs.util.shell knapsack jackson-binary com.buglabs.bug.swarm.client"
BUNDLE_PERM = "0744"

do_configure_prepend() {
	rm -Rf ${S}/test
}

do_compile() {
	ant -Dant-build-common.dir=${WORKDIR}/ant-build-common -Dbase.build.dir=${WORKDIR} -DexternalDirectory=${STAGING_DIR_JAVA} -DdistDirectory=${WORKDIR}/dist -Dcheckout.dir=${WORKDIR}/git ${ANT_TARGETS}
}
