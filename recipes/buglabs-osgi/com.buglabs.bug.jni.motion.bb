require buglabs-osgi.inc
inherit jni-library

PR = "${INC_PR}.6"
FILES_${PN} += "${JNI_LIB_DIR}/libMotion.so"

DEPENDS += "com.buglabs.common com.buglabs.bug.jni.common com.buglabs.bug.jni.accelerometer classpath virtual/kernel"
