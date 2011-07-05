require apache-commons.inc

DESCRIPTION = "Commons IO is a library of utilities to assist with developing IO functionality."
SRCREV="1142882"
SRC_URI = "svn://svn.apache.org/repos/asf/commons/proper/io/tags;module=${PN}-${PV};proto=http"

S = "${WORKDIR}/${PN}-${PV}"

PR = "r1"
JARFILENAME = "${S}/target/${PN}-${PV}.jar"

do_compile() {	
	ant 
}

