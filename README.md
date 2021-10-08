# Assessment

## 1. TCM
Excel sheet is attached with the email and can also be found here
https://docs.google.com/spreadsheets/d/1FdgK5sHOMM8FyQd8Haif8bSClS8BRstG/edit?usp=sharing&ouid=106778797930776263912&rtpof=true&sd=true

## 2. Test Automation Frontend

The test is written by using Gauge framework (https://gauge.org/), Java and Maven
Test specification can be found in /specs/frontend folder


### Steps to Run the test

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

4. Run execute command
```
mvn gauge:execute -DspecsDir="specs/Frontend"
```


## 3. API Testing

This test is using the same framework as task #2 with rest-assured library to test the rest API.
The API under test is from https://reqres.in/ which provide the mock API service for testing

Steps to setup the test will be same as task #3 but with following command to execute
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

