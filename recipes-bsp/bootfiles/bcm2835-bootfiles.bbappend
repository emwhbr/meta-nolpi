# Remove not used bootfiles
do_deploy_append() {

	# We only need start.elf and fixup.dat

	rm ${DEPLOYDIR}/${PN}/start_cd.elf
	rm ${DEPLOYDIR}/${PN}/start_db.elf
	rm ${DEPLOYDIR}/${PN}/start_x.elf

	rm ${DEPLOYDIR}/${PN}/fixup_cd.dat
	rm ${DEPLOYDIR}/${PN}/fixup_db.dat
	rm ${DEPLOYDIR}/${PN}/fixup_x.dat
}
