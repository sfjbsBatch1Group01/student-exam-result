# Run the docker-compose.yml file from result-processor
docker-compose -f docker-compose.yml up
#Run student-result
mvn clean install
mvn spring-boot:run
     Commend:run in postman
        get:localhost:8081/getresult?name={student name} secquerity=basic auth(username=student1,password=password123)
             Request param name example:'Rajiv' 
      run in curl=curl -X GET http://localhost:8081/getresult?name={student name} --user "student1:password123"
#Run result-processor
mvn clean install
mvn spring-boot:run
    Commend:run in postman 
Use basic auth in secquerity for all(username=schooladmin1,password=password124)
    Post:localhost:8082/storeresult 
             Request body example:'{"name": "Rajiv","role": "a12","schoolName": "efg","scienceMarks":"92","mathMarks":"82","socialScienceMarks":"82","artMarks":"42","sportMarks":"90"}'
in curl= curl -X POST http://localhost:8082/storeresult -H 'Content-type:application/json' --user "schooladmin1:password124" -d '{"name": "Rajiv","role": "a12","schoolName": "efg","scienceMarks":"92","mathMarks":"82","socialScienceMarks":"82","artMarks":"54","sportMarks":"90"}'
    Put:localhost:8082/updateresult?name={student name}
             Request param name example:'Rajiv'
in curl=curl -X PUT http://localhost:8082/updateresult?name={student name} --user "schooladmin1:password124" -H 'Content-type:application/json' -d '{"name": "Rajiv","role": "a12","schoolName": "efg","scienceMarks":"92","mathMarks":"82","socialScienceMarks":"82","artMarks":"93","sportMarks":"90"}'
    Delete:localhost:8082/deleteresult?name={student name}
              Request param name example:'Rajiv'
in curl= curl -X DELETE http://localhost:8082/deleteresult?name={student name} --user "schooladmin1:password124"
