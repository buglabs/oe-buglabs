DESCRIPTION = "Initialization and startup scripts for felix on BUG"
LICENSE = "MIT"
PR = "r0"
RDEPENDS+="update-rc.d"

SRC_URI = "file://bug.properties \            
            file://knapsack \
            file://knapsack-debug"

framedir = "/usr/share/osgi"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "${framedir}/default/bug.properties \
                /etc/init.d/knapsack \
                /etc/init.d/knapsack-debug \
                "

DEPENDS = "fastjar-native knapsack"

do_compile() {
	echo "bug.os.version=${BUG_RELEASE_VERSION}.${BUILD_NUMBER}" >> ${WORKDIR}/bug.properties
}

addtask init_install before do_package after do_install
do_init_install() {
        install -m 0755 -d ${D}${framedir}
        install -m 0755 -d ${D}${framedir}/default
        install -m 0755 ${WORKDIR}/bug.properties ${D}${framedir}/default/
        install -d ${D}/etc
        install -d ${D}/etc/init.d
        install -m 0755 ${WORKDIR}/knapsack ${D}/etc/init.d
        install -m 0755 ${WORKDIR}/knapsack-debug ${D}/etc/init.d
}

inherit update-rc.d

INITSCRIPT_NAME = "knapsack"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 30 0 1 6 ."

pkg_postrm_${PN}() {
	update-rc.d -f knapsack remove
	update-rc.d -f knapsack-debug remove
}
