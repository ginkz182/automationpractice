# Assessment

## 1. Test Coverage Matrix
Excel sheet is attached with the email and can also be found in Google Drive here
[Question 1: Test Coverage Matrix](https://docs.google.com/spreadsheets/d/1FdgK5sHOMM8FyQd8Haif8bSClS8BRstG/edit?usp=sharing&ouid=106778797930776263912&rtpof=true&sd=true)

## 2. Test Automation Frontend

The test is written by using Gauge framework (https://gauge.org/), Java and Maven

Test specification can be found in [/specs/Frontend](https://github.com/ginkz182/automationpractice/tree/master/specs/Frontend) folder

### Test Structure
1. Test Spec
[/specs](https://github.com/ginkz182/automationpractice/tree/master/specs)

The spec file will be written in plain english in a BDD format to follow business requirements

2. Test Steps
[/src/test/java/steps](https://github.com/ginkz182/automationpractice/tree/master/src/test/java/steps)

These are steps implementation that map with each step in spec file.
This will give more details about what is the action for each test step

3. Page Object
[/src/test/java/pages](https://github.com/ginkz182/automationpractice/tree/master/src/test/java/pages)

These are page object model classes that store the elements and actions in each page
This will be called from the steps files to interact with each page


### Steps to Run the test

Required Java11 or above

1. Install Maven and Gauge
```
brew install maven
brew install gauge
```

2. Install Gauge plugin
```
gauge install java -v 0.7.13
gauge install html-report
```

3. Run execute command
```
mvn gauge:execute -DspecsDir="specs/Frontend"
```


## 3. API Testing

This test is using the same framework as task #2 with [rest-assured](https://rest-assured.io/) library to test the rest API.
The API under test is from https://reqres.in/ which provide the mock API service for testing

The implementation of the API test layer is in [/src/test/java/api](https://github.com/ginkz182/automationpractice/tree/master/src/test/java/api)

Steps to setup the test will be same as task #2 but with following command to execute
```
mvn gauge:execute -DspecsDir="specs/API"
```

This test spec consists of 4 test cases
1. GET request
2. POST request
3. POST request and check response time
(This one is setup with 3 seconds delay to simulate the fail case for response time)
4. POST request and check cookie 
(This is expected to fail because I can't find any mock endpoint to test cookies so I just made a dummy test case for this one)

