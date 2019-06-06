DESCRIPTION = "Debug image definition for Raspberry Pi3, Nol edition"

LICENSE = "MIT"

require nolpi-image.bb

# Add some extra tools.
# This includes the Raspberry Pi "userland" package with vcgencmd.
EXTRA_TOOLS_INSTALL_append = " \
    strace \
    userland \
"
