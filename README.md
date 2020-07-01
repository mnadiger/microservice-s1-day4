# microservice-s1-day4
CLient Side Discovery, Registry-aware HTTP Client  (Load Balancer - Round Robin) - Eureka Registry, Netflix - Ribbon - Client Side Load Balancer, Spring Cloud Routing - Ribbon


Day-4 : 


CLient Side Discovery:

Registry-aware HTTP Client  (Load Balancer - Round Robin)
- Eureka Registry

Netflix - Ribbon
- Client Side Load Balancer

Spring Cloud Routing
- Ribbon

---------------------------------

****** CLient-Side Load Balancing with Ribbon: (cloudserver-eureka-ribbon)

1) Create a project with Starter - Eureka Discovery Client/Ribbon, Actuator, Web

<dependency>		<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

2) In application.properties:

server.port=9997
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
eureka.client.register-with-eureka=false

3) Without LoadBalancer

RestTemplate - HTTP Client - Request - Host(product-service)
- UnknownHostException

4) With LoadBalancer: (Registry Aware HTTP Client)

@LoadBalancer
- AOP

-------------------------------------------------------

***** Spring Cloud Routing - openfeign:

1) Create a new project: (cloudserver-eureka-feignclient) 
Starters - Web, Actuator, Eureka Discovery Client, OpenFeign

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

2) In application.properties:

server.port=9996
eureka.clientserviceUrl.defaultZone=http://localhost:8761/eureka
eurek.client.register-with-eureka=false

management.endpoints.web.exposure.include=*

3) Create the ProductServiceProxy Interface:

@FeignClient("product-service")

4) Use in Controller/Service:

@Autowired
private ProductServiceProxy productServiceProxy;

5) Add @EnableFeignClient

-----------------------------------------------------
