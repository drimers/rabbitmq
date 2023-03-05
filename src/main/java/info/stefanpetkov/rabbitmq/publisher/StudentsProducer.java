package info.stefanpetkov.rabbitmq.publisher;

import info.stefanpetkov.rabbitmq.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentsProducer {


    @Value("${rabbitmq.routing.json.key}")
    private String json_routing_key;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private RabbitTemplate rabbitTemplate;

    public StudentsProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendStudentJsonMassage(Student student){
        log.info("Student info was sent -> [ {} ]", student.toString());
        rabbitTemplate.convertAndSend(exchange,json_routing_key,student);
    }
}
