require buglabs-osgi.inc
PR = "${INC_PR}.8"
DEPENDS += "com.buglabs.bug.jni.libmatthew"
JAVAC_OPTIONS="-source 1.6"
MSGFMT="msgfmt"

do_compile_prepend() {
	mkdir build
	oe_makeclasspath cp -s ${DEPENDS}
	(cd translations; for i in *.po; do echo ${i%.po}; echo $i; ${MSGFMT} --java2 -r dbusjava_localized -d ../build -l ${i%.po} $i; echo ${i%.po}; echo $i; done)
	${MSGFMT} --java2 -r dbusjava_localized -d build translations/en_GB.po	
}