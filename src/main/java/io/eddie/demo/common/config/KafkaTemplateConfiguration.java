package io.eddie.demo.common.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaTemplateConfiguration {

    @Value("${custom.kafka.config.topic-partitions}")
    private int topic_partitions;

    @Value("${custom.kafka.config.topic-replications}")
    private int topic_replications;

    @Value("${carts.event.topic.name}")
    private String cartsEventsTopicName;

    @Value("${deposits.event.topic.name}")
    private String depositsEventsTopicName;


    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(
            ProducerFactory<String, Object> producerFactory
    ) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public NewTopic createAccountsEventTopic() {
        return TopicBuilder.name(cartsEventsTopicName)
                .partitions(topic_partitions)
                .replicas(topic_replications)
                .build();
    }

    @Bean
    public NewTopic createDepositsEventsTopic() {
        return TopicBuilder
                .name(depositsEventsTopicName)
                .partitions(topic_partitions)
                .replicas(topic_replications)
                .build();
    }

}
