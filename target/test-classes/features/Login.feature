Feature: Application login

@ThisisfirstTest

Scenario: Home page default login
Given User is on Snapfish landing page
When User login into application with "jin" and password "143"
Then Home page is displayed
And Photos are displayed "true"

@SecoundTest

Scenario: Home page default login
Given User is on Snapfish landing page
When User login into application with "jan" and password "163"
Then Home page is displayed
And Photos are displayed "false"
