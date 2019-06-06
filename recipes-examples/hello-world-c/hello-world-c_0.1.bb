SUMMARY = "Simple hello world application (C)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://main.c"

S = "${WORKDIR}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

do_compile() {
	${CC} ${LDFLAGS} main.c -o hello_world_c
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello_world_c ${D}${bindir}
}
