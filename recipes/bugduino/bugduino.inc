DESCRIPTION = "Bugduino programming tools. On bug command line tool, and service for remotely programming a bugduino via TCP/IP"
HOMEPAGE = "http://wiki.buglabs.net/index.php/Hardware:BUGduino"
SECTION = "bmi"
LICENSE = "GPL"
inherit autotools
S = "${WORKDIR}/git"
DEPENDS="openjdk-6 update-rc.d udev"
RDEPENDS="avrdude"

do_compile_append(){	
	oe_runmake KERN_INC_DIR=${STAGING_INCDIR}/bug -C lib
	oe_runmake -C app
}


do_install() {
	# create /usr/bin/bugduino dir
	install -d ${D}${bindir}/bugduino

	# install Main.class into /usr/bin/bugduino
	install -m 0755 ${S}/app/Main.class ${D}${bindir}/bugduino 
	
	install -m 0755 ${WORKDIR}/run_service.sh ${D}${bindir}/bugduino 
	install -d ${D}${libdir}/jvm/java-6-openjdk/jre/lib/arm/
	install -m 755 ${S}/libjavaduino.so ${D}${libdir}/jvm/java-6-openjdk/jre/lib/arm/
	
}
