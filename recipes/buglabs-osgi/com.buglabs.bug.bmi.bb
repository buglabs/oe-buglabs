require buglabs-osgi.inc

DESCRIPTION = "BUG Module Interface integration with OSGI applications."
LICENSE = "BSD"

PR = "${INC_PR}.3"
DEPENDS += "com.buglabs.common com.buglabs.bug.ws"

BUNDLE_PERM = "0744"