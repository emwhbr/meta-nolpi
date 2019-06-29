FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "\
	file://0001-Customize-U-Boot-for-nolpi3.patch \
	file://0002-Customize-U-Boot-for-nolpi3.patch \
	file://0003-Customize-U-Boot-for-nolpi3.patch \
"
