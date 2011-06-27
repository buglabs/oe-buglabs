require buglabs-osgi.inc
inherit jni-library

PR = "${INC_PR}.7"
FILES_${PN} += "${JNI_LIB_DIR}/libAccelerometer.so"

DEPENDS += "com.buglabs.common classpath com.buglabs.bug.jni.common virtual/kernel"

