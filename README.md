Description
Project is an implementation of car rental backend layer. It based on REST architecture.

Demo
Project is not uploaded to remote server yet.

Requirements
Java Virtual Machine
MySQL
Gradle 
Spring Boot 2.7.4
Lombok 1.18.24
Running the project
In order to launch project, you need create databes locally and run ArticleRestApplication class. Endpoints operation can be checked on http://localhost:3306 address.

Endpoints description

CarController
/v1/car - POST method, @RequestBody carDto. Endpoint will create new car.

/v1/car/status/{carId} - PUT method, @PathVariable carId, @RequestParam rentStatus. Updates the rent status of a car.

/v1/car/price/{carId} - PUT method, @PathVariable carId, @RequestParam price. Updates the price of a car.

/v1/car - DELETE method, @RequestParam carId. Deletes car using it's ID.

UserController
/v1/user - POST method, @RequestBody userDto. Creates new user.

/v1/user/{userId) - DELETE method, @PathVariable userId. Deletes user by Id.

RentController
/v1/rent - POST method, @RequestBody rentDto. Creates new rent in the system.

/v1/rent/{rentId} - PUT method, @PathVariable rentID, @RequestParam endDate. Finishes the rent and add the endDate.
