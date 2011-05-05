#!/bin/bash
#
# Script to install OpenEmbedded for BUG
# usage: oe-install.sh

if [ ! -d oe-buglabs ]; then
    echo "Installing OpenEmbedded"
	git clone git://github.com/buglabs/oe-buglabs.git oe-buglabs
	cd oe-buglabs/
	git checkout -b buglabs-sw2.1 origin/buglabs-sw2.1
	cd ..
fi

# test if bitbake exist; if not; fetch it and untar it
if [ ! -d bitbake-1.10.2 ]; then
	echo "Installing BitBake"
    wget http://download.berlios.de/bitbake/bitbake-1.10.2.tar.gz
    tar xf bitbake-1.10.2.tar.gz
fi

echo "Bug Labs OE build system installed, proceed to configuration."
