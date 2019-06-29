# meta-nolpi

## General
Yocto layer for Raspberry Pi 3 Model B+ development board.

This layer is customized for the "Nol Edition" using the following hardware
* Raspberry Pi 3 Model B+
* TFT 3.5" Touchscreen (adafruit) 

The layer includes:
* Linux distro ("nolix") using systemd as init manager.
* Machine ("nolpi3") with U-Boot and Kernel modifications.
* Images ("nolpi-image" and "nolpi-image-debug") for MicroSD/USB storage.

## Dependencies

This layer depends on:

* URI: git://git.yoctoproject.org/poky
  * Yocto 2.7 "Warrior"
  * branch: master
  * revision: 08445c4c3cb76ed82c98ae672b8e891f64653cdc
* URI: git://git.openembedded.org/meta-openembedded
  * branch: master
  * revision: dd5622ef2b4065dc80ee549c57a2ec5010d0b4d1
* URI: git://git.yoctoproject.org/meta-raspberrypi
  * branch: master
  * revision: 920822c0fbfab31eb8959278f5e7f13b1460d19e
  
## Quick start
1. Add layers to bblayers.conf
2. Set MACHINE = "nolpi3" in local.conf
3. Set DISTRO = "nolix" in local.conf
4. bitbake nolpi-image
5. dd to MicroSD card the generated image (nolpi-image-nolpi3.rpi-sdimg)
  
## Sample bblayers.conf
```
POKY_BBLAYERS_CONF_VERSION = "2"
BBPATH = "${TOPDIR}"
BBFILES ?= ""
BBLAYERS ?= " \
  /proj2/rpi/yocto/sources/layers/poky/meta \
  /proj2/rpi/yocto/sources/layers/poky/meta-poky \
  /proj2/rpi/yocto/sources/layers/poky/meta-yocto-bsp \
  /proj2/rpi/yocto/sources/layers/meta-openembedded/meta-oe \
  /proj2/rpi/yocto/sources/layers/meta-openembedded/meta-multimedia \
  /proj2/rpi/yocto/sources/layers/meta-openembedded/meta-networking \
  /proj2/rpi/yocto/sources/layers/meta-openembedded/meta-python \
  /proj2/rpi/yocto/sources/layers/meta-raspberrypi \
  /proj2/rpi/yocto/sources/layers/meta-nolpi \
  "
  ```
  
