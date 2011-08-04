ANT_TARGETS = "create_dirs build.jars append.resources"
require buglabs-osgi.inc

DESCRIPTION = "appui is an application launcher for OSGi-enabled apps for BUG."
LICENSE = "BSD"

PR = "${INC_PR}.8"
DEPENDS += "com.buglabs.common"
BUNDLE_PERM = "0744"
