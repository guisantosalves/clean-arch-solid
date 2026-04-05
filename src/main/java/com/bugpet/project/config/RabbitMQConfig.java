package com.bugpet.project.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
  public static final String DIED_PET_QUEUE = "died-pet-queue";

  // usa para declarar a fila no rabbitMQ
  @Bean
  public Queue diedPetQueue() {
    // durable true -> survive the restart of the queue
    return new Queue(DIED_PET_QUEUE, true);
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new JacksonJsonMessageConverter();
  }
}
