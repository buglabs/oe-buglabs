require bug-osgi.inc

DEPENDS += "com.buglabs.common felix-configadmin com.buglabs.osgi.http servlet2.3 com.buglabs.osgi.sewing com.buglabs.bug.swarm.connector"

PR = "${INC_PR}.0+svnr${SRCREV}"

SRC_URI = "svn://bugcamp.net/swarm/trunk;module=${PN};proto=svn "

PREFERRED_PROVIDER_virtual/javac-native = "openjdk-javac-native"
JAVAC_COMMAND = "sun-javac"
JAVAC_OPTIONS += " -bootclasspath ${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/jre/lib/rt.jar"