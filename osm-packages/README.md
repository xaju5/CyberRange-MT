

In this folder, there is a collection of Virtualized Network Functions (VNF) and Network Services (NS) descriptors for Open Source Mano (OSM).
The `_vnfs` folders are deployed on a Openstack server and the `_knfs` folders on a Kubernetes cluster.

Most of the templates for these packages have been taken from https://osm.etsi.org/gitlab/vnf-onboarding/osm-packages.git

# Deployment

To deploy a NS or VNF, download them into a OSM server and run:
```
osm nfpkg-create <vnf-folder_vnf>
osm nspkg-create <ns-folder_ns>
osm ns-create --ns_name <name> --nsd_name <ns_id-ns> --vim_account <VIM-account-name> --config '{vld: [ {name:mgmtnet, vim-network-name: <network-name>} ] }'
```
An alternative command for `nfpkg-create` and `nspkg-create` is:

```
osm upload-package <vnf or ns folder-name>
```

If the configuration parameters are in a file, use:
```
osm ns-create --ns_name <name> --nsd_name <ns_id-ns> --vim_account <VIM-account-name> --config_file <filename>
```
# Description of the Network Services
All the packages uses a cloud-init configuration for the admin user.

### CTF
This NS is a Capture The Flag (CTF) game. It consists of a Apache2 server, a Postfix server and a mySQL server.

### Basic_2vm
It is a basic NS with just two ubuntu-focal vnfs. There is an internal link that connects both of them.

### only1vm
This NS only has one vnf. It is usefull to deploy small standalone services.

### only2vm
It uses two only1vm_vnf to create a bigger NS than only1vm_ns. It is similar to basic_2vm_ns but in this case there is not any internal link.

### mysql
It uses a helm-chart from *stable* to deploy a mySQL server in Kubernetes cluster

### jujuweb
A NS consisting of 2 VNF. Each of them with an apache2 server and 2 virtual links (1 internal and 1 external). It uses a juju-chart with 3 primitives to touch a file in the VNF, to stop the apache2 service and to start the apache2 service.
In order to work, it is necessary to clone https://github.com/canonical/operator into `jujuweb_vnf/chams/mycharms/mod/` folder.

```
git clone https://github.com/canonical/operator jujuweb_vnf/chams/mycharms/mod/operator
```