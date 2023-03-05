package info.stefanpetkov.rabbitmq.controller;

import info.stefanpetkov.rabbitmq.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer rabbitMQProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    //  http://localhost:8080/api/v1/sas?student=Software%20architectures%20and%20tools
    @GetMapping("sas")
    public ResponseEntity<String> sendMessage(@RequestParam("subject") String subject){
        rabbitMQProducer.sendMessage(subject);
        return ResponseEntity.ok("The message was sent to Message broker!!!");
    }
}
