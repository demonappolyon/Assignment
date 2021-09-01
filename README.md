# Assignment
Front end and Back end service with K8s cluster setup

######################################
For backend Service
######################################
#Access StakaterBackend Folder

#Create jar for Backend Service
mvn install -f "StakaterBackend\pom.xml"

#Create Docker Image Backend Service
docker build --pull --rm -f "Dockerfile" -t stakaterbackend:v1 "."

######################################
For Frontend Service
######################################
#Access StakaterFrontend Folder
#Create jar for Frontend Service
mvn install -f "StakaterFrontend\pom.xml"

#Create Docker Image for frontend Service
docker build --pull --rm -f "Dockerfile" -t stakaterfrontend:v1 "." 

######################################
For Kubernetes deployment
###################################### 
#Access StakaterClusterK8s Folder
#Create ConfigMap which will be used by Frontend pod
kubectl create configmap frontend-service-config --from-file=application.properties

#To check if respective configmap was create or not and check values
Kubectl describe configmap frontend-service-config

#Deploy 
kubectl apply -f .\backend\ 
kubectl apply -f .\frontend\

#Check pod running status
kubectl get pod frontend-69954b67c-6rgpl
NOTE: in place of frontend-69954b67c-6rgpl add frontend pod name

#Access Terminal for frontend pod
kubectl exec --stdin --tty frontend-69954b67c-6rgpl -- /bin/bash

NOTE: in place of frontend-69954b67c-6rgpl add frontend pod name

#Api call inside frontend pod
curl localhost:8080/frontend/getDetails 
