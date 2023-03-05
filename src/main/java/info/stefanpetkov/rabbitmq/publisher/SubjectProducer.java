package info.stefanpetkov.rabbitmq.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubjectProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routing_key;

    private RabbitTemplate rabbitTemplate;

    public SubjectProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        log.info("The message was sent -> [ {} ]", message);
        rabbitTemplate.convertAndSend(exchange,routing_key,message);
    }
}
