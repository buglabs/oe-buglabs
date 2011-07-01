require buglabs-osgi.inc

DESCRIPTION = "Enables BUG 2.0 specific hardware OSGi services."
LICENSE = "BSD"

PR = "${INC_PR}.12"
EXTRA_CP += "servlet-2.3.1"
DEPENDS += "com.buglabs.common com.buglabs.bug.jni.input  com.buglabs.bug.jni.common servlet2.3 org.apache.felix.http.jetty"
PACKAGE_ARCH = "${MACHINE_ARCH}"
BUNDLE_PERM = "0744"

COMPATIBLE_MACHINE = "bug20"