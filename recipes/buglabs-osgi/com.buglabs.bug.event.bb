require bug-osgi.inc
PR = "${INC_PR}.2+svnr${SRCREV}"
DEPENDS += "com.buglabs.common org.apache.felix.http.jetty"
RDEPENDS += "org.apache.felix.http.jetty"
DEPENDS += "servlet2.3"
EXTRA_CP += "servlet-2.3.1"


