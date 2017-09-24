Employee Management
===================

<dl>
  <dt>Description</dt>
  <dd>A single page application that can manage Employees.<em>tags</em>.</dd>
  <dt>Technology</dt>
  <dd>The web application has been built using Angular 4 and Java Spring Boot Web Services.</dd>
</dl>

---

##  Features Covered
- Read employees
- Create employee
- Update employee
- Delete employee
- Search employees in Material Card or List
- Upload excel of new or update employees
- Download excel of exisitng employees
- View employees in Material Card
- View employees in Material List
- Leveraged Angular Material Design
- Fully reponsive web application
- Loading mask with Material Progress Bar
- 

##  Know Issues


- Functionality - Show status of whats happeing - snack bar

- Functionality - Fix card and list - click on full button
- Look and Feel - Layout of all pages



- merge card and list some how
- Look and Feel - List view when not employee data, remove place holder
- Functionality - Clear option in search bar
- Functionality - Search add/ edit/ delete clear search value
- Functionality - While searching, change from card to list view the searched items should remain and not clear

#### Completed
- Functionality - Loading mask
- Functionality - Default Sort the data on first name
- Functionality - Directly accessing http://localhost:8080/card not working

##  Good To Have Features
- Test Cases
- Pagination in Material Card and List
- Filtering in Material Card and List
- Sorting in Material Card and List

> Note: 
> + All commands are in par with Windows Operating System
> + Run commands from root folder D:\Workspace\..\employee-management
> + For Upload kindly use the excel template shared under D:\Workspace\..\employee-management\data

---

##  Running the Web Application
####  Software Stack To Run the Executable
| No | Software                 | Tested on Version |
| -- |:------------------------:| -----------------:|
| 01 | *Java*                   | v1.8.0_121        |
| 02 | *MongoDB shell*          | v3.0.6            |

####  Start Up Mongodb
- Create folder under
```
d:\data\employees
```
- Open command prompt, and execute
```
C:\Program Files\MongoDB\Server\3.0\bin>mongod.exe --dbpath "c:\data\employees" --port 27017
```
> **MongoDB should have startup**

####  Start Up Web Application
- Go to  folder
```
D:\Workspace\..\employee-management\executables
```
```
Rename **services-0.0.1.jar.rename** to **services-0.0.1.jar**
```
- Open command prompt, and execute
```
D:\Workspace\..\employee-management\executables>java -jar services/target/services-0.0.1.jar
```

> **Web Application should have startup**, go to local running [Web Application](http://localhost:8080) on port 8080

---

##  Development
####  Software Stack Used
| No | Software                 | Version          |
| -- |:------------------------:| ----------------:|
| 01 | *NPM*                    | v4.6.1           |
| 02 | *Node*                   | v6.10.3          |
| 03 | *Maven*                  | v3.3.9           |
| 04 | *Java*                   | v1.8.0_121       |
| 05 | *MongoDB shell*          | v3.0.6           |
| 06 | *Visual Studio Code*     | v1.15.0          |
| 07 | *Eclipse oxygen*         | R-win32-x86_64   |

####  Start Up Mongodb
- Create folder under
```
d:\data\employees
```
- Open command prompt, and execute
```
C:\Program Files\MongoDB\Server\3.0\bin>mongod.exe --dbpath "c:\data\employees" --port 27017
```
> **MongoDB should have startup**

####  Build Angular 4 - WebApp
- Open command prompt, and execute
```
D:\Workspace\..\employee-management\webapp>ng build --env=prod
```
> **Angular WebApp built to production grade, files available under ..\webapp\dist**
  
####  Build Spring Boot - Services
- Open command prompt, and execute
```
D:\Workspace\..\employee-management\services>mvn package spring-boot:repackage
```
> **Spring Boot Services built, files available under ..\services\target**

####  Start Up Web Application
- Open command prompt, and execute
```
D:\Workspace\..\employee-management\services\target>java -jar services/target/services-0.0.1.jar
```
> **Web Application should have startup**, go to local running [Web Application](http://localhost:8080) on port 8080

---