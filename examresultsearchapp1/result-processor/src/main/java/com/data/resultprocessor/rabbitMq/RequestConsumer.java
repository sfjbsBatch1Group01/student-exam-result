package com.data.resultprocessor.rabbitMq;

import com.data.resultprocessor.repository.ResultsRepository;
import com.data.resultprocessor.rabbitMq.ResponseSender;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RequestConsumer {

  @Bean
  public Jackson2JsonMessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

  @Autowired
  ResponseSender responseSender;

  @Autowired
  ResultsRepository repository;

  @RabbitListener(queues = "request.queue")
  public void recievedMessage(String name) {
    responseSender.send(repository.findById(name).toString());
  }
}
