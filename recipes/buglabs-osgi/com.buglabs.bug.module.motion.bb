require buglabs-osgi.inc

DESCRIPTION = "BUG Motion module API"

PR = "${INC_PR}.7"
DEPENDS += "com.buglabs.common com.buglabs.bug.ws com.buglabs.bug.jni.motion com.buglabs.bug.jni.accelerometer com.buglabs.bug.jni.common felix-configadmin com.buglabs.bug.bmi" 
BUNDLE_PERM = "0744"