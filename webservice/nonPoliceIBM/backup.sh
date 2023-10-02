#!/bin/sh
docker exec www_websphere_1  chmod 755 /opt/IBM/WebSphere/AppServer/profiles/AppSrv01/config
docker exec www_websphere_1  /opt/IBM/WebSphere/AppServer/profiles/AppSrv01/bin/backupConfig.sh -username wsadmin -password +GeHoqb5
