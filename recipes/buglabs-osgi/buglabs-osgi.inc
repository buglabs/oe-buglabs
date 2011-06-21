inherit java

OSGI_BASE_DIR ?= "/usr/share/osgi"

DEPENDS += "ant-native osgi-core osgi-compendium"

OSGI_BASE_DIR = "/usr/share/osgi"
SRC_URI="git://github.com/buglabs/bug-osgi.git;protocol=git;branch=${BRANCH}"
BRANCH = "master"

INC_PR = "r6"

S = "${WORKDIR}/git/${PN}"

FILES_${PN} = "${OSGI_BASE_DIR}/bundle/${PN}.jar"
PACKAGE_ARCH = "all"

# Must set this explicitly because it defaults to a value of 1.
SRCREV = "03c4debd8bf9c49082a9"

# Default file permissions on jar.  If jar is executable that means it should be started under knapsack.
BUNDLE_PERM="0644"

do_compile() {	
	ant -Dbase.build.dir=${WORKDIR}/git/com.buglabs.osgi.build -Dcheckout.dir=${WORKDIR}/git -DexternalDirectory=${STAGING_DIR_JAVA} -DdistDirectory=${WORKDIR}/dist create_dirs build.jars
	oe_jarinstall -s ${WORKDIR}/dist/${PN}.jar
}

do_install() {
	install -d ${D}/${OSGI_BASE_DIR}/bundle
	install -m ${BUNDLE_PERM} ${WORKDIR}/dist/${PN}.jar ${D}/${OSGI_BASE_DIR}/bundle/${PN}.jar
}
