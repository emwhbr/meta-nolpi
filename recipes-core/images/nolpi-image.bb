DESCRIPTION = "Image definition for Raspberry Pi3, Nol edition"

LICENSE = "MIT"

inherit core-image

COMMON_FEATURES = " \
    allow-root-login \
    allow-empty-password \
    hwcodecs \
    "
IMAGE_FEATURES += "${COMMON_FEATURES}"

# Basic OS components
CORE_OS_INSTALL = " \
    kernel-modules \
    packagegroup-core-boot \
    packagegroup-core-ssh-dropbear \
    openssh-sftp-server \
    libstdc++ \
"

# Firmware files for Raspberry Pi hardware
RPI_FW_INSTALL = " \
    linux-firmware-rpidistro-bcm43455 \
"

# Framebuffer support
FB_TOOLS_INSTALL = " \
    fb-test fbgrab fbida \
"

# Touchscreen support
TS_TOOLS_INSTALL = " \
    evtest \
    tslib tslib-calibrate tslib-tests \
"

# Wifi support
WIFI_TOOLS_INSTALL = " \
    iw \
    wpa-supplicant \
"

# Misc
EXTRA_TOOLS_INSTALL = " \
    i2c-tools \
    usbutils \
"

IMAGE_INSTALL = " \
    ${CORE_OS_INSTALL} \
    ${RPI_FW_INSTALL} \
    ${FB_TOOLS_INSTALL} \
    ${TS_TOOLS_INSTALL} \
    ${WIFI_TOOLS_INSTALL} \
    ${EXTRA_TOOLS_INSTALL} \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

# Add to SDK target sysroot
TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc linux-libc-headers-dev"

# No locales
IMAGE_LINGUAS = ""

# Make RFS fixed size (50MB)
IMAGE_ROOTFS_SIZE = "51200"

# Set empty root password
inherit extrausers
EXTRA_USERS_PARAMS = "\
    usermod -P \"\" root; \
    "
