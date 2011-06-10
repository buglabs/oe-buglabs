require buglabs-osgi.inc

DESCRIPTION = "BUG Motion module API"

PR = "${INC_PR}.6"
DEPENDS += "com.buglabs.common com.buglabs.bug.module com.buglabs.bug.jni.motion com.buglabs.bug.jni.accelerometer com.buglabs.bug.jni.common felix-configadmin" 
