DESCRIPTION = "Startup properties for Apache Felix Jetty HTTP Service on BUG"

PR = "r1"

SRC_URI = "file://org.apache.felix.http.jetty.properties"

framedir = "/usr/share/osgi"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "${framedir}/properties/org.apache.felix.http.jetty.properties"

DEPENDS = "knapsack org.apache.felix.http.jetty"
BUILD_NUMBER ?= "0"

do_compile() {
	:
}

addtask init_install before do_package after do_install
do_init_install() {
        install -d ${D}${framedir}
        install -d ${D}${framedir}/properties
        install -m 0644 ${WORKDIR}/org.apache.felix.http.jetty.properties ${D}${framedir}/properties/       
}
