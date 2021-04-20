# Chess Royale Project
this is the project for the CI course 

### Launch the postgres locally :
- cd dev-station
- docker-compose up

### Launch spring locally :
- mvn spring-boot:run

### Restart the postgres locally :
- cd dev-station
- docker-compose down
- (optional) check it's down with docker ps
- docker-compose up

### Sonar cloud
master branch is analysed on https://sonarcloud.io/dashboard?id=univ-smb-m1-isc-2020_chess-royale

### Actuator
 - actuator endpoints available on http://localhost:8080/actuator/health


