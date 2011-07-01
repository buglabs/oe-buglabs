require buglabs-osgi.inc

DESCRIPTION = "Web app framework for BUG"
LICENSE = "BSD"

PR = "${INC_PR}.2"

DEPENDS += "com.buglabs.common service-tracker org.apache.felix.http.jetty"
