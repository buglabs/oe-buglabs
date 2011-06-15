# org.openembedded.openjdk.jar is a custom javac configuration class for ant.
# It allows ant to use the javac provided by openjdk rather than the one provided by ecj
# Ant is hardcoded to expect a javac in JAVA_HOME, and since the openjdk javac is called something 
# else, this customizer is necessary.
# See http://ant.apache.org/manual/Tasks/javac.html

OSGI_BASE_DIR ?= "/usr/share/osgi"

DEPENDS = "ant-native"

OSGI_BASE_DIR = "/usr/share/osgi"
SRC_URI="git://github.com/buglabs/bug-osgi.git;protocol=git;branch=${BRANCH} \
	file://org.openembedded.openjdk.jar \
	"
BRANCH = "master"

INC_PR = "r6"

S = "${WORKDIR}/git/${PN}"

FILES_${PN} = "${OSGI_BASE_DIR}/bundle/${PN}.jar"
PACKAGE_ARCH = "all"

# Must set this explicitly because it defaults to a value of 1.
SRCREV = "321035a6cc5cb0ec79f2"

# Default file permissions on jar.  If jar is executable that means it should be started under knapsack.
BUNDLE_PERM="0644"

do_compile() {
	export OE.JAVAC.PATH=${STAGING_DIR_NATIVE}/jvm/icedtea6-native/bin/javac
	export CLASSPATH=${WORKDIR}:$CLASSPATH
	ant -d -Dbuild.compiler=org.openembedded.openjdk.JavacExternal -Dbase.build.dir=${WORKDIR}/git/com.buglabs.osgi.build -Dcheckout.dir=${WORKDIR}/git -DexternalDirectory=${WORKDIR}/external -DdistDirectory=${WORKDIR}/dist create_dirs build.jars
	echo $?
}

do_install() {
	install -d ${D}/${OSGI_BASE_DIR}/bundle
	install -m ${BUNDLE_PERM} ${WORKDIR}/dist/${PN}.jar ${D}/${OSGI_BASE_DIR}/bundle/${PN}.jar
}



