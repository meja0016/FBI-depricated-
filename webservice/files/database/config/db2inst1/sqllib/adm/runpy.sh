#!/bin/bash

if [ ! -z ${DB2_PYUDF_DEBUG} ];then
  debug_flag="--debug-level=${DB2_PYUDF_DEBUG}"
fi

if [ ! -z ${DB2_PYUDF_TRACE} ];then
  trace_dir="${DB2_HOME}/db2dump/pythonUDX/"
  python_trace="-m trace ${DB2_PYUDF_TRACE}"
  output_redirect="$trace_dir/db2_pyudf_$(date +"%Y%m%d%H%M").trc"
  mkdir -p $trace_dir
  exec ${NZAE_PYTHON_PATH} $python_trace ${DB2_HOME}/python/launchAe.py $1 $debug_flag &> $output_redirect
else
  exec ${NZAE_PYTHON_PATH} ${DB2_HOME}/python/launchAe.py $1 $debug_flag
fi
