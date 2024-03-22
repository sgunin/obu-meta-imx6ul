# ECU22 production image
DESCRIPTION = "ECU22 production image"

inherit core-image

## Select Image Features
IMAGE_FEATURES += " \
    dev-pkgs \
    debug-tweaks \
    tools-profile \
    package-management \
    nfs-server \
    ssh-server-openssh \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    
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
    myir-rc-local \

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
    v4l-utils \
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
