ANT_TARGETS = "create_dirs build.jars"

BRANCH = "master"
SRC_URI = "git://github.com/buglabs/smack-smackx-osgi.git;protocol=git;branch=${BRANCH}"


require buglabs-osgi.inc

DESCRIPTION = "XMPP Library for Java"
LICENSE = "ASL"

PR = "${INC_PR}.0"
