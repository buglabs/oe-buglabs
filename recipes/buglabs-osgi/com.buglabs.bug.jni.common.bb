require buglabs-osgi.inc
inherit jni-library

PR = "${INC_PR}.6"
FILES_${PN} += "${JNI_LIB_DIR}/libCommon.so"

DEPENDS += "com.buglabs.common classpath"
