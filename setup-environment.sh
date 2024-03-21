#!/bin/sh
#
# ECU22 IMX6UL Project Build Environment Setup Script

CWD=`pwd`
PROGNAME="setup-environment"
BUILD_DIR="build"
DISTRO="ecu22-distro"
MACHINE="ecu22-imx6ul"

# Cleanup previous meta-freescale/EULA overrides
cd sources/meta-freescale
if [ -h EULA ]; then
    echo Cleanup meta-freescale/EULA...
    git checkout -- EULA
fi
if [ ! -f classes/fsl-eula-unpack.bbclass ]; then
    echo Cleanup meta-freescale/classes/fsl-eula-unpack.bbclass...
    git checkout -- classes/fsl-eula-unpack.bbclass
fi
cd -

# Override the click-through in meta-freescale/EULA
FSL_EULA_FILE=sources/meta-myir/EULA.txt

# Set up the basic yocto environment
DISTRO=$FSLDISTRO MACHINE=$MACHINE . ./$PROGNAME $BUILD_DIR

# Point to the current directory since the last command changed the directory to $BUILD_DIR
BUILD_DIR=.

# Copy local.conf file to build directory, if file not exist
if [ ! -e $BUILD_DIR/conf/local.conf ]; then
    cp local.conf $BUILD_DIR/conf/

# Copy bblayers.conf file to build directory, if file not exist
if [ ! -e $BUILD_DIR/conf/bblayers.conf ]; then
    cp bblayers.conf $BUILD_DIR/conf/bblayers.conf.org

cd  $BUILD_DIR
unset CWD BUILD_DIR 
