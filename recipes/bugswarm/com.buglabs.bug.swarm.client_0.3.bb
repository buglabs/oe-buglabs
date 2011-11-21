ANT_TARGETS = "create_dirs build build.jars"

require ../buglabs-osgi/buglabs-osgi.inc

BRANCH = "${PV}"
SRC_URI = "git://github.com/buglabs/bugswarm-connector.git;protocol=git;branch=${BRANCH} \
		   "
		   
S = "${WORKDIR}/git/com.buglabs.bug.swarm.client"

DESCRIPTION = "BUGswarm client enables BUG applications to integrate with BUGswarm"
LICENSE = "ASL"

PR = "${INC_PR}.0"

DEPENDS += "jackson-binary org.touge.restclient"
BUNDLE_PERM = "0744"

do_compile() {
	rm -Rf test
	ant -Dant-build-common.dir=${WORKDIR}/ant-build-common -Dbase.build.dir=${WORKDIR} -DexternalDirectory=${STAGING_DIR_JAVA} -DdistDirectory=${WORKDIR}/dist -Dcheckout.dir=${WORKDIR}/git ${ANT_TARGETS}
}

do_stage(){
	install -m 0644 ${WORKDIR}/dist/${PN}.jar ${STAGING_DIR_JAVA}
}