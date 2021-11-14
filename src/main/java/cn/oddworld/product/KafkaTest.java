package cn.oddworld.product;

import cn.oddworld.util.PropertiesUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @description: 普通单纯发送的代码
 * @author: jeffchan
 * @date: 2021/11/14
 **/
public class KafkaTest {

    public static void main(String[] args) {
        // key可以用ProducerConfig、CommonClientConfigs
        Properties properties = PropertiesUtil.getPros();
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        // 可以指定分区和key,也可以不指定
        // 指定分区
        producer.send(new ProducerRecord<String, String>("jeffchan",1,"jeffchan","test..."));
        // 不关闭的话，数据会丢失
        producer.close();
    }
}
