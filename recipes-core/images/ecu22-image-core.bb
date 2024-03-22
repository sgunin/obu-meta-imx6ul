# ECU22 production image
DESCRIPTION = "ECU22 production image"

inherit core-image

# Image install
IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

## Select Image Features
IMAGE_FEATURES += " \
    package-management \
    nfs-server \
    ssh-server-openssh \
"

IMAGE_LINGUAS = " "

CORE_IMAGE_EXTRA_INSTALL = " \
    rpm \
    tar \
    bzip2 \
    gzip \
    imx-uuc \
    imx-kobs \
    myir-regulatory \
    firmware-imx \
    firmware-brcm43362 \
    kernel-module-rtl8188fu \
    udev-extraconf \
    udev-rules-imx \ 
    vlan \
    iperf3 \
    iproute2 \
    iptables \
    iputils \
    net-tools \
    ethtool \
    ntpdate \
    ppp \
    ppp-quectel \
    wpa-supplicant \
    wpa-supplicant-cli \
    wpa-supplicant-passphrase \
    openssh \
    openssl \
    cpio \
    cryptodev-module \
    e2fsprogs \
    libgpiod \
    libgpiod-tools \
    hostapd \
    vsftpd \
    evtest \
    watchdog \
    i2c-tools \
    canutils \
    mtd-utils \
    mtd-utils-ubifs \
    mmc-utils \
"

# Custom image_install variable
IMAGE_INSTALL_append += "libgpiod"
IMAGE_INSTALL_remove = " psplash \
                         ofono \
                         alsactl \
                         apmd \
"

# Image core minimal
IMAGE_ROOTFS_SIZE = "1024000"

PACKAGE_INSTALL_remove = " psplash apmd "
FEATURE_INSTALL_remove = " psplash "
IMAGE_FEATURE_remove = " psplash "
