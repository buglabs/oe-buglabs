require ofono.inc

PR = "${INC_PR}.0"

SRC_URI  = "http://www.kernel.org/pub/linux/network/ofono/${P}.tar.bz2 \
#            file://sierra-mc8790.patch \
            file://ofono"


SRC_URI[md5sum] = "b2656fd0bbf33f926fc86c1e8915d697"
SRC_URI[sha256sum] = "f8f8dd917847a007e4d441b949efc4d28dc3644526d5293016844c2536c65ff9"
