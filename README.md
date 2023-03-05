How to setup Message broker for example RabbitMQ

1. Install docker depending on your OS.
   https://www.docker.com/

2. Install RabbitMQ
You can choose the latest stable image.
   https://hub.docker.com/_/rabbitmq
#run the commands in the terminal:
docker pull rabbitmq:3.11.9-management 
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.11.9-management

3. To test, copy the link below into a browser and press enter:
   http://localhost:8080/api/v1/sas?subject=Software%20architectures%20and%20tools

  If everything works you will see the message in the browser:
  "The message was sent to Message broker!!!"
  
4. To test Json functionality create Post request as a body parameter with Postman. 
  Copy link below into Postman:
  http://localhost:8080/api/v1/student
  Provide json parameters into post request for example:
   {
   "facultyNumber":1,
   "firstName": "Stefan",
   "lastName": "Petkov",
   "speciality": "SAS",
   "course": "1"
   }

    In Postman you will see the following message:
    The student's message was sent to the Message broker as json!!!
   
   In IntelliJ Console you will see the following message:
   Student info was sent -> [ Student(facultyNumber=1, firstName=Stefan, lastName=Petkov, speciality=SAS, course=1) ]
   Received Student message -> [ Student(facultyNumber=1, firstName=Stefan, lastName=Petkov, speciality=SAS, course=1) ]