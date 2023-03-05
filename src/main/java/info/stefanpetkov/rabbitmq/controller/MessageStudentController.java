package info.stefanpetkov.rabbitmq.controller;

import info.stefanpetkov.rabbitmq.dto.Student;
import info.stefanpetkov.rabbitmq.publisher.StudentsProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageStudentController {

    private StudentsProducer studentsProducer;

    public MessageStudentController(StudentsProducer studentsProducer) {
        this.studentsProducer = studentsProducer;
    }

    @PostMapping("/student")
    public ResponseEntity<String> sendStudentMessage(@RequestBody Student student){
        studentsProducer.sendStudentJsonMassage(student);
        return ResponseEntity.ok("The student's message was sent to the Message broker as json!!! ");
    }
}
