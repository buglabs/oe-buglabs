#!/bin/sh
if [ -e /sys/class/net/eth0 ]; then
    echo eth1assoc > /sys/class/leds/omap3bug\:green\:wifi/trigger
else
    echo eth0assoc > /sys/class/leds/omap3bug\:green\:wifi/trigger
fi
