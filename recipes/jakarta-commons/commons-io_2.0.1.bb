require jakarta-commons.inc
inherit java-osgi

DEPENDS += "ant-native"

PACKAGE_ARCH = "all"
DESCRIPTION = "Java library with utility classes, stream implementations, file filters and endian classes"
PR = "r21"
RPROVIDES += "${PN}"
OSGI_PACKAGE_EXPORT_VERSION = "2.0.1"

SRC_URI = "http://www.apache.org/dist/commons/io/source/${BP}-src.tar.gz"

SRC_URI[md5sum] = "0bbe5b7a91f73ea8cc9a18e891732597"
SRC_URI[sha256sum] = "32be3e626618b49c2e2fb268bd2101d7ae38438131df4560fc800bd2f26fdff8"

do_compile() {
        ant -Dbuild.home=${S}
}
