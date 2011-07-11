require felix.inc

PR = "${INC_PR}"
FQPN="${PN}"
SRC_URI = "${APACHE_MIRROR}/felix/${FQPN}-${PV}-bin.tar.gz"

datadir_java = ${datadir}/java/bundle/

FILES_${PN}="${datadir_java}"

addtask prep_install after do_compile before do_install
do_prep_install(){
   install -m 0644 ${FQPN}-${PV}.jar ${S}/${BPN}.jar
}
