ANT_TARGETS = "create_dirs build.jars append.resources"
require buglabs-osgi.inc

DESCRIPTION = "appui is an application launcher for OSGi-enabled apps for BUG."
LICENSE = "BSD"

PR = "${INC_PR}.9"
DEPENDS += "com.buglabs.common com.buglabs.bug.module.lcd"
BUNDLE_PERM = "0744"
