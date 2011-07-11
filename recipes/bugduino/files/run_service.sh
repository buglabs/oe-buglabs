#if run manually start the bugduino service
echo $1 >> /home/root/tmp.txt

#if we have no options, just start the service
if [ $# -lt 1 ]; then
	echo 'blinstar' >> /home/root/tmp.txt
	#if we are already runing the service, don't start it
	if [  `pgrep -f "java Main -c"` ]; then 
		echo 'blinstar already going' >> /home/root/tmp.txt
		echo 'already running bugduino service'
 		exit 0 	
	fi
	cd /usr/bin/bugduino/
	echo 'java Main -c service'
	java Main -c &	
fi

#on device add, start the bugduino service
if [ $1 == 'start' ] ; then
	echo 'startdo' >> /home/root/tmp.txt
	#if we are already runing the service, don't start it
	if [  `pgrep -f "java Main -c"` ]; then 
		echo 'runningdu' >> /home/root/tmp.txt
		echo 'already running bugduino service'
 		exit 0 	
	fi
	echo 'java Main -c service 2'
	cd /usr/bin/bugduino/
	java Main -c &	
fi

# on device remove, kill the bugduino service
if [ $1 == 'stop' ] ; then
	echo 'pkill'>> /home/root/tmp.txt
	pkill -f "java Main -c"
fi	
