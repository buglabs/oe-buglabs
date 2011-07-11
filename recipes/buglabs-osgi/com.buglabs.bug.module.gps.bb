require buglabs-osgi.inc
PR = "${INC_PR}.6"
DESCRIPTION = "BUG GPS Module API"

DEPENDS += "com.buglabs.common com.buglabs.bug.ws com.buglabs.bug.jni.gps com.buglabs.util.nmea com.buglabs.bug.jni.common felix-configadmin"
BUNDLE_PERM = "0744"
