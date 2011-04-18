require bug-app.inc

DESCRIPTION = "NetworkingGUI provides a GUI for configuring the network."
HOMEPAGE = "http://www.buglabs.net/applications/NetworkingGUI"

DEPENDS += "service-tracker com.buglabs.common com.buglabs.bug.module.lcd com.buglabs.bug.networking"

PV = "2"

SRC_LINK = "http://www.buglabs.net/program_version/download/1431"
JARFILENAME = "NetworkingGUI.jar"
FILES_${PN} += "/usr/share/java/apps/NetworkingGUI.jar"
APIVERSION = "2.1"

