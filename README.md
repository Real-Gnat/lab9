# lab-sport-buildings
Lab programming part 2(java): implementation of Sport Buildings

### How to work with maven-project?

To compile and package project:

<code>mvn package</code>

To run the project(main):

<code>java -cp target/lab-sport-buildings-1.0-SNAPSHOT.jar ua.lviv.iot.sportBuildings.Main</code>

To clean the target folder(otherwise, it's written in .gitignore):

<code>mvn clean</code>

To generate site:

<code>mvn site</code>

To run spring-boot project:

<code>mvn spring-boot:run</code>

### Test REST

##### GET

<code>curl -v localhost:8080/sportBuildings</code>

<code>curl -v localhost:8080/sportBuildings/1</code>

##### POST

<code>curl -X POST localhost:8080/sportBuildings -H 'Content-type:application/json' -d '{"name":"Large Pool","location":"Central st 83","constructionYear":2002,"viewersNumber":800,"sportSeason":"ALL_SEASONS","sportKind":"AQUATICS","poolsNumber":10,"averagePoolVolume":30.0,"headers":"name,location,constructionYear,sportSeason,viewersNumber,sportKind,poolsNumber,averagePoolVolume"}'</code>

##### PUT

<code>curl -X PUT localhost:8080/sportBuildings/1 -H 'Content-type:application/json' -d '{"name":"Another Pool","location":"Silent st 83","constructionYear":2000,"viewersNumber":700,"sportSeason":"ALL_SEASONS","sportKind":"AQUATICS","poolsNumber":6,"averagePoolVolume":25.0,"headers":"name,location,constructionYear,sportSeason,viewersNumber,sportKind,poolsNumber,averagePoolVolume"}'</code>

##### DELETE

<code>curl -X DELETE localhost:8080/sportBuildings/1</code>
