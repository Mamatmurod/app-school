package ai.ecma.school.queue;

import ai.ecma.school.payload.thirdParty.ExceptionMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQSender {
    private final RabbitTemplate rabbitTemplate;


    @Value("${spring.rabbitmq.exception-handler.default-exchange}")
    private String exceptionHandlerDefaultDirectExchange;

    @Value("${spring.rabbitmq.exception-handler.queues.bot-queues.routing-key}")
    private String exceptionHandlerRoutingKey;

    public void sendExceptions(ExceptionMessageDTO exceptionMessageDTO) {
        this.send(exceptionHandlerDefaultDirectExchange, exceptionHandlerRoutingKey, exceptionMessageDTO);
    }

    private void send(String exchange, String routingKey, Object message) {
        log.info("Start queueing: Exchange = {}, RoutingKey = {}, Message = {}", exchange, routingKey, message.toString());

        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
