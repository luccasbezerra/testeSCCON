A rest api developed in SpringBoot.

For building and running the application you need:
- Java JDK 17
- Apache Maven 4.0.0
- Spring Boot 3.2.4

Tools used:
- Intellij IDEA;
- Postman Rest;

Running the application:
You can run the application directly from your preferred IDE by running main method in the com/br/teste/TesteApplication.java class

Endpoints:
1. GET: http://localhost:8080/person

[
    {
        "id": 5,
        "name": "Abraão Cole",
        "birthdayDate": "1990-10-05",
        "admissionDate": "2023-03-11"
    },
    {
        "id": 2,
        "name": "Ashley Young",
        "birthdayDate": "1987-01-22",
        "admissionDate": "2019-10-31"
    },
    {
        "id": 4,
        "name": "Átila Cole",
        "birthdayDate": "1990-10-05",
        "admissionDate": "2023-03-11"
    },
    {
        "id": 6,
        "name": "Bruno Henrique",
        "birthdayDate": "1990-10-05",
        "admissionDate": "2023-03-11"
    },
    {
        "id": 3,
        "name": "Henderson",
        "birthdayDate": "1995-05-31",
        "admissionDate": "2022-04-15"
    },
    {
        "id": 1,
        "name": "José da Silva",
        "birthdayDate": "2000-04-06",
        "admissionDate": "2020-05-10"
    }
]

2. POST: http://localhost:8080/person

   Body:
       {
        "name": "Giorgian De Arrascaeta",
        "birthdayDate": "1994-07-14",
        "admissionDate": "2024-03-27"
      }

   STATUS: 200 OK

   Body:
       {
        "id": 2,
        "name": "Giorgian De Arrascaeta",
        "birthdayDate": "1994-07-14",
        "admissionDate": "2024-03-27"
      }

   Este ID já esta em uso!

   STATUS: 400 BAD REQUEST
   

3. DELETE: http://localhost:8080/person/{id}

   http://localhost:8080/person/3

   STATUS: 200 OK

   http://localhost:8080/person/27

   Pessoa não encontrada

   STATUS: 404 NOT FOUND


4. PUT: http://localhost:8080/person/{id}

   http://localhost:8080/person/5

   Body:
        {
         "name": "Michael Owen",
         "birthdayDate": "1987-03-14",
         "admissionDate": "2024-03-27"
        }

   STATUS: 200 OK

   http://localhost:8080/person/22

   Body:
        {
         "name": "Michael Owen",
         "birthdayDate": "1987-03-14",
         "admissionDate": "2024-03-27"
        }

   Pessoa não encontrada

   STATUS: 404 NOT FOUND
   

5. PATCH: http://localhost:8080/person/{id}

   http://localhost:8080/person/5

   Body:
        {
         "fieldName": "FIELD_NAME",
         "fieldValue": "Falcão Garcia"
        }

   STATUS: 200 OK

   Body:
        {
         "fieldName": "FIELD_BIRTHDAY",
         "fieldValue": "1987-03-14"
        }

   STATUS: 200 OK

   Body:
        {
         "fieldName": "FIELD_ADMISSION_DATE",
         "fieldValue": "2023-03-14"
        }

   STATUS: 200 OK

   Body:
        {
         "fieldName": "FIELD_ADMISSION_DATE",
         "fieldValue": "2023-03-14"
        }

   STATUS: 200 OK


6. GET: http://localhost:8080/person/{id}

   http://localhost:8080/person/1

   Body:
       {
        "id": 1,
        "name": "José da Silva",
        "birthdayDate": "2000-04-06",
        "admissionDate": "2020-05-10"
       }

   STATUS: 200 OK

   http://localhost:8080/person/20

   Pessoa não encontrada

   STATUS: 404 NOT FOUND


7. GET: http://localhost:8080/person/{id}/age?

    http://localhost:8080/person/1/age?output=DAY

    8342

    STATUS: 200 OK

    http://localhost:8080/person/1/age?output=MONTH

    274

    STATUS: 200 OK

    http://localhost:8080/person/1/age?output=YEAR

    22

    STATUS: 200 OK

    http://localhost:8080/person/1/age?output=Otherwise

    Parâmetro informado não reconhecido

    STATUS: 400 BAD REQUEST

8. GET: http://localhost:8080/person/{id}/salary?

   http://localhost:8080/person/1/salary?output=MIN

    2.51

    STATUS: 200 OK

   http://localhost:8080/person/1/salary?output=FULL

    3259.36
    
    STATUS: 200 OK
    
   http://localhost:8080/person/1/salary?output=Otherwise
   
    Parâmetro informado não reconhecido
    
    STATUS: 400 BAD REQUEST

