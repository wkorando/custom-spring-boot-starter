# Custom Spring Boot Starter

This project is an example of how to build a custom Spring Boot starter. This project uses the example of creating security library at an organization as a working scenario of using the various extension points the Spring Boot team has provided. 

## The Scenario

Frequently organizations have cross-cutting concerns; security, data access, logging, etc. For these concerns it makes sense to locate a lot of the logic and behavior for these needes in single shared library, this reduces boilerplate code developers must do when creating a new project and ensures consistency. 

## Basic Starter Structure

The Spring Boot team has developed an idiomatic structure for how starter libraries are to be designed, you can see them [here](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-starters). The structure looks like this:


