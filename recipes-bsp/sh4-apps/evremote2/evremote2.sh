#!/bin/sh

BRANDCHECK=`sed -En 's|^brand=(.+)$|\1|p' /usr/lib/enigma.info`
MODELCHECK=`sed -En 's|^model=(.+)$|\1|p' /usr/lib/enigma.info`

if [ -e /etc/.rccode ]; then
	echo "/etc/.rccode is present"
else
	echo "1" > /etc/.rccode
fi

if [ $MODELCHECK == "tf7700" ]; then
	mknod -m 0660 /dev/rc c 62 1
else
	mknod -m 0660 /dev/rc c 147 1
fi

if [ $BRANDCHECK == "edisionargus" ] || [ $BRANDCHECK == "fulan" ] || [ $BRANDCHECK == "forever" ] || [ $MODELCHECK == "hl101" ] || [ $MODELCHECK == "ufs912" ] || [ $MODELCHECK == "ufs913" ] || [ $MODELCHECK == "octagon1008" ] || [ $MODELCHECK == "opt9600" ]; then
	/bin/evremote2 10 120 &
elif [ $BRANDCHECK == "atemio" ] || [ $BRANDCHECK == "cuberevo" ] || [ $BRANDCHECK == "hs" ] || [ $MODELCHECK == "atevio7500" ] || [ $MODELCHECK == "fortis_hdbox" ]; then
	/bin/evremote2 10 140 &
elif [ $MODELCHECK == "tf7700" ]; then
	/bin/evremote2 110 10 &
elif [ $MODELCHECK == "ufc960" ] || [ $MODELCHECK == "ufs922" ]; then
	/bin/evremote2 0 0 10 120 &
elif [ $MODELCHECK == "arivalink200" ]; then
	/bin/evremote2 useLircdName &
else
	/bin/evremote2 &
fi
