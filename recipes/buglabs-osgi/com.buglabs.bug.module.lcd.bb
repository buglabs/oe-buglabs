require buglabs-osgi.inc

DESCRIPTION = "BUG LCD Module API"

PR = "${INC_PR}.8"
DEPENDS += "com.buglabs.bug.bmi com.buglabs.common com.buglabs.bug.jni.accelerometer com.buglabs.bug.ws com.buglabs.bug.jni.lcd com.buglabs.bug.jni.common com.buglabs.bug.bmi" 
BUNDLE_PERM = "0744"