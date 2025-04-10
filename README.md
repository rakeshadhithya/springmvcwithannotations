# springmvcwithannotations

- Spring MVC & Hibernate Web Application (with Annotations): A similar application to the previous one but built using annotations instead of XML files, removing dependency on XML.

# Features

- front end is built completely using HTML (goal is to understand spring mvc)
- Takes inputs from front-end and performs CRUD with a table in the database server
- Used HikariDataSource for connection pooling
- Used embedded tomcat plugin, so no need for external tomcat
- Used two contexts, one is root context and othe is dispatcher servlet specific context

# Skills

- HTML
- Spring Core
- Spring Dao
- Spring Mvc (with annotations)
- Hibernate with connection pooling
- Hikari DataSource

# Installation Guide

- make sure you have jdk installed, my version is 17
- make sure you have mysql installed, and create a database
- download the project, open in vscode(preferred)
- open command line and run 'mvn clean install', this will build project from scratch

# Usage

- in src/main/java/util/HikariDataSource.java, change database details as per your database
- run 'mvn tomcat7:run' , this will start the web application on port 8080. (since we used embedded tomcat plugin)
- open the browser and use the url http://localhost:8080/springmvcwithannotations/home. this is the home page where you can access to all features of the application
- try all the operations listed on home page
