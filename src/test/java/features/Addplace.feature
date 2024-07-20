Feature: Validating Place API's

Scenario Outline: Verify if Place  is being Successfully added using AddPlaceAPI
Given Add place payload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with "POST" http request
Then the API call is success with status code 200
And status in response body is OK 
And verify place_Id created maps to "<name>" using "GetPlaceAPI"


Examples: 

|name     | language |address  |
|RamuTest | English  |Gudignta |
#|BhaviTest| Spanish  |Retur    |




Scenario: Verify if deleteplace api working
Given DeletePlace payload
When User calls "DeletePlaceAPI" with "POST" http request
Then the API call is success with status code 200
And status in response body is OK 
