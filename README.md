[![Build Status](https://travis-ci.org/medJarray/Spring-Boot-Web-App.svg?branch=master)](https://travis-ci.org/medJarray/Spring-Boot-Web-App)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.springApp%3Aspring5webapp&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.springApp%3Aspring5webapp)

"# Spring-Boot-Web-App" 


## Spring Boot REST Internationalization

Let's make simple requests using CURL:
```console
$ curl -X GET "http://localhost:8090/api/employers/search?name=toto" -H "accept: application/json" -H  "Accept-Language: fr"
On peut pas trouver l emplyeur toto
```
```console
$ curl -X GET "http://localhost:8090/api/employers/search?name=toto" -H "accept: application/json" -H  "Accept-Language: en"
Could not find employee toto
```
```console
$ curl -X GET "http://localhost:8090/api/employers/search?name=toto" -H "accept: application/json"
On peut pas trouver l emplyeur toto
```
So as you see, responses are different based on value of “Accept-Language” header passed in the request. This way, we don’t need to check what was passed in the request in each controller method, and then pass it further to service layers. We now can do this in one single place, which is CustomLocaleResolver class.