require buglabs-osgi.inc

DESCRIPTION = "BUG Module Interface integration with OSGI applications."
LICENSE = "BSD"

PR = "${INC_PR}.8"
DEPENDS += "com.buglabs.common com.buglabs.bug.ws commons-io com.buglabs.util.shell"

BUNDLE_PERM = "0744"