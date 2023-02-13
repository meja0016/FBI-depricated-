#!/bin/sh


docker cp nonPoliceWSAM.war www-websphere-1:/tmp/
docker cp nonPoliceJACL.jacl www-websphere-1:/tmp/
docker exec www-websphere-1 /opt/IBM/WebSphere/AppServer/profiles/AppSrv01/bin/wsadmin.sh -user wsadmin -password TAjB1FDY -f /tmp/nonPoliceJACL.jacl 
