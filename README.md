
This repository is a compilation of the software developed for my Master Thesis in Telecommunications Technology.

It is about a cyber-range that deploys a *Capture The Flag* game to test the cybersecurity of Kubernetes, Openstack and Open Source Mano.

### osm-packages

A collection of Virtualized Network Functions (VNF) and Network Services (NS) descriptors for Open Source Mano (OSM). Some of the NS use a Juju charm which are fully implemented with Python.

### CTFWebValidator

An Eclipse Dinamic Web project for the validation of the cyber range exercises. I run it on a 8.5 Apache Tomcat server, but it may work for another type of web server.  
It consists of 3 pages: a validation page to fill out a form, a score page to view the test results, and a results page that lists the scores of all users.  
Download the CTFWebValidator.war file and deploy it on a Tomcat server to run the application.

### helm-charts

A openssh helm-chart with major vulnerabilities. The goal of this helm-charts is to test a privilege escalation on a Kubernetes cluster. For that purpouse, it uses a wrong configured hostpath volume to gain access to the host of the running Kubernetes pod. Be careful when installing it!
