package com.bugpet.project.service.producers;

import com.bugpet.project.config.RabbitMQConfig;
import com.bugpet.project.dto.DiedPetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Generally the producer is only one file
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PetProducerImpl implements PetProducer {
  private final RabbitTemplate rabbitTemplate;

  // this functions use the jsonMessageConverter from RabbitMQConfig
  public void publishDiedPet(DiedPetDto diedPetDto) {
    rabbitTemplate.convertAndSend(RabbitMQConfig.DIED_PET_QUEUE, diedPetDto);
  }
}
