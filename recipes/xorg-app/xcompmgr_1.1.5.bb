require xorg-app-common.inc
DESCRIPTION = "X Compositing Manager"
PRIORITY = "optional"
LICENSE = "BSD-X"
DEPENDS += "libxdamage libxcomposite libxrender"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "bf8faa8c540bfdcd0252801d8f16d868"
SRC_URI[archive.sha256sum] = "bb20737a6f9e0cdf5cfbd5288b6a9a4b16ca18d2be19444549c1d6be2a90b571"
