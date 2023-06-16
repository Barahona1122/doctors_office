Run project
mvn org.springframework.boot:spring-boot-maven-plugin:run

Consultar todas las citas de un doctor por dia y consultorio
http://localhost:8080/appointments-find-by-parms?consultation_date=2023-06-16&user_id=1&office_id=1

CREAR UNA CITA POST
http://localhost:8080/appointments-store?name=Cesar&last_name=Hernandez&first_name=Barahona&specialty=1&type=1

{
"date":"2023-06-18",
"time":"17:00",
"officeId":2,
"status":1,
"userId":1

}

<!-- COMO HACER PRUEBAS -->

https://www.loom.com/share/2ebd09e29e794694a41cc79a10859876
