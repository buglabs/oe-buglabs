require buglabs-osgi.inc

DESCRIPTION = "Common Web Service APIs for BUG."
LICENSE = "BSD"

PR = "${INC_PR}.4"

DEPENDS += "com.buglabs.common felix-configadmin org.apache.felix.http.base com.buglabs.bug.dragonfly knapsack commons-io"
RDEPENDS += "org.apache.felix.http.jetty"
DEPENDS += "servlet2.3"
EXTRA_CP += "servlet-2.3.1"

BUNDLE_PERM = "0744"