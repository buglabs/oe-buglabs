datadir_java = ${datadir}/osgi/bundle
inherit java

DEPENDS += "ant-native osgi-core osgi-compendium"

SRC_URI="git://github.com/buglabs/bug-osgi.git;protocol=git;branch=${BRANCH}"
BRANCH = "master"

INC_PR = "r20"

S = "${WORKDIR}/git/${PN}"
ANT_TARGETS ?= "create_dirs build.jars"

FILES_${PN} = "${datadir_java}/${PN}.jar"
PACKAGE_ARCH = "all"
JARFILENAME = ${PN}.jar

# Must set this explicitly because it defaults to a value of 1.
SRCREV = "29b104a652fd7f146c62"

# Default file permissions on jar.  If jar is executable that means it should be started under knapsack.
BUNDLE_PERM ?= "0644"

do_compile() {	
	ant -Dbase.build.dir=${WORKDIR}/git/com.buglabs.osgi.build -Dcheckout.dir=${WORKDIR}/git -DexternalDirectory=${STAGING_DIR_JAVA} -DdistDirectory=${WORKDIR}/dist ${ANT_TARGETS}
	oe_jarinstall -s ${WORKDIR}/dist/${PN}.jar
}

do_install() {
	install -d ${D}/${datadir_java}
	install -m ${BUNDLE_PERM} ${WORKDIR}/dist/${PN}.jar ${D}/${datadir_java}/${PN}.jar
}
