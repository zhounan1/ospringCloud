/*
package rabbitmq.topic;*/
/*
 * Copyright © 2016 睿泰集团 版权所有
 *//*


import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

*/
/**
 * @Autor zhouNan
 * @Date 2020/1/7 10:35
 * @Description TopicProducer
 **//*

public class TopicProducer {

    public  final static String EXCHANGE_NAME = "topic_logs";


    public  static  void  main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory  = new ConnectionFactory();
        connectionFactory.setHost("106.13.125.253");
        //创建一个连接
        Connection connection = connectionFactory.newConnection();
        //创建一个信道
        Channel channel = connection.createChannel();
        //定义交换器
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        //发送确认者模式 回调
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                System.out.println("l : " + l + " b ：" + b);
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                System.out.println("l : " + l + " b ：" + b);
            }
        });
        //开启 发送确认者  模式
        channel.confirmSelect();
        String[] strings = {"error", "info", "warning"};
        for (int i =0; i< 3; i++){
            String[] strings1 = {"order","emlia","user"};
            for(int j = 0; j < 3; j++){
            String[]  strings2 = {"A", "B", "C"};
            for (int  k = 0; k < 3; k++){
                String msg = "Hello  Rabbitmq topic" + (i+j+k);
                String routeKey = strings[i%3] + "."+ strings1[j%3] + "." + strings2[k%3];
                channel.basicPublish(EXCHANGE_NAME,routeKey, null, msg.getBytes());
            }
            }
        }
        //channel.waitForConfirms();
        channel.waitForConfirmsOrDie();
        channel.close();
        connection.close();

    }
}
*/
