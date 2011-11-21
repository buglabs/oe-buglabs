DESCRIPTION = "Jackson JSON Library, BINARY recipe"
LICENSE = "ASL2"
PR = "r0"

S = "${WORKDIR}/"

FILES_${PN} = "/usr/share/java/jackson-core-asl-1.9.2.jar"
FILES_${PN} = "/usr/share/java/jackson-mapper-asl-1.9.2.jar"

PACKAGE_ARCH = "all"

do_compile() {
	:
}

do_install() {
	wget http://repository.codehaus.org/org/codehaus/jackson/jackson-core-asl/1.9.2/jackson-core-asl-1.9.2.jar
	wget http://repository.codehaus.org/org/codehaus/jackson/jackson-mapper-asl/1.9.2/jackson-mapper-asl-1.9.2.jar
	
	install -d ${D}/usr/share/java/
	install -m 0644 ${S}/jackson-core-asl-1.9.2.jar ${D}/usr/share/java/jackson-core-asl-1.9.2.jar
	install -m 0644 ${S}/jackson-mapper-asl-1.9.2.jar ${D}/usr/share/java/jackson-mapper-asl-1.9.2.jar
}

do_stage(){
	install -m 0644 ${S}/jackson-core-asl-1.9.2.jar ${STAGING_DIR_JAVA}
	install -m 0644 ${S}/jackson-mapper-asl-1.9.2.jar ${STAGING_DIR_JAVA}
}

