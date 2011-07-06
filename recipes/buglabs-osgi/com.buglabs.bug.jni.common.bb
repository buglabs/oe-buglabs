require buglabs-osgi.inc
inherit jni-library

PR = "${INC_PR}.8"
FILES_${PN} += "${JNI_LIB_DIR}/libCommon.so"

DEPENDS += "com.buglabs.common classpath"

JARFILENAME = ${PN}.jar