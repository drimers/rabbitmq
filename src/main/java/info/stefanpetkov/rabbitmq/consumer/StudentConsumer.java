package info.stefanpetkov.rabbitmq.consumer;

import info.stefanpetkov.rabbitmq.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeStudentJsonMessage(Student student){
        log.info("Received Student message -> [ {} ]", student.toString());
    }
}
