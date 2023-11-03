#!/bin/sh

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

if [ "$WAS_HOME" = "" ]; then
  export ERROR=1
  echo "ERROR - Environment Variable WAS_HOME is not defined"
  exit 1
fi

SCRIPTS_DIR=`dirname $0`
cd "$SCRIPTS_DIR/.."
SAMPLES_HOME=`pwd`
cd "$WAS_HOME/bin/"
REPLACE_WAS_HOME=$WAS_HOME
. "./setupCmdLine.sh"
cd "$SAMPLES_HOME"

#CONSOLE_ENCODING controls the output encoding used for stdout/stderr
#    console - encoding is correct for a console window
#    file    - encoding is the default file encoding for the system
#    <other> - the specified encoding is used.  e.g. Cp1252, Cp850, SJIS

PLATFORM=`/bin/uname`
case $PLATFORM in
  AIX)
    EXTSHM=ON
    LIBPATH="$WAS_LIBPATH":$LIBPATH
    CONSOLE_ENCODING=-Dws.output.encoding=console
    export LIBPATH EXTSHM CONSOLE_ENCODING;;
  Linux)
    LD_LIBRARY_PATH="$WAS_LIBPATH":$LD_LIBRARY_PATH
    CONSOLE_ENCODING=-Dws.output.encoding=console
    export LD_LIBRARY_PATH CONSOLE_ENCODING;;
  SunOS)
    LD_LIBRARY_PATH="$WAS_LIBPATH":$LD_LIBRARY_PATH
    CONSOLE_ENCODING=-Dws.output.encoding=console
    export LD_LIBRARY_PATH CONSOLE_ENCODING;;
  HP-UX)
    SHLIB_PATH="$WAS_LIBPATH":$SHLIB_PATH
    CONSOLE_ENCODING=-Dws.output.encoding=console
    export SHLIB_PATH CONSOLE_ENCODING;;
  OS/390|z/OS)
    ZOPTIONS="-Xnoargsconversion -Dfile.encoding=ISO-8859-1 $JVM_EXTRA_CMD_ARGS"
    ZINPUT_HANDLER="-inputhandler com.ibm.ws.ant.utils.WebSphereInputHandler";;
esac

while [ ${#} -gt 0 ]
do
        case "${1}" in
                *\"*\'*|*\'*\"*) echo "$1" | sed "s:\":\\\\\\\&:g; s:.*:\"&\":" | read argv;;
                *\"*) argv="'$1'";;
                *) argv="\"$1\"";;
        esac
        shift
        ARGS="${ARGS} ${argv}"
done

ARGS="${ARGS} -Dbasedir=$SAMPLES_HOME -Dwas_home=$WAS_HOME -Dprereq.classpath=$WAS_HOME/runtimes/com.ibm.jaxws.thinclient_8.0.0.jar:$WAS_HOME/runtimes/com.ibm.jaxws.thinclient_8.5.0.jar"

WAS_ANT_EXTRA_CLASSPATH="$WAS_HOME/lib/bootstrap.jar:$WAS_HOME/lib/j2ee.jar:$WAS_HOME/optionalLibraries/jython.jar:$WAS_HOME/optionalLibraries/jython/jython.jar"
WAS_ANT_CLASSPATH=$WAS_ANT_CLASSPATH:$WAS_HOME/plugins:$WAS_HOME/optionalLibraries/jython.jar:$WAS_HOME/lib/j2ee.jar

WAS_EXT_DIRS=$WAS_ANT_CLASSPATH:$WAS_EXT_DIRS

eval $JAVA_HOME/bin/java "$OSGI_INSTALL" "$OSGI_CFG" $WAS_LOGGING "$CONSOLE_ENCODING" "$CLIENTSAS" "$CLIENTSSL" -DWAS_USER_SCRIPT="$WAS_USER_SCRIPT" "$USER_INSTALL_PROP" -Dwas.install.root="$WAS_HOME" -Dwas.root="$WAS_HOME" -Dws.ext.dirs="$WAS_EXT_DIRS" -classpath "$WAS_CLASSPATH:$WAS_ANT_CLASSPATH" com.ibm.ws.bootstrap.WSLauncher org.apache.tools.ant.Main ${ARGS}
