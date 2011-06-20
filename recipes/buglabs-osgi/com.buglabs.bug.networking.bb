require bug-osgi.inc
DEPENDS += "com.buglabs.common servlet2.3 org.freedesktop.dbus com.buglabs.bug.jni.libmatthew"
RDEPENDS += "org.apache.felix.http.jetty connman"
EXTRA_CP += "servlet-2.3.1"

SRCREV = "13126"

PR = "${INC_PR}.0+svnr${SRCREV}"
