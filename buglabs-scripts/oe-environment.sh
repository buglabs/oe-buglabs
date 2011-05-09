#!/bin/bash

BUILDBRANCH=$1

if [ ! -d oe-buglabs ]; then
	echo "This script must be run from the build root directory."
	exit 1
fi

if [ ! -d conf ]; then
	echo "A build configuration does not exist, run oe-configure.sh"
	exit 1
fi

# TOPDIR is where we are now
TOPDIR=`pwd`

# add bitbake to the path
export PATH=${TOPDIR}/bitbake-1.10.2/bin:$PATH
export BBPATH=${TOPDIR}:${TOPDIR}/oe-buglabs
export BB_ENV_EXTRAWHITE="MACHINE DISTRO TOPDIR"

echo $BBPATH
echo "Bitbake environment setup complete."
