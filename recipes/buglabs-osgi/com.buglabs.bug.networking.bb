require bug-osgi.inc
DEPENDS += "com.buglabs.common servlet2.3 felix-configadmin org.apache.felix.http.jetty org.freedesktop.dbus com.buglabs.bug.jni.libmatthew"
RDEPENDS += "org.apache.felix.http.jetty connman"
EXTRA_CP += "servlet-2.3.1"

SRCREV = "13121"

PR = "${INC_PR}.0+svnr${SRCREV}"
