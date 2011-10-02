require buglabs-osgi.inc
PR = "${INC_PR}.8"
DESCRIPTION = "BUG GPS Module API"

DEPENDS += "com.buglabs.common com.buglabs.bug.ws com.buglabs.bug.jni.gps com.buglabs.util.nmea com.buglabs.bug.jni.common felix-configadmin com.buglabs.bug.bmi"
BUNDLE_PERM = "0744"
