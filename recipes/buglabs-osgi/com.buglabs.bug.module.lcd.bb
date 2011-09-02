require buglabs-osgi.inc

DESCRIPTION = "BUG LCD Module API"

PR = "${INC_PR}.7"
DEPENDS += "com.buglabs.bug.bmi com.buglabs.common com.buglabs.bug.jni.accelerometer com.buglabs.bug.ws com.buglabs.bug.jni.lcd com.buglabs.bug.jni.common" 
BUNDLE_PERM = "0744"