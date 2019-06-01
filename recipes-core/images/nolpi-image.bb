DESCRIPTION = "Image definition for Raspberry Pi3, Nol edition"

LICENSE = "MIT"

inherit core-image

COMMON_FEATURES = " \
    allow-root-login \
    allow-empty-password \
    hwcodecs \
    "
IMAGE_FEATURES += "${COMMON_FEATURES}"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    \
    packagegroup-core-ssh-dropbear \
    openssh-sftp-server \
    kernel-modules \
    fb-test fbgrab fbida \
    iw \
    evtest tslib tslib-calibrate tslib-tests \
    \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

# no locales
IMAGE_LINGUAS = " "

# add extra free disk space
IMAGE_OVERHEAD_FACTOR = "2.0"

# set empty root password
inherit extrausers
EXTRA_USERS_PARAMS = "\
    usermod -P \"\" root; \
    "
