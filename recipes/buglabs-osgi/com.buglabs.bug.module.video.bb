require buglabs-osgi.inc
DESCRIPTION = "BUG Video Module API"

PR = "${INC_PR}.4"
DEPENDS += "com.buglabs.common com.buglabs.bug.ws com.buglabs.bug.module.lcd com.buglabs.bug.base.bug20 com.buglabs.bug.bmi" 

BUNDLE_PERM = "0744"