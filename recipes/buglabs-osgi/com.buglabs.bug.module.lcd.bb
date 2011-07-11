require buglabs-osgi.inc

DESCRIPTION = "BUG LCD Module API"

PR = "${INC_PR}.6"
DEPENDS += "com.buglabs.bug.base.bug20 com.buglabs.bug.bmi com.buglabs.common com.buglabs.bug.jni.accelerometer com.buglabs.bug.ws com.buglabs.bug.jni.lcd com.buglabs.bug.jni.common" 
BUNDLE_PERM = "0744"