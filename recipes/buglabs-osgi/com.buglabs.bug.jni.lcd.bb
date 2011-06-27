require buglabs-osgi.inc
inherit jni-library

PR = "${INC_PR}.7"
FILES_${PN} += "${JNI_LIB_DIR}/libLCD.so"

DEPENDS += "com.buglabs.common com.buglabs.bug.jni.common classpath virtual/kernel"
