DESCRIPTION = "JUnit is a testing framework for Java"
LICENSES = "CPL"
AUTHOR = "junit.org"
HOMEPAGE = "http://www.junit.org"

SRC_URI = "https://github.com/downloads/KentBeck/junit/junit-${PV}-src.jar"

S = "${WORKDIR}"

inherit java-library

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build

	# Workaround for jamvm.
	bcp=${STAGING_DATADIR_NATIVE}/classpath/glibj.zip

  javac -source 5.0 -bootclasspath $bcp -sourcepath . -d build `find . -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}

SRC_URI[md5sum] = "2100c46cd257afedd4f2989ba3ab5bce"
SRC_URI[sha256sum] = "f1c006948cd26043a63f3b730043787fc8eb892230b978d0ac7a74b235907d08"

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
