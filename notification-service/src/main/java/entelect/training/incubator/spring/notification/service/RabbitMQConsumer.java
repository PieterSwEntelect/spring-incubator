package entelect.training.incubator.spring.notification.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {


    @RabbitListener(queues = {"${rabbitmq.queue.name}"})//Change Quee name
    public void consume(String message){

        System.out.println("Message arrived! Message: " + message);
    }
}
