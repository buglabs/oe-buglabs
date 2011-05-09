#!/bin/bash

if [ -z $WORKSPACE ]; then
	echo "Setting WORKSPACE TO `pwd`"
	WORKSPACE=`pwd`
fi

cd $WORKSPACE

JAVA_OE_BUILD_DIR=$WORKSPACE/oe-tmp/sysroots/java
TEST_ROOT=$WORKSPACE/tests
BUILD_TOOLS=$TEST_ROOT/bug-osgi/com.buglabs.osgi.build
TEST_BIN=$TEST_ROOT/bin
DEPS_DIR=$TEST_ROOT/subjects


if [ ! -d $DEPS_DIR ]; then
	mkdir $DEPS_DIR
#else 
#	rm -Rf $DEPS_DIR
#	mkdir $DEPS_DIR
fi

cp $JAVA_OE_BUILD_DIR/* $DEPS_DIR

if [ ! -f $DEPS_DIR/junit-dep-4.9b2.jar ]; then
	wget --no-check-certificate -P $DEPS_DIR https://github.com/downloads/KentBeck/junit/junit-dep-4.9b2.jar
fi 

if [ ! -d $TEST_ROOT ]; then
	mkdir $TEST_ROOT
fi

if [ ! -d $TEST_BIN ]; then
	mkdir $TEST_BIN
fi

cd $TEST_ROOT

if [ ! -d bug-osgi ]; then
	git clone git@github.com:buglabs/bug-osgi.git
fi

if [ ! -d $BUILD_TOOLS ]; then
	echo "com.buglabs.osgi.build is not at $BUILD_TOOLS, aborting."
	exit 1
else 
	cd bug-osgi
	git pull
	cd ..
fi

ant -Dbase.build.dir=$BUILD_TOOLS -Dcheckout.dir=$WORKSPACE/bug-osgi -DexternalDirectory=$DEPS_DIR -DdistDirectory=$TEST_BIN -f $TEST_ROOT/bug-osgi/com.buglabs.common.tests/build.xml test

cd $WORKSPACE