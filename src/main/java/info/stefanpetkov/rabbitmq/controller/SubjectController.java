package info.stefanpetkov.rabbitmq.controller;

import info.stefanpetkov.rabbitmq.publisher.SubjectProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SubjectController {

    private SubjectProducer subjectProducer;

    public SubjectController(SubjectProducer subjectProducer) {
        this.subjectProducer = subjectProducer;
    }

    @GetMapping("sas")
    public ResponseEntity<String> sendMessage(@RequestParam("subject") String subject){
        subjectProducer.sendMessage(subject);
        return ResponseEntity.ok("The message was sent to Message broker!!!");
    }
}
