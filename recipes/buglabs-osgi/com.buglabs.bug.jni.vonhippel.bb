require buglabs-osgi.inc
inherit jni-library

PR = "${INC_PR}.5"
FILES_${PN} += "${JNI_LIB_DIR}/libVonHippel.so"

DEPENDS += "com.buglabs.common classpath com.buglabs.bug.jni.common virtual/kernel"

