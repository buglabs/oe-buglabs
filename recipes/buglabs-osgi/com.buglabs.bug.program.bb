require bug-osgi.inc
DEPENDS += "com.buglabs.common servlet2.3 felix-configadmin org.apache.felix.http.jetty"
RDEPENDS += "org.apache.felix.http.jetty"
EXTRA_CP += "servlet-2.3.1"

PR = "${INC_PR}.7+svnr${SRCREV}"
