
RPI_CONFIG_TXT = "${DEPLOYDIR}/bcm2835-bootfiles/config.txt"

do_deploy_append() {

	echo "# Added by recipe ${PN}_${PV}" >> ${RPI_CONFIG_TXT}

	# SPI bus support
	echo "dtparam=spi=on" >> ${RPI_CONFIG_TXT}

	# I2C bus support
	echo "dtparam=i2c1=on"    >> ${RPI_CONFIG_TXT}
	echo "dtparam=i2c_arm=on" >> ${RPI_CONFIG_TXT}

	# Enable PITFT35r
	echo "dtoverlay=pitft35-resistive,rotate=90,speed=20000000,fps=20" >> ${RPI_CONFIG_TXT}

	# Enable UART
	echo "enable_uart=1" >> ${RPI_CONFIG_TXT}
}
