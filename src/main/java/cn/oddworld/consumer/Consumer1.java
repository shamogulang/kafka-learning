package cn.oddworld.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

/**
 * @description: 消费者代码
 * @author: jeffchan
 * @date: 2021/11/14
 **/
public class Consumer1 {

    public static void main(String[] args) {
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        p.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        p.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        p.put(ConsumerConfig.GROUP_ID_CONFIG,"jeffchan11");
        // 重新消费需要设置这个参数，还需要改变消费组
        p.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(p);
        while (true){
            consumer.subscribe(Collections.singletonList("jeffchan"));
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ofMillis(1000));
            poll.forEach(x -> {
                System.out.println(x.key());
                System.out.println(x.value());
            });
        }
    }
}
