Feature: Application login

Scenario: Positive test validation login
Given Initialize the browser with firefox
And Navigate to "http://www.qaclickacademy.com" site
And click on login link on homepage to land on sign page
When User enters "raj267@live.com" and "Raj@1993" and logs in
Then verify that user is succesfully logged in