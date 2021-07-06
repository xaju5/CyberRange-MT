#!/usr/bin/env python3

import sys
import subprocess

sys.path.append("lib")

from ops.charm import CharmBase
from ops.main import main
from ops.model import ActiveStatus

class MyCharm(CharmBase):

    def __init__(self, framework, key):
        super().__init__(framework, key)

        # Listen to charm events
        self.framework.observe(self.on.config_changed, self.on_config_changed)
        self.framework.observe(self.on.install, self.on_install)
        self.framework.observe(self.on.start, self.on_start)

        # Listen to the touch action event
        self.framework.observe(self.on.touch_action, self.on_touch_action)
        self.framework.observe(self.on.start_service_action, self.start_service)
        self.framework.observe(self.on.stop_service_action, self.stop_service)
        self.framework.observe(self.on.install_service_action, self.install_service)

    def on_config_changed(self, event):
        """Handle changes in configuration"""
        self.model.unit.status = ActiveStatus()

    def on_install(self, event):
        """Called when the charm is being installed"""
        self.model.unit.status = ActiveStatus()

    def on_start(self, event):
        """Called when the charm is being started"""
        self.model.unit.status = ActiveStatus()

    def on_touch_action(self, event):
        """Touch a file."""

        filename = event.params["filename"]
        try:
            subprocess.run(["touch", filename], check=True)
            event.set_results({"created": True, "filename": filename})
        except subprocess.CalledProcessError as e:
            event.fail("Action failed: {}".format(e))
        self.model.unit.status = ActiveStatus()

    def start_service(self, event):
        """Start service action."""
        
        servicename = event.params["servicename"]

        if self.model.unit.is_leader():
            try:
                cmd = ["sudo","service",servicename,"start"]
                stdout = subprocess.run(cmd, check=True, capture_output=True)
                event.set_results({"output": stdout})
            except Exception as e:
                event.fail("Action failed {}. Stderr: {}".format(e, stdout))
        else:
            event.fail("Unit is not leader")

    def stop_service(self, event):
        """Stop service action."""
        
        servicename = event.params["servicename"]

        if self.model.unit.is_leader():
            try:
                cmd = ["sudo","service",servicename,"stop"]
                stdout = subprocess.run(cmd, check=True, capture_output=True)
                event.set_results({"output": stdout})
            except Exception as e:
                event.fail("Action failed {}. Stderr: {}".format(e, stdout))
        else:
            event.fail("Unit is not leader")

    def install_service(self, event):
        """install service """
        
        servicename = event.params["servicename"]

        if self.model.unit.is_leader():
            try:
                cmd = ["sudo","apt-get", "install",servicename,"-y"]
                stdout = subprocess.run(cmd, check=True, capture_output=True)
                event.set_results({"output": stdout})
            except Exception as e:
                event.fail("Action failed {}. Stderr: {}".format(e, stdout))
        else:
            event.fail("Unit is not leader")


if __name__ == "__main__":
    main(MyCharm)

