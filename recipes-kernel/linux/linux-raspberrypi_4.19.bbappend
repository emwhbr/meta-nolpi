
RPI_CMDLINE_TXT = "${DEPLOYDIR}/bcm2835-bootfiles/cmdline.txt"

do_deploy_append() {

    # Create the kernel command line
    BASE_CMDLINE="dwc_otg.lpm_enable=0 root=/dev/mmcblk0p2 rootfstype=ext4 rootwait"
    SERIAL_PARAM="console=serial0,115200"
    PITFT_PARAM="fbcon=map:10 fbcon=font:VGA8x8"
    
    THE_CMDLINE="${BASE_CMDLINE} ${SERIAL_PARAM} ${PITFT_PARAM}"

    # Deploy cmdline.txt
    echo "${THE_CMDLINE}" > ${RPI_CMDLINE_TXT}
}
