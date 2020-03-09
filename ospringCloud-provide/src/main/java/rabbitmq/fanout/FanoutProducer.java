/*
package rabbitmq.fanout;*/
/*
 * Copyright © 2016 睿泰集团 版权所有
 *//*


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import rabbitmq.direct.DirectProducer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

*/
/**
 * @Autor zhouNan
 * @Date 2020/1/7 10:21
 * @Description FanoutProducer
 **//*

public class FanoutProducer {
    public  final static String EXCHANGE_NAME = "fanout_logs";


    public  static  void  main(String[] args)throws IOException, TimeoutException {
        ConnectionFactory connectionFactory  = new ConnectionFactory();
        connectionFactory.setHost("106.13.125.253");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        String[] strings = {"error", "info", "warning"};
        for (int i =0; i< 3; i++){
            String string = strings[i%3];
            String msg = "Hello  Rabbitmq" + (i+1);
            channel.basicPublish(EXCHANGE_NAME,string, null, msg.getBytes());
        }
        channel.close();
        connection.close();

    }
}
*/
