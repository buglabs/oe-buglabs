require bug-app.inc

DESCRIPTION = "NetworkingGUI provides a GUI for configuring the network."
HOMEPAGE = "http://www.buglabs.net/applications/NetworkingGUI"

DEPENDS += "service-tracker com.buglabs.common com.buglabs.osgi.shell com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://www.buglabs.net/program_version/download/527"
JARFILENAME = "NetworkingGUI.jar"
FILES_${PN} += "/usr/share/java/apps/NetworkingGUI.jar"
APIVERSION = "2.1"
