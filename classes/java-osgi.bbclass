inherit java-library

# use java_stage for native packages
JAVA_NATIVE_STAGE_INSTALL = "1"

datadir_osgi ?= ${datadir}/osgi/bundle

def osgi_package_name(d):
  import bb;

  pre=""
  post=""

  pn = bb.data.getVar('PN', d, 1)
  if not pn.startswith("lib"):
    pre='lib'

  if not pn.endswith("-osgi"):
    post='-osgi'

  return pre + pn + post

JPN ?= "${@osgi_package_name(d)}"

DEPENDS_prepend = "virtual/javac-native fastjar-native ant-native bnd-native "

PACKAGES = "${JPN}"

PACKAGE_ARCH_${JPN} = "all"

FILES_${JPN} = "${datadir_osgi}"

# File name of the libraries' main Jar file
JARFILENAME = "${BP}.jar"

# Space-separated list of alternative file names.
ALTJARFILENAMES = "${BPN}.jar"

do_install_append() {
	if [ -z "${OSGI_PACKAGE_EXPORT_VERSION}" ]; then
		bnd wrap -output ${BP}-osgi.jar ${BP}.jar
	else
		echo "Export-Package: *;version=${OSGI_PACKAGE_EXPORT_VERSION}" > ${S}/bnd.properties
		bnd wrap -properties ${S}/bnd.properties -output ${BP}-osgi.jar ${BP}.jar
	fi
	
	oe_osgijarinstall ${BP}-osgi.jar
}

oe_osgijarinstall() {
  # Purpose: Install a jar file and create all the given symlinks to it.
  # Example:
  # oe_osgijarinstall foo-1.3.jar foo.jar
  # Installs foo-1.3.jar and creates symlink foo.jar.
  #
  # oe_osgijarinstall -s foo-1.3.jar foo.jar
  # Installs foo-1.3.jar to staging and creates symlink foo.jar.
  #
  # oe_osgijarinstall -r foo-1.3.jar foo_1_3.jar foo.jar
  # Installs foo_1_3.jar as foo-1.3.jar and creates a symlink to this.
  #
  dir=${D}${datadir_osgi}
  destname=""
  while [ "$#" -gt 0 ]; do
    case "$1" in
    -s)
			# put jar files to native staging if this is a -native recipe
			if [ ${PACKAGE_ARCH} = ${BUILD_ARCH} ]; then
	      dir=${STAGING_DATADIR_JAVA_NATIVE}
			else
	      dir=${STAGING_DATADIR_JAVA}
			fi
      ;;
    -r)
      shift
      destname=$1
      ;;
    -*)
      oefatal "oe_osgijarinstall: unknown option: $1"
      ;;
    *)
      break;
      ;;
    esac
    shift
  done

  jarname=$1
  destname=${destname:-`basename $jarname`}
  shift

  install -d $dir
  install -m 0644 $jarname $dir/$destname

  # Creates symlinks out of the remaining arguments.
  while [ "$#" -gt 0 ]; do
    if [ -e $dir/$1 -o -h $dir/$1 ]; then
      oewarn "file was in the way. removing:" $dir/$1
      rm $dir/$1
    fi
    ln -s $destname $dir/$1
    shift
  done
}