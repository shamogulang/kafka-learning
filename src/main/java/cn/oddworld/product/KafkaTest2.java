package cn.oddworld.product;

import cn.oddworld.util.PropertiesUtil;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;



/**
 * @description: 自定义分区器
 * @author: jeffchan
 * @date: 2021/11/14
 **/
public class KafkaTest2 {

    public static void main(String[] args) {
        // key可以用ProducerConfig、CommonClientConfigs
        Properties properties = PropertiesUtil.getPros();
        // 设定partition > 自定义分区器 > 指定key
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"cn.oddworld.partition.JeffPartition");
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        producer.send(new ProducerRecord<String, String>("jeffchan", "jex","test...callback"), new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(e == null){
                    System.out.println("offset ==> " + recordMetadata.offset());
                    System.out.println("partition ==> " + recordMetadata.partition());
                }
            }
        });
        // 同步的代码，可以直接加个.get()即可。
        producer.close();
    }
}
