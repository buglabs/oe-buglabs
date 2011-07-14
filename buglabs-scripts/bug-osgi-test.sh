#!/bin/bash
# This script assumes it's running in the root of an oe-build, and that it is being called
# after a build has completed succesfully.
# The propose of the script is to execute tests against code contained in the depoy/sysroots output.
# It is designed to be called from within and without the CI system.

set -e

if [ -z $WORKSPACE ]; then
	echo "Setting WORKSPACE TO `pwd`"
	WORKSPACE=`pwd`
fi

cd $WORKSPACE

JAVA_OE_BUILD_DIR=$WORKSPACE/oe-tmp/sysroots/java
TEST_ROOT=$WORKSPACE/tests
BUILD_TOOLS=$TEST_ROOT/bug-osgi/com.buglabs.osgi.build
DEPS_DIR=$TEST_ROOT/subjects

if [ ! -d $TEST_ROOT ]; then
	mkdir $TEST_ROOT
fi

if [ ! -d $DEPS_DIR ]; then
	mkdir $DEPS_DIR
else 
	rm -Rf $DEPS_DIR
	mkdir $DEPS_DIR
fi

echo "Copying oe-built jars from $JAVA_OE_BUILD_DIR"
cp $JAVA_OE_BUILD_DIR/* $DEPS_DIR

if [ ! -f $DEPS_DIR/junit-osgi-4.9b2.jar ]; then
	wget --no-check-certificate -P $DEPS_DIR https://github.com/downloads/buglabs/bug-osgi/junit-osgi-4.9b2.jar
fi 

if [ ! -d $TEST_ROOT ]; then
	mkdir $TEST_ROOT
fi

if [ ! -d $TEST_ROOT/junit-reports ]; then
	mkdir $TEST_ROOT/junit-reports
else
	set +e
	# Delete old reports
	rm $TEST_ROOT/junit-reports/*
	set -e
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
	git reset --hard HEAD
	git pull
	cd ..
fi



echo "Running tests com.buglabs.common.tests"
ant -Dreport.dir=$TEST_ROOT/junit-reports -Dbase.build.dir=$BUILD_TOOLS -Dcheckout.dir=$TEST_ROOT/bug-osgi -DexternalDirectory=$DEPS_DIR -DdistDirectory=$DEPS_DIR -f $TEST_ROOT/bug-osgi/com.buglabs.common.tests/build.xml test

if [ ! -f $DEPS_DIR/com.buglabs.osgi.tester.jar ]; then
	echo "Building OSGi test runner"
	ant -Dbase.build.dir=$BUILD_TOOLS -Dcheckout.dir=$TEST_ROOT/bug-osgi -DexternalDirectory=$DEPS_DIR -DdistDirectory=$DEPS_DIR -f $TEST_ROOT/bug-osgi/com.buglabs.osgi.tester/build.xml build.jars
fi

ant -Dreport.dir=$TEST_ROOT/junit-reports -Dbase.build.dir=$BUILD_TOOLS -Dcheckout.dir=$TEST_ROOT/bug-osgi -DexternalDirectory=$DEPS_DIR -DdistDirectory=$DEPS_DIR -f $TEST_ROOT/bug-osgi/com.buglabs.common.tests/build.xml test-osgi

cd $WORKSPACE
echo "Test phase complete."