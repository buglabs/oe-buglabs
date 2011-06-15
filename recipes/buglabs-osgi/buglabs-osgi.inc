inherit java

OSGI_BASE_DIR ?= "/usr/share/osgi"

DEPENDS = "ant-native"

OSGI_BASE_DIR = "/usr/share/osgi"
SRC_URI="git://github.com/buglabs/bug-osgi.git;protocol=git;branch=${BRANCH}"
BRANCH = "master"

INC_PR = "r6"

S = "${WORKDIR}/git/${PN}"

FILES_${PN} = "${OSGI_BASE_DIR}/bundle/${PN}.jar"
PACKAGE_ARCH = "all"

# Must set this explicitly because it defaults to a value of 1.
SRCREV = "321035a6cc5cb0ec79f2"

# Default file permissions on jar.  If jar is executable that means it should be started under knapsack.
BUNDLE_PERM="0644"

do_replace_ecj_with_openjdk_javac() {
	if [ ! -f ${STAGING_BINDIR_NATIVE}/javac.ecj ]; then
		echo "Replacing ecj javac with openjdk javac in staging"
		mv ${STAGING_BINDIR_NATIVE}/javac ${STAGING_BINDIR_NATIVE}/javac.ecj
		ln -s ${STAGING_LIBDIR_NATIVE}/jvm/icedtea6-native/bin/javac ${STAGING_BINDIR_NATIVE}/javac
	fi
}

addtask do_replace_ecj_with_openjdk_javac after do_patch before do_compile

do_compile() {	
	ant -Dbase.build.dir=${WORKDIR}/git/com.buglabs.osgi.build -Dcheckout.dir=${WORKDIR}/git -DexternalDirectory=${STAGING_DIR_JAVA} -DdistDirectory=${WORKDIR}/dist create_dirs build.jars
}

do_install() {
	install -d ${D}/${OSGI_BASE_DIR}/bundle
	install -m ${BUNDLE_PERM} ${WORKDIR}/dist/${PN}.jar ${D}/${OSGI_BASE_DIR}/bundle/${PN}.jar
}

do_java_stage() {
  oe_jarinstall -s ${WORKDIR}/dist/${PN}.jar
}

addtask do_java_stage after do_compile before do_package
