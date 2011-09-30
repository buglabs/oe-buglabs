# Copyright (C) 2011 Bug Labs, Inc

PR = "r1"

ALLOW_EMPTY = "1"

PACKAGES += "${PN}-java ${PN}-devlangs ${PN}-network ${PN}-build"

PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "${MACHINE_EXTRA_RRECOMMENDS} \
                  bug-udev \
                  repo-feed-configs \
                  diffutils \
                  logrotate \
                  lrzsz \
                  kernel-headers \
                  ntpclient \
                  tzdata \
                  nano \
                  lsof \
                  file \
                  zip \
"
RDEPENDS_${PN}_append_bug20 = "bug2v4l2"

RDEPENDS_${PN}-network = "\
                  dnsmasq \
                  hostap-daemon \
                  iptables \
                  eject \
                  dhcp-client \
                  usb-modeswitch \
                  usb-modeswitch-data \
                  iperf \
				  dropbear \
				  portmap \
"

RDEPENDS_${PN}-build = "\
                  make \
                  cups-dev \
                  libx11-dev \
                  patch-dev \
                  patchutils-dev \
                  sed-dev \
                  unzip \
                  wget \
                  alsa-dev \
                  alsa-lib-dev \
                  libxp-dev \                 
"

RDEPENDS_${PN}-devlangs = "\
                  lua5.1 \
                  python-modules \
                  python-misc \
                  openjdk-6-jre \	
				  python-pygobject \
				  python-dbus \
				  python-pybluez \
                  perl-modules \
                  task-native-sdk \
				  python-pyserial \
"

