package rabbitmq.topic;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Autor zhouNan
 * @Date 2020/1/7 13:27
 * @Description TopicConsumer
 **/
public class TopicConsumer1 {

    public static  void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory connectionFactory  = new ConnectionFactory();

        connectionFactory.setHost("106.13.125.253");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(TopicProducer.EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        //声明一个随机队列
        String queueName = channel.queueDeclare().getQueue();

        //绑定
        String routekey = "#.order.#";
        channel.queueBind(queueName, TopicProducer.EXCHANGE_NAME, routekey);
        System.out.println("waiting for message..........");

        //声明一个消费者
        final Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message =  new String(body,"Utf-8");
                System.out.println("Received[" + envelope.getRoutingKey()+
                        "]"+ message);
            }
        };
        //正式消费消息
        channel.basicConsume(queueName, true, consumer);


    }
}
