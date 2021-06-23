

This project is a collestion of Virtualized Network Functions (VNF) and Network Services (NS) descriptors for Open Source Mano (OSM).

Most of the templates for these packages have been taken from https://osm.etsi.org/gitlab/vnf-onboarding/osm-packages.git

**DEPLOYMENT**

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

