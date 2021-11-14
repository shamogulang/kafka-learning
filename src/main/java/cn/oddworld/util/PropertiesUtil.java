package cn.oddworld.util;

import java.util.Properties;

/**
 * @description: TODO 类描述
 * @author: jeffchan
 * @date: 2021/11/14
 **/
public class PropertiesUtil {

    public static Properties getPros(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("acks", "all");
        properties.put("retries", 3);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return properties;
    }
}
