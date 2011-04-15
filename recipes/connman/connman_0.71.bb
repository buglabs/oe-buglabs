require connman.inc
# connman requires libXtables now
DEPENDS += "iptables"
PR = "r1"

EXTRA_OECONF += "\
  --disable-gtk-doc \
  --enable-debug \
  --enable-threads \
  --enable-loopback \
  --enable-ethernet \
  --enable-wifi \
  --disable-wimax \
  --enable-bluetooth \
  --enable-ofono \
  --enable-resolvconf \
  --enable-dnsproxy \
  --enable-tools \
  --disable-polkit \
  --enable-client \
  --enable-fake \
"

SRC_URI  = "\
  http://www.kernel.org/pub/linux/network/connman/connman-${PV}.tar.gz \
  file://link-against-libnl2.patch \
  file://connman \
"

SRC_URI[md5sum] = "e38515b91c0539aa8bbcc7ad865e6975"
SRC_URI[sha256sum] = "0c8a34e012ff78c70ffbc54bd47b12699149ba9f0e0a77829fe76111b363a5ad"
