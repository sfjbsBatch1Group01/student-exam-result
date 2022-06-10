package com.data.resultprocessor.rabbitmq1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ResponseConsumer {

  @Bean
  public Jackson2JsonMessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

  @RabbitListener(queues = "response.queue")
  public void recievedMessage(String student) {
    System.out.println(student);
  }
}
