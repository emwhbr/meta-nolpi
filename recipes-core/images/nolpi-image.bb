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
"

# Misc
EXTRA_TOOLS_INSTALL = " \
"

IMAGE_INSTALL = " \
    ${CORE_OS_INSTALL} \
    ${FB_TOOLS_INSTALL} \
    ${TS_TOOLS_INSTALL} \
    ${WIFI_TOOLS_INSTALL} \
    ${EXTRA_TOOLS_INSTALL} \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

# No locales
IMAGE_LINGUAS = " "

# Add extra free disk space
IMAGE_OVERHEAD_FACTOR = "2.0"

# Set empty root password
inherit extrausers
EXTRA_USERS_PARAMS = "\
    usermod -P \"\" root; \
    "
