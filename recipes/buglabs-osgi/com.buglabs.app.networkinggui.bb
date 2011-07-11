require buglabs-osgi.inc

DESCRIPTION = "NetworkingGUI provides a GUI for configuring the network."
HOMEPAGE = "http://www.buglabs.net/applications/NetworkingGUI"

DEPENDS += "service-tracker com.buglabs.common com.buglabs.bug.module.lcd com.buglabs.bug.networking"

PV = "8"

# SRC_LINK = "http://www.buglabs.net/program_version/download/1447"
# JARFILENAME = "NetworkingGUI.jar"
# FILES_${PN} += "/usr/share/java/apps/NetworkingGUI.jar"
APIVERSION = "2.1"

PR = "${INC_PR}.10"
BUNDLE_PERM = "0744"