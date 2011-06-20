 
LICENSE = "http://www.osgi.org/Main/OSGiSpecificationLicense"
DEPENDS += "fastjar-native"

S = "${WORKDIR}"

do_compile() {	
	fastjar -c -m META-INF/MANIFEST.MF -f ${PN}.jar .
}

do_install() {
	install -d ${D}/${OSGI_BASE_DIR}/bundle
	install ${WORKDIR}/${PN}.jar ${D}/${OSGI_BASE_DIR}/bundle/${PN}.jar
}
