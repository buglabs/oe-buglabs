#!/usr/bin/python2.6
#
# Script to generate recipes for BugNet applications
#
# Copyright 2010 Bug Labs Inc.
# Written by Marcin Juszkiewicz <marcin@buglabs.net>
#
# License: GPLv2
#
# To get list of all bugnet apps: http://api.buglabs.net/export?count=300
#

import io
from xml.etree.ElementTree import ElementTree

xmldata = ElementTree()
xmldata.parse("bugapps.xml")

root = xmldata.getroot()

# dict of Java class names to OpenEmbedded recipe names.
# some of entries maps to applications from bugnet
depsdict = {
# dependency                            recipe name
'audioapitester.pub':                   'com.buglabs.app.audiotestcase',
'bugdiscover.pub':                      'com.buglabs.app.bugdiscover',
'bugdiscover.pub':                      'com.buglabs.app.bugdiscover',
'bug.event':                            'com.buglabs.app.buttoneventadapter',
'ch.ethz.iks.r_osgi.channels':          'com.buglabs.app.remoteosgi',
'ch.ethz.iks.r_osgi.messages':          'com.buglabs.app.remoteosgi',
'ch.ethz.iks.r_osgi.service_discovery': 'com.buglabs.app.remoteosgi',
'ch.ethz.iks.r_osgi.types':             'com.buglabs.app.remoteosgi',
'ch.ethz.iks.r_osgi':                   'com.buglabs.app.remoteosgi',
'ch.ethz.iks.slp':                      'ch.ethz.iks.slp',
'ch.ethz.iks.util':                     'com.buglabs.app.remote osgi',
'com.bug.accelerometer.util.pub':       'com.bug.accelerometer.util',
'com.bug.accelerometer.util.pub':       'com.buglabs.app.shakemeasureservice',
'com.buglabs.application':              'com.buglabs.common',
'com.buglabs.bug.jni.accelerometer':    'com.buglabs.bug.jni.accelerometer',
'com.buglabs.bug.accelerometer.pub':    'com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion',
'com.buglabs.bug.accelerometer':        'com.buglabs.bug.accelerometer',
'com.buglabs.bug.base.pub':             'com.buglabs.bug.base',
'com.buglabs.bug.bmi.pub':              'com.buglabs.bug.bmi',
'com.buglabs.bug.event':                'com.buglabs.bug.event',
'com.buglabs.bug.jni.accelerometer':    'com.buglabs.bug.jni.accelerometer',
'com.buglabs.bug.jni.audio':            'com.buglabs.bug.jni.audio',
'com.buglabs.bug.jni.basedisplay':      'com.buglabs.bug.jni.basedisplay',
'com.buglabs.bug.jni.base':             'com.buglabs.bug.jni.basedisplay',
'com.buglabs.bug.jni.bluetooth':        'com.buglabs.bug.jni.bluetooth',
'com.buglabs.bug.jni.bugbeep':          'com.buglabs.bug.jni.bugbeep',
'com.buglabs.bug.jni.bugbee':           'com.buglabs.bug.jni.bugbee',
'com.buglabs.bug.jni.camera':           'com.buglabs.bug.jni.camera',
'com.buglabs.bug.jni.common':           'com.buglabs.bug.jni.common',
'com.buglabs.bug.jni.gps':              'com.buglabs.bug.jni.gps',
'com.buglabs.bug.jni.gsm':              'com.buglabs.bug.jni.gsm',
'com.buglabs.bug.jni.input':            'com.buglabs.bug.jni.input',
'com.buglabs.bug.jni.input.pub':        'com.buglabs.bug.jni.input',
'com.buglabs.bug.jni.lcd':              'com.buglabs.bug.jni.lcd',
'com.buglabs.bug.jni.motion':           'com.buglabs.bug.jni.motion',
'com.buglabs.bug.jni.pb':               'com.buglabs.bug.jni.pb',
'com.buglabs.bug.jni.sensor':           'com.buglabs.bug.jni.sensor',
'com.buglabs.bug.jni.vonhippel':        'com.buglabs.bug.jni.vonhippel',
'com.buglabs.bug.jni.xrandr':           'com.buglabs.bug.jni.xrandr',
'com.buglabs.bug.menu.pub':             'com.buglabs.bug.menu',
'com.buglabs.bug.module.pub':           'com.buglabs.bug.module',
'com.buglabs.bug.module.audio.pub':     'com.buglabs.bug.module.audio com.buglabs.bug.audio.common',
'com.buglabs.bug.module.bugbee.pub':    'com.buglabs.bug.module.bugbee',
'com.buglabs.bug.module.camera.pub':    'com.buglabs.bug.module.camera',
'com.buglabs.bug.module.gps.pub':       'com.buglabs.bug.module.gps',
'com.buglabs.bug.module.gsm.pub':       'com.buglabs.bug.module.gsm',
'com.buglabs.bug.module.lcd.pub':       'com.buglabs.bug.module.lcd',
'com.buglabs.bug.module.lcd.swt.pub':   'com.buglabs.app.swtdisplayprovider',
'com.buglabs.bug.module.motion.pub':    'com.buglabs.bug.module.motion',
'com.buglabs.bug.module.sensor.pub':    'com.buglabs.bug.module.sensor',
'com.buglabs.bug.module.vonhippel.pub': 'com.buglabs.bug.module.vonhippel',
'com.buglabs.bug.program.pub':          'com.buglabs.bug.program',
'com.buglabs.bug.service':              'com.buglabs.bug.service',
'com.buglabs.common.regexp.pub':        'com.buglabs.app.com.buglabs.common.regexp',
'com.buglabs.device':                   'com.buglabs.common',
'com.buglabs.m2mxml.datatype':          'com.buglabs.app.bugm2mxml',
'com.buglabs.m2mxml.exception':         'com.buglabs.app.bugm2mxml',
'com.buglabs.m2mxml.messages.commands': 'com.buglabs.app.bugm2mxml',
'com.buglabs.m2mxml.messages.percepts': 'com.buglabs.app.bugm2mxml',
'com.buglabs.m2mxml':                   'com.buglabs.app.bugm2mxml',
'com.buglabs.menu':                     'com.buglabs.bug.menu',
'com.buglabs.module':                   'com.buglabs.common',
'com.buglabs.nmea2':                    'com.buglabs.nmea',
'com.buglabs.nmea.sentences':           'com.buglabs.nmea',
'com.buglabs.nmea':                     'com.buglabs.nmea',
'com.buglabs.osgi.cm':                  'com.buglabs.osgi.cm',
'com.buglabs.osgi.http.pub':            'com.buglabs.osgi.http',
'com.buglabs.osgi.http':                'com.buglabs.osgi.http',
'com.buglabs.osgi.sewing.pub.util':     'com.buglabs.osgi.sewing com.sun.javax.servlet',
'com.buglabs.osgi.sewing.pub':          'com.buglabs.osgi.sewing com.sun.javax.servlet',
'com.buglabs.osgi.shell.pub':           'com.buglabs.osgi.shell',
'com.buglabs.osgi.shell':               'com.buglabs.common',
'com.buglabs.services.ws':              'com.buglabs.common',
'com.buglabs.status':                   'com.buglabs.common',
'com.buglabs.support':                  'com.buglabs.common',
'com.buglabs.tableviewer':              'com.buglabs.osgi.shell',
'com.buglabs.util.simplerestclient':    'com.buglabs.common',
'com.buglabs.util.trackers':            'com.buglabs.common',
'com.buglabs.util':                     'com.buglabs.common',
'com.google.zxing.common':              'com.buglabs.app.zxing4bug',
'com.google.zxing':                     'com.buglabs.app.zxing4bug',
'continuousmotorcontroller.pub':        'com.buglabs.app.continuousmotorcontroller',
'de.avetana.bluetooth.connection':      'com.buglabs.bug.jni.bluetooth',
'de.avetana.bluetooth.hci':             'com.buglabs.bug.jni.bluetooth',
'de.avetana.bluetooth.l2cap':           'com.buglabs.bug.jni.bluetooth',
'de.avetana.bluetooth.obex':            'com.buglabs.bug.jni.bluetooth',
'de.avetana.bluetooth.rfcomm':          'com.buglabs.bug.jni.bluetooth',
'de.avetana.bluetooth.sdp':             'com.buglabs.bug.jni.bluetooth',
'de.avetana.bluetooth.stack':           'com.buglabs.bug.jni.bluetooth',
'de.avetana.bluetooth.util':            'com.buglabs.bug.jni.bluetooth',
'demonotificationserver.pub':           'com.buglabs.app.demonotificationserver',
'edu.oswego.cs.dl.util.concurrent':     'edu.oswego.cs.dl.util.concurrent',
'freemarker.template':                  'com.buglabs.osgi.sewing com.sun.javax.servlet',
'gpsutilities.pub':                     'com.buglabs.app.gpsutilities',
'javax.bluetooth':                      'com.buglabs.bug.jni.bluetooth',
'javax.obex':                           'com.buglabs.bug.jni.bluetooth',
'javax.servlet.http':                   'com.sun.javax.servlet',
'javax.servlet.jsp':                    'com.sun.javax.servlet',
'javax.servlet.resources':              'com.sun.javax.servlet',
'javax.servlet':                        'com.sun.javax.servlet',
'junit.framework':                      'com.buglabs.app.blueback',
'latlonconverter.utils':                'com.buglabs.app.latlonconverter',
'latlonconverter':                      'com.buglabs.app.latlonconverter',
'menusbtestcase.pub':                   'com.buglabs.app.menusbtestcase',
'net.contentobjects.jnotify':           'net.contentobjects.jnotify',
'org.eclipse.spaces.xdrive.handlers':   'com.buglabs.app.org.eclipse.spaces.xdrive',
'org.eclipse.spaces.xdrive.http':       'com.buglabs.app.org.eclipse.spaces.xdrive',
'org.eclipse.spaces.xdrive.spi':        'com.buglabs.app.org.eclipse.spaces.xdrive',
'org.eclipse.spaces.xdrive.tos':        'com.buglabs.app.org.eclipse.spaces.xdrive',
'org.eclipse.spaces.xdrive':            'com.buglabs.app.org.eclipse.spaces.xdrive',
'org.eclipse.swt.accessibility':        'org.eclipse.swt.accessibility',
'org.eclipse.swt.accessibility':        'com.buglabs.app.libswt',
'org.eclipse.swt.browser':              'com.buglabs.app.libswt',
'org.eclipse.swt.custom':               'com.buglabs.app.libswt',
'org.eclipse.swt.dnd':                  'com.buglabs.app.libswt',
'org.eclipse.swt.events':               'com.buglabs.app.libswt',
'org.eclipse.swt.graphics':             'com.buglabs.app.libswt',
'org.eclipse.swt.layout':               'com.buglabs.app.libswt',
'org.eclipse.swt.opengl':               'com.buglabs.app.libswt',
'org.eclipse.swt.printing':             'com.buglabs.app.libswt',
'org.eclipse.swt.program':              'com.buglabs.app.libswt',
'org.eclipse.swt.widgets':              'com.buglabs.app.libswt',
'org.eclipse.swt':                      'com.buglabs.app.libswt',
'org.osgi.framework':                   'com.buglabs.osgi',
'org.osgi.service.cm':                  'com.buglabs.osgi',
'org.osgi.service.cm':                  'com.buglabs.osgi.cm',
'org.osgi.service.device':              'com.buglabs.osgi',
'org.osgi.service.event':               'com.buglabs.app.eventadmin',
'org.osgi.service.http':                'com.buglabs.osgi',
'org.osgi.service.http':                'com.buglabs.osgi.http',
'org.osgi.service.http.pub':            'com.buglabs.osgi.http',
'org.osgi.service.io':                  'com.buglabs.osgi',
'org.osgi.service.jini':                'com.buglabs.osgi',
'org.osgi.service.log':                 'com.buglabs.osgi',
'org.osgi.service.obr':                 'com.buglabs.osgi.obr',
'org.osgi.service.metatype':            'com.buglabs.osgi',
'org.osgi.service.packageadmin':        'com.buglabs.osgi',
'org.osgi.service.permissionadmin':     'com.buglabs.osgi',
'org.osgi.service.prefs':               'com.buglabs.osgi',
'org.osgi.service.provisioning':        'com.buglabs.osgi',
'org.osgi.service.startlevel':          'com.buglabs.osgi',
'org.osgi.service.upnp':                'com.buglabs.osgi',
'org.osgi.service.url':                 'com.buglabs.osgi',
'org.osgi.service.useradmin':           'com.buglabs.osgi',
'org.osgi.service.wireadmin':           'com.buglabs.osgi',
'org.osgi.util.measurement':            'com.buglabs.bug.module.gps',
'org.osgi.util.position':               'com.buglabs.bug.module.gps',
'org.osgi.util.tracker':                'service-tracker',
'org.osgi.util.xml':                    'com.buglabs.osgi',
'org.thenesis.midpath.sound.backend.alsa':                  'com.buglabs.bug.jni.audio',
'org.thenesis.midpath.sound':           'com.buglabs.bug.audio.common',
'org.thenesis.midpath.sound.codec':     'com.buglabs.bug.audio.common',
'com.jcraft.jogg':                      'com.buglabs.bug.audio.common',
'com.jcraft.jorbis':                    'com.buglabs.bug.audio.common', 
'pmea_image_utils':                     'com.buglabs.app.basicpmeaimageutils',
'publicwsadminextender':                'com.buglabs.app.publicwsadminextender',
'serviceproducer.pub':                  'com.buglabs.app.serviceproducer',
'shell.pub':                            'com.buglabs.app.shellservice',
#'shell.pub':                            'com.buglabs.app.bugdash',
'simplebatterymanager.pub':             'com.buglabs.app.simplebatterymanager',
'simplerestclient':                     'com.buglabs.app.simplerestclient',
#'simplerestclient':                     'com.buglabs.app.bugdash',
'webconfig666':                         'com.buglabs.app.webconfig666',
}

# list of known-to-be-broken bugapps
brokenapps = [ '', 'accelerometervisualizer', 'aimmotionnotifier',
		'audiomodulebuttontester', 'babycamera', 'buggraph',
		'bugmailsample', 'drawpad', 'fifteen', 'flickruppr2',
		'flickruppr', 'flyovercamera', 'geriatricassistant',
		'gpslogger1.1', 'gpslogger', 'gpsloggersimplegui',
		'gpsrawfeedexample', 'ircbotexample', 'jythongps',
		'log4jexample', 'motherbugtweetntwitch', 'motorcontrolws',
		'networkedbugapp', 'remotecamera', 'remoteservicelogger',
		'serialinputdisplay', 'simplelwuitsample',
		'swtdisplayprovider', 'twitterbug', 'vhapitester']

for bugapp in root.getchildren():

    # needed for generating depsdict
    bugappname = ''
    broken = 0

    for element in bugapp.getchildren():
        if element.tag == 'title':
            bugappname = element.text.lower().replace(' ', '').replace('_', '')
            recipefilename = 'com.buglabs.app.' + bugappname + '.bb'
            description = element.text
	    try:
		if brokenapps.index(bugappname):
		    broken = 1
	    except:
		pass
        elif element.tag == 'homepage':
            homepage = element.get('url')
        elif element.tag == 'description':
            if element.text:
                # we do not want empty lines, all lines needs to end with \, s/"/' to make BitBake parser happy, kill non-ascii chars
                description = element.text.replace("\n\n", "\n").replace("\n", "\\\n").replace('"', "'").encode('ascii', 'ignore')
        elif element.tag == 'program_version':
            # probably should go to recipefilename
            pv = element.text
        elif element.tag == 'download':
            source = element.get('url')
        elif element.tag == 'import_packages':
            # few apps lacks dependencies information - akweon works on them (old uploads)
            deps = ''
            if element.text:
                deps = element.text
        elif element.tag == 'api_version':
            # this field is filled by user so just 15/170 bugapps had it filled
            # API = 1.4.x is kind of warranty that it builds
            api_version = ''
            if element.text:
                api_version = element.text
        elif element.tag == 'export_packages':
            # some bugapps export Java classes for other apps - we need to have it in depsdict
            if element.text:
                for entry in element.text.split(', '):
                    try:
                        if not depsdict[entry]:
                            print "'%s':\t\t'com.buglabs.app.%s'," % (entry, bugappname)
                    except:
                        # entry is not in our dictionary - print it and add into this run
                        print "'%s':\t\t'com.buglabs.app.%s'," % (entry, bugappname)
                        depsdict[entry] = bugappname

    newdeps = []
    if deps:
        for dep in deps.split(', '):
            try:
                newdeps.append(depsdict[dep.replace(' ','')] + ' ')
            except:
                # we got dependency which is not in depsdict
                print "EXC:'%s'" % dep
                
    deps = ''.join(sorted(set(newdeps)))

    # output recipe
    file = open("out/" + recipefilename, 'w')
    file.write("require bug-app.inc\n")
    file.write("\n")
    file.write("DESCRIPTION = \"%s\"\n" % description)
    file.write("HOMEPAGE = \"%s\"\n" % homepage)
    file.write("\n")
    if deps:
	file.write("DEPENDS += \"%s\"\n" % deps)
	file.write("\n")
    file.write("PV = \"%s\"\n" % pv)
    file.write("\n")
    file.write("SRC_LINK = \"%s\"\n" % source)
    file.write("\n")
    file.write("APIVERSION = \"%s\"\n" % api_version)
    if broken:
	file.write("\n")
	file.write("BROKEN = \"1\"")
	file.write("\n")
    file.close()
