require buglabs-osgi.inc

DESCRIPTION = "BUG Module Interface integration with OSGI applications."
LICENSE = "BSD"

PR = "${INC_PR}.3"
DEPENDS += "com.buglabs.common servlet2.3"
RDEPENDS += "org.apache.felix.http.jetty"
BUNDLE_PERM = "0744"