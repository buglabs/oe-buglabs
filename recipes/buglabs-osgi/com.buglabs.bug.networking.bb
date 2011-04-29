require bug-osgi.inc
DEPENDS += "com.buglabs.common servlet2.3 felix-configadmin com.buglabs.osgi.http org.freedesktop.dbus com.buglabs.bug.jni.libmatthew"
RDEPENDS += "com.buglabs.osgi.http connman"
EXTRA_CP += "servlet-2.3.1"

SRCREV = "13101"

PR = "${INC_PR}.0+svnr${SRCREV}"
