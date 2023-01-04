#!/bin/bash

export R_LIBS=${DB2_HOME}/R/lib:${R_LIBS}

if [ ! -z ${DB2_RUDF_LOGFILE} ];then
  LOGFILE=${DB2_RUDF_LOGFILE}
  echo "DB2_HOME=${DB2_HOME}" >> ${LOGFILE}
  echo "R_PATH=${NZAE_R_PATH}" >> ${LOGFILE}
  echo "R_LIBS=${R_LIBS}" >> ${LOGFILE}
  echo "Running UDF '${NZAE_RCODE_PATH}' as user '`whoami`':" >> ${LOGFILE}
  exec ${NZAE_R_PATH} --slave --no-restore --no-save -e "library(nzrserver); nzrserver:::dispatcher()" 1>>${LOGFILE} 2>>${LOGFILE}
else
  exec ${NZAE_R_PATH} --slave --no-restore --no-save -e "library(nzrserver); nzrserver:::dispatcher()"
fi

