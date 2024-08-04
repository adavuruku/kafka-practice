package com.example.kafka_learn.config;

import com.example.kafka_learn.Deserializers.MultiTypeJsonDeserialiser;
import com.example.kafka_learn.Serializers.MultiTypeJsonSerializer;
import com.example.kafka_learn.event.EventHandler;
import com.example.kafka_learn.event.KafkaConsumer;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sherif.Abdulraheem 8/3/2024 - 5:30 PM
 **/
@Configuration
@EnableKafka
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

//    @Value("${spring.kafka.bootstrap.servers-referral}")
//    private String bootstrapServersReferral;

    @Value("${spring.kafka.test.group-id}")
    private String groupId;

//    @Value("${spring.kafka.security.protocol}")
//    private String securityProtocol;
//
//    @Value("${spring.kafka.sasl.mechanism}")
//    private String saslMechanism;
//
//    @Value("${spring.kafka.sasl.jaas.config}")
//    private String saslJaasConfig;

//    @Value("${io.confluent.developer.config.topic.name}")
//    private String topicName;
//    @Value("${io.confluent.developer.config.topic.replicas}")
//    private int replicas;
//    @Value("${io.confluent.developer.config.topic.partitions}")
//    private int partitions;

    @Bean("customKafkaAdmin")
    public KafkaAdmin kafkaAdmin(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        configs.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, securityProtocol);
//        configs.put(SaslConfigs.SASL_MECHANISM, saslMechanism);
//        configs.put(SaslConfigs.SASL_JAAS_CONFIG, saslJaasConfig);
        return new KafkaAdmin(configs);
    }
    @Bean
    public Map<String, Object> stringProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        return props;
    }

    @Bean
    public KafkaTemplate<String, String> stringKafkaTemplate() {
        return new KafkaTemplate<>( new DefaultKafkaProducerFactory<>(stringProducerConfigs()));
    }


    @Bean
    public Map<String, Object> jsonProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MultiTypeJsonSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        return props;
    }

    @Bean
    public KafkaTemplate<String, Object> jsonKafkaTemplate() {
        return new KafkaTemplate<>( new DefaultKafkaProducerFactory<>(jsonProducerConfigs()));
    }
//
//    @Bean
//    public Map<String, Object> avroProducerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
//        props.put(ProducerConfig.ACKS_CONFIG, "all");
//        props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
//        return props;
//    }
//
//    @Bean
//    public KafkaTemplate<String, Object> avroTemplate() {
//        return new KafkaTemplate<>( new DefaultKafkaProducerFactory<>(avroProducerConfigs()));
//    }
//
//    @Bean
//    public Map<String, Object> protoProducerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class);
//        props.put(ProducerConfig.ACKS_CONFIG, "all");
//        props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
//        return props;
//    }
//
//    @Bean
//    public KafkaTemplate<String, Object> protoTemplate() {
//        return new KafkaTemplate<>( new DefaultKafkaProducerFactory<>(protoProducerConfigs()));
//    }

    //CONSUMER CONFIG

    @Bean
    public Map<String, Object> stringConsumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

//    @Bean
//    public DefaultKafkaConsumerFactory<String, String> stringConsumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(stringConsumerConfigs());
//    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaStringListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory( new DefaultKafkaConsumerFactory<>(stringConsumerConfigs()));
        return factory;
    }

    @Bean
    public Map<String, Object> jsonConsumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MultiTypeJsonDeserialiser.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return props;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaJsonListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory( new DefaultKafkaConsumerFactory<>(jsonConsumerConfigs(), new StringDeserializer(), new MultiTypeJsonDeserialiser()));
        factory.setConsumerFactory( new DefaultKafkaConsumerFactory<>(jsonConsumerConfigs()));
        return factory;
    }


//
//    @Bean
//    public Map<String, Object> avroConsumerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
//        return props;
//    }
//
//    @Bean
//    public Map<String, Object> protoConsumerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaProtobufDeserializer.class);
//        return props;
//    }

    @Bean
    public KafkaConsumer eventConsumer(EventHandler eventHandler) {
        return new KafkaConsumer(eventHandler);
    }

    @Bean
    public EventHandler createKafkaEventHandler(){
        return new EventHandler();
    }
}
