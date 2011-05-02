require bug-app.inc

DESCRIPTION = " \
An example app that demonstrates the services available on the BUG camera module, aka BUGcamera. \
Press the user button on BUGbase to take a picture (with flash) and show it on the screen. \
"
HOMEPAGE = "http://www.buglabs.net/applications/BUGcamera%20Hello%20World"

DEPENDS += "com.buglabs.bug.module.camera com.buglabs.common com.buglabs.bug.module.lcd"

PV = "3"

SRC_LINK = "http://www.buglabs.net/program_version/download/1439"

APIVERSION = "2.0.2"
