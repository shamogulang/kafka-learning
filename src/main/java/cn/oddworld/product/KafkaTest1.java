package cn.oddworld.product;

import cn.oddworld.util.PropertiesUtil;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * @description: 带回调的发送的代码
 * @author: jeffchan
 * @date: 2021/11/14
 **/
public class KafkaTest1 {

    public static void main(String[] args) {
        // key可以用ProducerConfig、CommonClientConfigs
        Properties properties = PropertiesUtil.getPros();
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        producer.send(new ProducerRecord<String, String>("jeffchan", "test...callback"), new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(e == null){
                    System.out.println("offset ==> " + recordMetadata.offset());
                    System.out.println("partition ==> " + recordMetadata.partition());
                }
            }
        });
        //producer.close();
    }
}
