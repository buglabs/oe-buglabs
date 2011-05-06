require bug-osgi.inc
PR = "${INC_PR}.3+svnr${SRCREV}"
DEPENDS += "com.buglabs.common org.apache.felix.http.jetty servlet2.3"
EXTRA_CP += "servlet-2.3.1"
