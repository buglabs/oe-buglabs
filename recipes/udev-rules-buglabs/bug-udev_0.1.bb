DESCRIPTION = "UDEV Rules for BUG"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
RDEPENDS_${PN} = "udev"
PR = "r30"

SRC_URI = "file://00-bug20.rules \
	   file://bmi_eventpipe.sh \
	   file://bt_init.sh \
	   file://working.psr \
           file://mbkb-stop.sh \
           file://mbkb-start.sh \
		   file://wlan-trigger.sh \
           "

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -d ${D}/etc/udev/rules.d
    install -d ${D}/etc/udev/scripts
    install -m 0644 *.rules ${D}/etc/udev/rules.d
    install -m 0775 *.sh ${D}/etc/udev/scripts
    install -m 0644 working.psr ${D}/etc/udev/scripts/
}    
pkg_postinst_${PN} (){
    sed  "s/0011 2821 005b 6789/$(sed -e 's/smsc95xx.mac=\(..:..:..:..:..:..\) .*/\1/' -e 's/\(..\):\(..\):\(..\):\(..\):\(..\):\(..\)/00\4 \5\6 00\3 \1\2/' /proc/cmdline)/" /etc/udev/scripts/working.psr
}
	
