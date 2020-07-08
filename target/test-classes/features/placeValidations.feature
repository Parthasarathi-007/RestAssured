Feature: Validating PlaceAPI

Scenario Outline: Validate that user is able to add place using AddPlace API



Given the AddPlace Payload with "<name>","<language>","<address>"
When user calls "AddPlaceAPI" with "POST" http request
Then API call is success with status code 200
#And validate that "status" is "OK"
#And validate that  place _id  matches with "<name>" in response from "<GetPlaceAPI>"
Examples:

|name|language|address|
|Raja House|Tamil|123 Main Street|
|MSV House|Tamil|123 Main Street|
|Rahman House|Tamil|123 Main Street|