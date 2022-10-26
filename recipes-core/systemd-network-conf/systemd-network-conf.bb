SUMMARY = "systemd network config"

LICENSE = "MIT"

PR = "r1"
inherit systemd

PACKAGES = "${PN}"

SRC_URI += " \
		file://wlan.network \
	"

do_install() {
	install -d ${D}${sysconfdir}/systemd/network
	install -m 0644 ${WORKDIR}/wlan.network ${D}${sysconfdir}/systemd/network
}

FILES_${PN}_append = "\
			${sysconfdir}/systemd/network/wlan.network \
		"
