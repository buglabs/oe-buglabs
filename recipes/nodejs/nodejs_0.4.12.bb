DESCRIPTION = "nodeJS Evented I/O for V8 JavaScript"
HOMEPAGE = "http://nodejs.org"
LICENSE = "MIT"

DEPENDS = "openssl"

PR = "r1"

def nodejs_get_gcc_version(d):
    import subprocess,os,bb
    if os.path.exists(bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc'):
        return subprocess.Popen([bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc', '-v'], stderr=subprocess.PIPE).communicate()[1].splitlines()[-1].split()[2]

SRC_URI = " \
  http://nodejs.org/dist/node-v${PV}.tar.gz \
  file://libev-cross-cc_0.4.0.patch \
"

# This patch should only be applied for earlier GCC versions.
SRC_URI += "${@["", "file://0001-Add-missing-compiler-flags-for-GCC-4.3.patch"][nodejs_get_gcc_version(d) <= "4.3.3"]}"

SRC_URI[md5sum] = "a6375eaa43db5356bf443e25b828ae16"
SRC_URI[sha256sum] = "c01af05b933ad4d2ca39f63cac057f54f032a4d83cff8711e42650ccee24fce4"

S = "${WORKDIR}/node-v${PV}"

# v8 errors out if you have set CCACHE
CCACHE = ""

do_configure () {
  ./configure --prefix=${prefix} --without-snapshot
}

do_compile () {
  make
}

do_install () {
  DESTDIR=${D} oe_runmake install
}

BBCLASSEXTEND = "native"
