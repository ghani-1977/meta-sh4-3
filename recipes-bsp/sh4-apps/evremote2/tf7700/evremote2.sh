#!/bin/sh

rm /dev/rc
mknod /dev/rc c 62 1
/bin/evremote2 110 10 &
