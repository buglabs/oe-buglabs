SECTION = "console/network"
DESCRIPTION = "PPP scripts for easy common carriers"
LICENSE = "GPL"
RDEPENDS_${PN} = "ppp"
PR = "r1"

SRC_URI = "file://peers/* file://chats/*"

do_install () {
        install -d ${D}${sysconfdir}/ppp/peers/
        install -d ${D}${sysconfdir}/ppp/chats/
        install -m 0644 ${WORKDIR}/peers/* ${D}${sysconfdir}/ppp/peers/
        install -m 0644 ${WORKDIR}/chats/* ${D}${sysconfdir}/ppp/chats/
}

PACKAGE_ARCH = "all"
