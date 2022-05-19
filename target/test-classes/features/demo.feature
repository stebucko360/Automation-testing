Feature: Feature to text login functionality
@logintest
Scenario: Check login is successful with valid credentials
Given browser is open
When user is on the main page
And  user enters the username
And  user enters the password
And  user clicks the login button
Then user is on the secure area