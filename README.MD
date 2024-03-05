# Parking Lot Service

## Endpoints

### POST /api/park-verhicle

Endpoint for parking a vehicle.

curl --location --request POST 'http://localhost:8080/api/park-vehicle' \
--header 'Content-Type: application/json' \
--data-raw '{
    "plateNumber": "AAA000",
    "type": "Car"
}'

curl --location --request POST 'http://localhost:8080/api/park-vehicle' \
--header 'Content-Type: application/json' \
--data-raw '{
    "plateNumber": "AAA111",
    "type": "Van"
}'

curl --location --request POST 'http://localhost:8080/api/park-vehicle' \
--header 'Content-Type: application/json' \
--data-raw '{
    "plateNumber": "AAA222",
    "type": "Motorcycle"
}'

### POST /api/vehicle-left-parking

Endpoint for a vehicle left its parking spot.

curl --location --request POST 'http://localhost:8080/api/vehicle-left-parking' \
--header 'Content-Type: application/json' \
--data-raw '{
    "plateNumber": "AAA000",
    "type": "Car"
}'

curl --location --request POST 'http://localhost:8080/api/vehicle-left-parking' \
--header 'Content-Type: application/json' \
--data-raw '{
    "plateNumber": "AAA111",
    "type": "Van"
}'

curl --location --request POST 'http://localhost:8080/api/vehicle-left-parking' \
--header 'Content-Type: application/json' \
--data-raw '{
    "plateNumber": "AAA222",
    "type": "Motorcycle"
}'

### GET /api/spots-available

Endpoint to get how many spots are available

curl --location --request GET 'http://localhost:8080/api/spots-available'

### GET /api/all-spaces-taken?type=

Endpoint to get if all spaces for specific vehicle are taken

curl --location --request GET 'http://localhost:8080/api/all-spaces-taken?type=van'

curl --location --request GET 'http://localhost:8080/api/all-spaces-taken?type=car'

curl --location --request GET 'http://localhost:8080/api/all-spaces-taken?type=motorcycle'