# hellospringboot
This is the  Spring boot application which demonstrate how  to deploy the Spring boot application in AWS EC2 

Following are the command which need  to provide as user data in EC2 whcih will download the jar from S3 and start the application in EC2

*****download jar from S3 and start applciation in EC2********

#!/bin/bash

cd /opt

sudo yum -y install wget

sudo yum  -y install java-1.8.0-openjdk

sudo wget https://*users3bucketname*.s3.*region*.amazonaws.com/springboot/firstproject-0.0.1-SNAPSHOT.jar

sudo java -jar firstproject-0.0.1-SNAPSHOT.jar

