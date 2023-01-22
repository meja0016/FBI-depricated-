#!/bin/sh

echo "" > nonPoilceJacl.jacl

for i in `ls | grep nonPolice`; do 
	echo "\$AdminApp deploy nonPolice$i.war" >> nonPoliceJacl.jacl
done

docker cp *.jacl www-websphere-1:/tmp

/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/bin/wsadmin.sh -username wsadmin -p $1 /tmp/nonPoliceJacl.jacl
