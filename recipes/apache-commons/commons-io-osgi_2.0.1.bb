require apache-commons.inc

BPN = "commons-io"
DESCRIPTION = "Commons IO is a library of utilities to assist with developing IO functionality."
SRCREV="1142882"
SRC_URI =  "svn://svn.apache.org/repos/asf/commons/proper/io/tags;module=${BPN}-${PV};proto=http \
			file://osgi-manifest.patch \
			"

S = "${WORKDIR}/${BPN}-${PV}"

PR = "r3"
JARFILENAME = "${S}/target/${BPN}-${PV}.jar"

do_compile() {	
	ant 
}

