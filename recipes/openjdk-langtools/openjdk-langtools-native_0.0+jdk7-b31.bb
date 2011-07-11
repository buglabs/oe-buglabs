DESCRIPTION = "Java Language tools (sun-javac, javah, javap, javadoc and apt) from OpenJDK"
HOMEPAGE = "http://http://openjdk.java.net/groups/compiler"
LICENSE  = "GPL"

PR = "r5"

DEPENDS = "classpath-native fastjar-native ecj-initial virtual/java-native icedtea6-native"

S = "${WORKDIR}/icepick-0.0+hg20080118"

SRC_URI = "\
	http://jalimo.evolvis.org/repository/sources/icepick-0.0+hg20080118.tar.bz2;name=archive \
	http://jalimo.evolvis.org/repository/sources/openjdk-langtools-jdk7-b31.tar.bz2;name=langtools \
	file://${PV}-build-fix.patch \
	"	

inherit java autotools native

export JAVAC_OPTS="-bootclasspath ${STAGING_DATADIR_JAVA}/share/classpath/glibj.zip -source 5.0"

EXTRA_OECONF = "\
	--with-javac="${STAGING_BINDIR}/ecj-initial ${JAVAC_OPTS}" \
	--with-vm=${STAGING_BINDIR}/java \
	--with-fastjar=${STAGING_BINDIR}/fastjar \
	--with-classpath=${STAGING_DATADIR}/classpath/glibj.zip \
	--with-langtools-src-dir=${WORKDIR}/openjdk-langtools-jdk7-b31 \
  "

do_populate_sysroot() {
	# Do install step manually to fine control installation names.
	
	# Move pre-existing version of javac, prevents ecj and other remnants from executing as javac.
	if [ -f ${STAGING_BINDIR_NATIVE}/javac ]; then
		mv ${STAGING_BINDIR_NATIVE}/javac ${STAGING_BINDIR_NATIVE}/javac.legacy
	fi
	
	# Replace the java program with the version provided by icedtea/openjdk
	if [ -f ${STAGING_BINDIR_NATIVE}/java ]; then
		mv ${STAGING_BINDIR_NATIVE}/java ${STAGING_BINDIR_NATIVE}/java.legacy
		ln -s ${STAGING_LIBDIR_NATIVE}/jvm/icedtea6-native/jre/bin/java ${STAGING_BINDIR_NATIVE}/java
	fi
	
	install -d ${bindir}
	install -m 0755 tools/apt ${bindir}
	install -m 0755 tools/javadoc ${bindir}
	install -m 0755 tools/javah ${bindir}
	install -m 0755 tools/javap ${bindir}
	install -m 0755 tools/javac ${bindir}

	install -d ${libdir}
	install -m 0644 tools.jar ${libdir}
}

SRC_URI[archive.md5sum] = "ce7b1827e6f4cbe73b9ffa90b0d45a6a"
SRC_URI[archive.sha256sum] = "63170836095f8451498c813a1f93a9ec70a1164d82aa30650c0f2216ca4377ab"
SRC_URI[langtools.md5sum] = "670931f67b2e4ac46c6e0cd15418f2fa"
SRC_URI[langtools.sha256sum] = "f8b8820e410c137d279d14dec7e7a93217cc371acdfe1b3343b2278d1728932e"
