require buglabs-osgi.inc
DESCRIPTION = "BUG Von Hippel Module API"

PR = "${INC_PR}.13"
DEPENDS += "com.buglabs.common com.buglabs.bug.bmi com.buglabs.bug.ws com.buglabs.bug.jni.vonhippel com.buglabs.bug.jni.common felix-configadmin com.buglabs.bug.jni.rxtx"
BUNDLE_PERM = "0744"