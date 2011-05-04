#!/bin/bash
#
# Script to install OpenEmbedded for BUG
# usage: oe-install.sh install_dir package_src_dir tmp_dir

OE_DIR=$1
OE_SOURCES=$2
OE_TMP=$3

if [ -d ${OE_DIR} ]
then
        echo "Installation directory already exists, refusing to continue."
        #exit -1
fi

mkdir -p ${OE_DIR}
cd ${OE_DIR}
git clone git://github.com/buglabs/oe-buglabs.git
cd oe-buglabs/
git checkout -b buglabs-sw2.1 origin/buglabs-sw2.1
cd ..

# test if bitbake exist; if not; fetch it and untar it
if [ ! -d bitbake-1.10.2 ]
then
        wget http://download.berlios.de/bitbake/bitbake-1.10.2.tar.gz
        tar xf bitbake-1.10.2.tar.gz
fi

echo "Bug Labs OE build system installed, proceed to configuration."
