SUMMARY = "Demo application using LittlevGL"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit deploy
inherit externalsrc systemd

EXTERNALSRC = "${TOPDIR}/../sources/nol/demo-nolpi"
EXTERNALSRC_BUILD = "${TOPDIR}/../sources/nol/demo-nolpi"

OUTDIR = "${WORKDIR}/build"

# Build with debug information, avoid problems with
# -D_FORTIFY_SOURCE
# -fstack-protector-strong
DEBUG_BUILD = "1"

# Avoid problems with No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

# Force recompilation
do_compile[nostamp] = "1"

# Do a verbose build
EXTRA_OEMAKE = "bin/all OUTDIR=${OUTDIR} V=1"

SRC_URI_append = " \
	file://demo-nolpi.service \
"

SYSTEMD_SERVICE_${PN} = " \
	demo-nolpi.service \
"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${systemd_unitdir}/system

	# Install libraries
	install -m 0755 ${OUTDIR}/lib/liblittlevgl.so.1 ${D}${libdir}
   	ln -s liblittlevgl.so.1 ${D}${libdir}/liblittlevgl.so

	# Install executables
   	install -m 0755 ${OUTDIR}/bin/nolpi.exe ${D}${bindir}

   	# Install service files
   	install -m 0644 ${WORKDIR}/*.service ${D}${systemd_unitdir}/system
}
