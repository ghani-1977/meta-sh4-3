#!/bin/sh

rm /dev/rc
mknod /dev/rc c 147 1
/bin/evremote2 &
