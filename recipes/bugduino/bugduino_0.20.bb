require bugduino.inc
PR = "r2"

SRC_URI = "git://github.com/FarMcKon/bugduino_server.git;protocol=http;branch=master \
		file://run_service.sh \
		"

SRCREV=${AUTOREV}
