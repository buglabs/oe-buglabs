#set these variables to defaults if not already set
#BUILD_URL ?= ""
BUG_RELEASE_VERSION ?= "0.0"
BUILD_NUMBER ?= `date '+%m%d%y%H%M'`

IMAGE_NAME = "${IMAGE_BASENAME}-${MACHINE}-${BUG_RELEASE_VERSION}.${BUILD_NUMBER}"

inherit image

ROOTFS_POSTPROCESS_COMMAND += "rootfs_update_buildinfo"

rootfs_update_buildinfo () {
	echo "BUG Linux Build Information"	> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Version:    ${BUG_RELEASE_VERSION}.${BUILD_NUMBER}"		>> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Build Host: `uname -a`"		>> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Build User: `whoami`"		>> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Build Time: `date -u`"		>> ${IMAGE_ROOTFS}/etc/buildinfo
#	echo "Build Source: ${BUILD_URL}" >> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Revision:  ${METADATA_REVISION}"	>> ${IMAGE_ROOTFS}/etc/buildinfo

	# Alias stuff that normally should belong into the bashrc or similar
	echo "alias ipkg='opkg'" >>${IMAGE_ROOTFS}/etc/profile
	echo "alias ll='ls -al'" >>${IMAGE_ROOTFS}/etc/profile

	# Bandaid for RI1413
	echo "vm.min_free_kbytes = 4096" >> ${IMAGE_ROOTFS}/etc/sysctl.conf

	# We don't want persistent net rules as we would like to be able using
	# the same rootfs in other bugs.
	rm ${IMAGE_ROOTFS}/lib/udev/write_net_rules

	curdir=$PWD
	cd ${IMAGE_ROOTFS}/usr/lib/
	ln -sf libbluetooth.so.3 libbluetooth.so
	cd $curdir
}
