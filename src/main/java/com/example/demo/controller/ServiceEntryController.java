POST
/service-entries

Parameters
Cancel
Reset
No parameters

Request body

application/json
{
  "vehicle": {
    "id": 1
  },
  "garage": {
    "id": 1
  },
  "serviceType": "OIL CHANGE",
  "serviceDate": "2025-12-25",
  "odometerReading": 6000,
  "description": "SERVICE OIL"
}

Execute
Clear
Responses
Curl

curl -X 'POST' \
  'https://9157.32procr.amypo.ai/service-entries' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "vehicle": {
    "id": 1
  },
  "garage": {
    "id": 1
  },
  "serviceType": "OIL CHANGE",
  "serviceDate": "2025-12-25",
  "odometerReading": 6000,
  "description": "SERVICE OIL"
}
'
Request URL
https://9157.32procr.amypo.ai/service-entries
Server response
Code	Details
500
Undocumented
Error: response status is 500

Response body
Download
{
  "timestamp": "2025-12-25T12:28:08.476+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/service-entries"
}
Response headers
 access-control-allow-origin: * 
 cache-control: no-cache,no-store,max-age=0,must-revalidate 
 content-type: application/json 
 date: Thu,25 Dec 2025 12:28:08 GMT 
 expires: 0 
 pragma: no-cache 
 server: nginx/1.29.4 
 vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
 x-content-type-options: nosniff 
 x-frame-options: DENY 
 x-xss-protection: 0 
Responses
Code	Description	Links
200	
OK

Media type

*/*
Controls Accept header.
Example Value
Schema
{
  "id": 0,
  "vehicle": {
    "id": 0,
    "vin": "string",
    "make": "string",
    "model": "string",
    "year": 0,
    "ownerId": 0,
    "active": true,
    "createdAt": "2025-12-25T12:28:09.104Z"
  },
  "garage": {
    "id": 0,
    "garageName": "string",
    "address": "string",
    "contactNumber": "string",
    "active": true
  },
  "serviceType": "string",
  "serviceDate": "2025-12-25",
  "odometerReading": 0,
  "description": "string",
  "recordedAt": "2025-12-25T12:28:09.104Z"
}