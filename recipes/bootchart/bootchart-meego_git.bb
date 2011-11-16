DESCRIPTION = "Monitors where the system spends its time at start, creating a graph of all processes, disk utilization, and wait time."
HOMEPAGE = "http://meego.gitorious.org/meego-developer-tools/bootchart"

LICENSE = "GPLv2"

SRC_URI = "git://gitorious.org/meego-developer-tools/bootchart.git;protocol=git;branch=master"
SRCREV = "4420bc4318c4aada7c7d128105e56ecc8c84cb19"

S = "${WORKDIR}/git"

do_install() {
	oe_runmake install DESTDIR=${D}
}

