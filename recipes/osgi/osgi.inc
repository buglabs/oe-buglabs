inherit java-library

LICENSE = "http://www.osgi.org/Main/OSGiSpecificationLicense"

S = "${WORKDIR}"

#This recipe just takes the jar file and re-jars it. 
do_removebinaries() {
	:
}

do_compile() {	
	fastjar -c -m META-INF/MANIFEST.MF -f ${JARFILENAME} .
}
