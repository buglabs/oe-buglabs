require buglabs-osgi.inc

DESCRIPTION = "Web app framework for BUG"
LICENSE = "BSD"

PR = "${INC_PR}.4"
BUNDLE_PERM = "0744"

DEPENDS += "com.buglabs.common org.apache.felix.http.jetty"
