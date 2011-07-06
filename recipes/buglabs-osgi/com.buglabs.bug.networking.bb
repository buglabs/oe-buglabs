require buglabs-osgi.inc
DESCRIPTION = "BUG Connman/DBUS networking API"
LICENSE = "BSD"

DEPENDS += "com.buglabs.common servlet2.3 org.freedesktop.dbus com.buglabs.bug.jni.libmatthew"
RDEPENDS += "org.apache.felix.http.jetty connman"
EXTRA_CP += "servlet-2.3.1"

PR = "${INC_PR}.3"
BUNDLE_PERM = "0744"

