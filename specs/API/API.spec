API Test
=========

tags: api
Test with api tag won't start browser

Use mock API from https://reqres.in/

GET     /api/users/2
POST    /api/users


GET User Data
---------
* Call Get User by id "2" and verify response

POST Create User
---------
* Call Post Create User name "morpheus" job "leader" and verify response

Test Response Time don't exceed 2 seconds
---------
Note: This one expect to fail because the response is delayed by 3 seconds
* Call Get Users and assert response time not exceed "2000" ms

Test Cookies
----------
Note: This test will fail
because I can't find any mock endpoint to test cookies so I just made a dummy test case for this one
* Call Login with username "eve.holt@reqres.in" password "cityslicka" and verify cookies set correctly
