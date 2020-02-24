package rabbitmq.config;/*
 * Copyright © 2016 睿泰集团 版权所有
 */


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.service.ProcessDepot;

/**
 * @Autor zhouNan
 * @Date 2020/1/9 16:22
 * @Description RabbitConfig
 **/
@Configuration
public class RabbitConfig {


    @Value("106.13.125.253")
    private String addresses;

    @Value("5672")
    private String port;

    @Value("guest")
    private String username;

    @Value("guest")
    private String password;

    @Value("/")
    private String  virtualHost;

    @Value("true")
    private boolean publicsherConfirms;
    @Autowired
    public  ProcessDepot processDepot;


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setAddresses(addresses+":"+port);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setVirtualHost(virtualHost);
        // 如果消息回调  设置为true
        cachingConnectionFactory.setPublisherConfirms(publicsherConfirms);
        return cachingConnectionFactory ;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return  new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate newRabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMandatory(true);
        template.setReturnCallback(returnCallback());
        template.setConfirmCallback(confirmCallback());
        return  template;
    }

     @Bean
     public Queue  queue() {
        return new Queue("hell");
     }

     @Bean
     public TopicExchange topicExchange(){
        return  new TopicExchange("topic");

     }
     @Bean
     public Binding binding (){
        return BindingBuilder.bind(queue()).to(topicExchange()).with("hello");
     }

     @Bean
     public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new
                SimpleMessageListenerContainer();
                simpleMessageListenerContainer.setQueues(queue());
                simpleMessageListenerContainer.setMessageListener(simpleMessageListenerContainer);

                return  simpleMessageListenerContainer;
     }

    @Bean
    public RabbitTemplate.ConfirmCallback confirmCallback () {
        return (correlationData, b, s) -> {
             if (b) {
                 System.out.println("消息发送给MQ成功");
             } else {
                 System.out.println("消息发送给MQ失败.原因 ：" + s);
             }
        };
    }



    @Bean
    public  RabbitTemplate.ReturnCallback returnCallback() {
        return  new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {

                String msg = new String(message.getBody());
                System.out.println("返回的message : " + msg);
                System.out.println("返回的routingKey: "+ s2);
                System.out.println("返回的exchange: "+ s1);
                System.out.println("返回的replyText: "+ s);
            }
        };



    }
}
