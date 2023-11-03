#!/bin/ksh

# COPYRIGHT LICENSE: 
# This information contains sample code provided in source code form. You may 
# copy, modify, and distribute these sample programs in any form without 
# payment to IBM for the purposes of developing, using, marketing or 
# distributing application programs conforming to the application programming
# interface for the operating platform for which the sample code is written. 
# Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE
# ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, 
# INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF 
# MERCHANTABILITY, SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, 
# TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE 
# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES
# ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE. IBM HAS NO 
# OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR 
# MODIFICATIONS TO THE SAMPLE SOURCE CODE.

# Verify WAS environment
if [ "$WAS_HOME" == "" ]; then
  export ERROR=1
  echo "ERROR - Environment variable WAS_HOME is not defined"
  exit 1
fi

# Setup
SCRIPTS_DIR=`dirname $0`
cd "${SCRIPTS_DIR}"
SCRIPTS_DIR=`pwd`
cd ../..
SAMPLES_HOME=`pwd`
cd "$WAS_HOME/bin/"
REPLACE_WAS_HOME=$WAS_HOME
. "./setupCmdLine.sh"
cd "$SCRIPTS_DIR"

THIN_JAR_FILE=com.ibm.jaxws.thinclient_8.0.0.jar
THIN_JAR=$WAS_HOME/runtimes/$THIN_JAR_FILE
ENDORSED=-Djava.endorsed.dirs="$WAS_HOME/runtimes/endorsed"

# Verify the thinclient jar exists before we run
if [ ! -f $THIN_JAR ] 
then
  echo "Jar file "$THIN_JAR_FILE" cannot be located."
  THIN_JAR_FILE=com.ibm.jaxws.thinclient_8.5.0.jar
  THIN_JAR=$WAS_HOME/runtimes/$THIN_JAR_FILE
  if [ ! -f $THIN_JAR ] 
  then
    echo "Jar file "$THIN_JAR_FILE" cannot be located."
    echo "This sample requires installation of 'Stand-alone thin clients'."
   	echo "Please correct the installation options before running this sample."
    exit 1
  fi
fi

CLASSPATH=$THIN_JAR:$WAS_HOME/samples/lib/JaxWSServicesSamples/WSSampleClientSei.jar
$JAVA_HOME/bin/java $ENDORSED -cp "$CLASSPATH" com.ibm.was.wssample.sei.cli.SampleClient "$@"
exit 0
