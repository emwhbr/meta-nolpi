SUMMARY = "Raspberry Pi3, Nol edition (nolpi), modifications of systemd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/systemd:"

SRC_URI += " \
    file://20-wired.network \
"
do_install_append() {
    # The network files need to be in /etc/systemd/network
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/20-wired.network ${D}${sysconfdir}/systemd/network
}

FILES_${PN} += " \
    ${sysconfdir}/systemd/network \
    ${sysconfdir}/systemd/network/20-wired.network \
"
