ANT_TARGETS = "create_dirs build.jars"

require buglabs-osgi.inc

BRANCH = "master"
SRC_URI = "git://github.com/buglabs/smack-smackx-osgi.git;protocol=git;branch=${BRANCH}"
S = "${WORKDIR}/git"

DESCRIPTION = "XMPP Library for Java"
LICENSE = "ASL"

PR = "${INC_PR}.0"

do_compile() {	
    # Remove tests
	rm -Rf ${S}/test
	ant -v -Dbase.build.dir=${WORKDIR}/git -Dcheckout.dir=${WORKDIR}/git -DexternalDirectory=${STAGING_DIR_JAVA} -DdistDirectory=${WORKDIR}/dist ${ANT_TARGETS}
	oe_jarinstall -s ${WORKDIR}/dist/${PN}.jar
}