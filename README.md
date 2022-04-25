Project Description
* Migrated and containerized a RESTful API web application to Spring Boot deployed using Docker-Compose. Application logs are exported using Promtail to Loki and monitored through a Grafana dashboard.

Requirements phase 1
* Spring Boot
* Spring WebMVC
* Spring Data JPA
* Junit

Requirements phase 2
* Docker and Docker compose used to containerize the application and database instance.
* Kubernetes is used to management, monitoring, scaling, and deployment of containerized applications
* Loki, Promtail, Prometheus and Grafana is used for log aggregation and metrics.
* Grafana is used to visualization metric and logs

Incorporate User functionality, for example:
* As a user, I can login.
* As a user, I can register for a customer account.
* As an employee, I can add an item to the storemenu.
* As a customer, I can view the available items.
* As a customer, I can purchase an item.
* As an employee, I can remove an item from the storemenu.
* As a customer, I can view the all items.
* Logging and Testing

Technolgy used:
* Java 8
* PostgreSQL, Hibernate, and Spring framework  
* Docker, Loki, Promtail, Prometheus and Grafana


Features:
* abled to use Https verbs like get, post,delete and pull for http request and respone.
* abled to record the log and metrics in seperate application.
* log using logback spring configuration.
* abled to display the log and metrics charts and table in Grafana using promtail, loki and prometheus.
* abled to use different types dependencies using Maven tools.
* able to use containerized applications using docker and docker-compose.
* able to use postgreSQL database using data.sql file.

Commands used:
* docker build .
* docker run -it project01
* docker-compose up -d
* docker-compose down


local host urls:
* localhost:8080/   (for API)
* localhost:3000  (for grafana)
* localhost:8081/actuator (for prometheus)
* localhost:3101/conf  (for promtail)
