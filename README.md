# J'Offre.ma
---
# Introduction 

### J'offre.ma is a web application build to help people and to help reduce waste that can harm the environnement while other people may be in need of.  
this application offers every type of aide items:  
* Electronics
* Household appliances
* Furniture 
* Clothing
* Tools
* Sport
* Others...
---
# Build
To build  this project there is two methodes:
* Simple  build using tomcat application server
* Using docker container

But before all that u you will need to clone the project or at least a part of it using the command:
* `$ sudo git clone https://github.com/Anas-Abou-Ali/Je_Offre.git`  //using the ssh methode is recommanded for security conserns.


for the first you will need:
* Tomcat application server version 9.0.2 o greater.
* Mysql (recommanded version 8.0.23)
* Create the database using the sql script in  Je_Offre/ProjectResources/database.sql 
* Set the envDB.properties located in the Je_Offre/src/main/java/com/JOffre/dao/envDB.properties
* Copy the war file in target/Offre.1.0.SNAPSHOT.war in [installation_path]/tomcat/webapp/
* Run the command in  [installation_path]/tomcat/bin/ `$ ./catalina.sh run`  
Now you can access the application using
### localhost:8080/[web_artifact_name]/. 
For runing the application in a Docker container after installing Docker engine for more info about how to install Docker engine check this https://docs.docker.com/engine/install/:  
* ` $ sudo docker build -t <image_name> [project_path]/Je_Offre/`  
after building  the docker image.  
* `$ sudo docker run -ti -p 8087:8080 --name <name_to_the_Container> <image_name>`
Now you can access the application using
### localhost:8087/[war_file_name]/.
 
 ---
# Run an already built image (pull from Docker Hub)
pull image from Docker Hub registry:
* ` $ sudo docker pull kingridda/joffrejee`  
run the the docker image:
* `$ sudo docker run -ti -p 8087:8080 --name <name_to_the_Container> kingridda/joffrejee`
Now you can access the application on:
### localhost:8087/Offre-1.0-SNAPSHOT/

---
# Source code
To build this project you can download the source code up in the repo using the command:  
* ` $ sudo git clone https://github.com/Anas-Abou-Ali/Je_Offre.git`
For better usability use an IDE.  
* Set tomcat configuration.
* Set source file and output files.
* Set the output artifact to web Exploded (recommanded)
* build and run your application.
---

# Screenshots:

![alt text](/screenshots/Joffre.jpg)

![alt text](/screenshots/login.jpeg)

![alt text](/screenshots/offre.png)

![alt text](/screenshots/profile1.png)



### For more info contact us at : anasabouali99@gmail.com or ridda.abdelghani@gmail.com
