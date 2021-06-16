# SIMPLE OPEN-LDAP CHART

Descriptors that installs an openldap version 1.2.1 chart in a K8s cluster

There is one VNF (openldap\_vnf) with only one KDU.

There is one NS that connects the VNF to a mgmt network

## Onboarding and instantiation

```bash
osm nfpkg-create openldap_knf.tar.gz
osm nspkg-create openldap_ns.tar.gz
osm ns-create --ns_name ldap --nsd_name openldap_ns --vim_account <VIM_ACCOUNT_NAME>|<VIM_ACCOUNT_ID> --ssh_keys ${HOME}/.ssh/id_rsa.pub
```

### Instantiation option

Some parameters could be passed during the instantiation.

* replicaCount: Number of Open LDAP replicas that will be created

```bash
osm ns-create --ns_name ldap --nsd_name openldap_ns --vim_account <VIM_ACCOUNT_NAME>|<VIM_ACCOUNT_ID> --config '{additionalParamsForVnf: [{"member-vnf-index": "openldap", "additionalParams": {"replicaCount": "2"}}]}'
osm ns-create --ns_name ldap --nsd_name openldap_ns --vim_account <VIM_ACCOUNT_NAME>|<VIM_ACCOUNT_ID> --config_file params.yaml
```

## Test deployment

```bash
helm -n <PROJECT_ID> list
kubectl -n <PROJECT_ID> get all
kubectl -n <PROJECT_ID> get service
```

## Testing LDAP server

```bash
sudo apt-get update
sudo apt-get install ldap-utils
# With LB:
ldapsearch -x -H ldap://<LB_IP>:389 -b dc=example,dc=org -D "cn=admin,dc=example,dc=org" -w osm4u
# With NodePort
ldapsearch -x -H ldap://<NODE_IP>:<NODE_PORT> -b dc=example,dc=org -D "cn=admin,dc=example,dc=org" -w osm4u
```

