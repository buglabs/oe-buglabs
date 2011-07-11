DESCRIPTION = "Bugduino programming tools. On bug command line tool, and service for remotely programming a bugduino via TCP/IP"
HOMEPAGE = "http://wiki.buglabs.net/index.php/Hardware:BUGduino"
SECTION = "bmi"
LICENSE = "GPL"
DEPENDS =  "TODO"

do_compile_append(){	
	# build libjavabugduino.so
	## cd lib
	## run makefile in lib
	# build Main.class 
	## cd app	
	## run makefile in app
}


do_install_append() {
	# create /usr/bin/bugduino dir
	install -d ${D}${bindir}/bugduino

	# install Main.class into /usr/bin/bugduino
	install -m 0755 ${WORKDIR}Main.class ${D}${bindir}/bugduino 
	
	install -m 0755 ${files}/run_service.sh ${D}${bindir}/bugduino 
	# install libjavabugduino into /usr/lib/jvm/java-6-openjdk/jre/lib/arm/ 
	install -m 755 ${WORKDIR}/libjavaduino ${D}${libdir}/jvm/java-6-openjdk/jre/lib/arm/
	
	#install run_service.sh  into /usr/bin/bugduino
	#install program_bugduino into /usr/bin/bugduino
	install -m 0755 ${files}/run_service.sh ${D}${bindir}/bugduino 
	install -m 0755 ${WORKDIR}/program_bugduino ${D}${bindir}/bugduino 
}
