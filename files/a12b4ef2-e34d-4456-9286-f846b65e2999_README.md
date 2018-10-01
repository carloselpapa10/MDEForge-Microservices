# MDEForge Platform - A microservices-based application 
### Installation

### Prerequisites
	- Java 8
	- Maven 
	- Docker
		
- Configure DOCKER_HOST_IP variable [see](http://eventuate.io/docs/usingdocker.html).
- Eventuate Diagnostic [see](https://github.com/eventuate-local-docker-images/eventuateio-docker-networking-diagnostics).
- Install Jenkins BlueOcean (Optional)
	- docker run -u root -v /var/run/docker.sock:/var/run/docker.sock -p 8080:8080 -p 2375:2375 --name jenkins_blueocean jenkinsci/blueocean:latest

### Building and Running (2 ways)

- Jenkins Pipelines
	- Run Enviroment - EventuateComponentsJenkinsfile
	- Run Services - ServicesJenkinsfile
- Docker Compose
```sh
$ mvn clean package -s settings.xml docker:build
```

```sh
$ docker-compose build
$ docker-compose up
```

### Swagger UI
- User Service
```sh
http://localhost:5000/swagger-ui.html
```
- Workspace Service
```sh
http://localhost:5001/swagger-ui.html
```
- Project Service
```sh
http://localhost:5002/swagger-ui.html
```
- Artifact Service
```sh
http://localhost:5003/swagger-ui.html
```
- Mdeforgeview Service
```sh
http://localhost:5004/swagger-ui.html
```

MSc Carlos Avendaño

https://www.linkedin.com/in/carlos-alberto-avenda%C3%B1o-arango-534b0a137/