require buglabs-osgi.inc

DESCRIPTION = "Web app framework for BUG"
LICENSE = "BSD"

PR = "${INC_PR}.4"
BUNDLE_PERM = "0744"

DEPENDS += "com.buglabs.common service-tracker org.apache.felix.http.jetty"
