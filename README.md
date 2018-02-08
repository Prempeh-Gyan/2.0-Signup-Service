# Spring Bootiful Microservices (Signup-Service)

#### Navigation Guide: [`Previous Repo: OAuth2-Service`](https://github.com/Prempeh-Gyan/1.3-OAuth2-Service)   |   [`Next Repo: Coming-Soon`](https://github.com/Prempeh-Gyan/Coming-Soon)

### Travis
[![Build Status](https://travis-ci.org/Prempeh-Gyan/2.0-Signup-Service.svg?branch=master)](https://travis-ci.org/Prempeh-Gyan/2.0-Signup-Service)

### Heroku
To deploy this project to Heroku, update the [`configuration file`](https://github.com/Prempeh-Gyan/1.1-Config-Repo/blob/master/services/Signup-Service/signup-service.yml) to point to the Heroku locations of the dependent services before deploying this to Heroku.

[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy?template=https://github.com/Prempeh-Gyan/2.0-Signup-Service)

### Getting Started
Required
* [`Maven`](https://maven.apache.org/) 3.3+
* [`JDK`](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 8+
Get the project from the source repository
>`git clone https://github.com/Prempeh-Gyan/2.0-Signup-Service.git`

### About This Service
The Signup Service takes care of the registration of users and client applications that wish to use certain functionalities from the services we provide in the `Bootiful Microservices` series.

As was described in the OAuth2 Service, the `Authorization Server` manages the user and client accounts for authentication and authorization. 
Nevertheless the actuall process of registering a user or a client can be outsourced by the `Authorization Server` to another service(in this case the `Signup Service`).

The `Signup Service` then shares the data concerning the registered users and clients with the `Authorization Server` for authentication and authorization purposes.

When a user or a client goes through the  [`Gateway-Service`](https://github.com/Prempeh-Gyan/1.4-Gateway-Service) to be registered, a message is sent through [`kafka`](https://kafka.apache.org/) to this `Signup Service`, which then reads the data from the message and registers the user or client accordingly.

### Running the Project (and its Dependencies)
* Set up and run [`kafka`](https://kafka.apache.org/) then update the [`configuration file`](https://github.com/Prempeh-Gyan/1.1-Config-Repo/blob/master/services/Signup-Service/signup-service.yml ) to point to it
* Run the [`Config-Server`](https://github.com/Prempeh-Gyan/1.0-Config-Service) to serve the property file for this `Signup Service`
* Navigate into the source directory `cd 2.0-Signup-Service` and execute the following command: 
* `mvn spring-boot:run`
