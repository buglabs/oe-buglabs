ANT_TARGETS = "create_dirs build.jars append.resources"
require buglabs-osgi.inc

DESCRIPTION = "BUGdash2 is a web-based admin system for BUG."

DEPENDS += "com.buglabs.util.shell com.buglabs.osgi.sewing sprinkles knapsack"

PR = "${INC_PR}.7"
BUNDLE_PERM = "0744"
