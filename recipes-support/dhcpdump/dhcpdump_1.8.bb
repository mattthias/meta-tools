SUMMARY = "Parse DHCP packets from tcpdump"
DESCRIPTION = "This package provides a tool for visualization of DHCP packets on a network interface to analyze DHCP client requests and server responses."
LICENSE = "BSD-2-clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5e9f59632d6e3c2d90e0622bad6aaa10"

SRC_URI = "http://deb.debian.org/debian/pool/main/d/dhcpdump/dhcpdump_${PV}.orig.tar.gz"
SRC_URI[md5sum] = "099c786997c424f196414f9575f1fb90"
SRC_URI[sha1sum] = "96fae94d9bac4cf3b5a4c62be2b06a2d72a9fa48"
SRC_URI[sha256sum] = "6d5eb9418162fb738bc56e4c1682ce7f7392dd96e568cc996e44c28de7f77190"
SRC_URI[sha384sum] = "a0265e2a2355fb052c5bf736b84d38e7a6498e4bd9f6510b527821bb6194b001d5e99bfebf40cba56dfd53030622316f"
SRC_URI[sha512sum] = "52cd63d581a3c530c2f5baa66808d5b0241853651c720bd513b769b8301b4dff9c87243787014aea98a5b3ebed86ec317b58d262bf5031015141a4da50fb76e6"

# perl-native is needed for pod2man
DEPENDS = "libpcap perl-native"

# https://docs.yoctoproject.org/ref-manual/variables.html#term-TARGET_CC_ARCH
# The Makefile would otherwise not respect the exported LDFLAGS variable.
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	# NOTE: unable to determine what to put here - there is a Makefile but no
	# target named "install", so you will need to define this yourself
	install -d ${D}${sbindir}
        install dhcpdump ${D}${sbindir}/
}

