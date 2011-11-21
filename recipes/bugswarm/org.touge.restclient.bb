ANT_TARGETS = "jar"

require ../buglabs-osgi/buglabs-osgi.inc

BRANCH = "master"
SRC_URI = "git://github.com/kgilmer/touge.git;protocol=git;branch=${BRANCH} \
		   "
		   
S = "${WORKDIR}/git/org.touge.restclient"

DESCRIPTION = "A rest-style HTTP client."
LICENSE = "Public Domain"

PR = "${INC_PR}.0"

BUNDLE_PERM = "0744"


do_compile() {
	ant -Dant-build-common.dir=${WORKDIR}/ant-build-common -Dproduct.dir=${WORKDIR} jar
	oe_jarinstall -s ${WORKDIR}/dist/${PN}.jar
}

do_stage() {
	install -m 0644 ${WORKDIR}/dist/${PN}.jar ${STAGING_DIR_JAVA}
}