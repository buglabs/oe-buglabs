#!/bin/bash
#
# Script to install OpenEmbedded for BUG
# usage: oe-setup.sh install_dir package_src_dir tmp_dir

OE_SOURCES=$1
OE_TMP=$2

if [ ! -d oe-buglabs ]; then
	echo "Not in build root directory."
	exit 1
fi

if [ -f conf/local.conf ]; then
	echo "Configuration already exists, not changing."
	exit
fi

if [ ! -d conf ]; then
	mkdir conf
fi

cp oe-buglabs/buglabs-scripts/local.conf conf/

# Modify the script variables as specified in parameters
mv conf/local.conf conf/local.conf.tmp
sed -i '/^DL_DIR/d' conf/local.conf.tmp
sed -i '/^TMPDIR/d' conf/local.conf.tmp

echo "DL_DIR=\"$OE_SOURCES\"" > conf/local.conf
echo "TMPDIR=\"$OE_TMP\"" >> conf/local.conf
cat conf/local.conf.tmp >> conf/local.conf
rm conf/local.conf.tmp

echo "Bug Labs OE build system configuration complete."
