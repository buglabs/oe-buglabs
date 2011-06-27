require buglabs-osgi.inc
inherit jni-library

PR = "${INC_PR}.8"
FILES_${PN} += "${JNI_LIB_DIR}/libInputDevice.so"

DEPENDS += "com.buglabs.common com.buglabs.bug.jni.common classpath virtual/kernel"
