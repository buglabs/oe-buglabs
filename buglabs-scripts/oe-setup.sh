#!/bin/bash
#
# Script to install OpenEmbedded for BUG
# usage: oe-setup.sh install_dir package_src_dir tmp_dir

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
source oe-buglabs/buglabs-scripts/reinstate-build-env

# Modify the script variables as specified in parameters
mv conf/local.conf conf/local.conf.tmp
sed -i '/^DL_DIR/d' conf/local.conf.tmp
sed -i '/^TMPDIR/d' conf/local.conf.tmp

echo "DL_DIR=\"$OE_SOURCES\"" > conf/local.conf
echo "TMPDIR=\"$OE_TMP\"" >> conf/local.conf
cat conf/local.conf.tmp >> conf/local.conf
rm conf/local.conf.tmp

echo "Bug Labs OE build system setup.  Proceed to bitbaking."
