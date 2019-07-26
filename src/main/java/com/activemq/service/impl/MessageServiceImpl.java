package com.activemq.service.impl;

import com.activemq.pojo.Mail;
import com.activemq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-07 12:22
 * @Version: 1.0
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private JmsTemplate template;

    /**
     * @description: 发送消息到ActiveMQ中，JmsTemplate是Spring封装的一个专门访问MOM容器
     *  的模板对象，通过该对象及XML配置定义Connection、Session、Producer对象
     * @param: to 收件人
     * @param: subject 主题
     * @param: content 内容
     * @Date: 2019-06-07 12:28
     * @return: void
     */
    @Override
    public void sendMessage(String to, String subject, String content) {
        try {
            Connection connection = template.getConnectionFactory().createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue destination = session.createQueue("test-pring-activemq");
            this.template.setDefaultDestination(destination);
            if(to.indexOf(";") != -1){
                String[] tos = to.split(";");
                for(String str : tos){
                    if(null != str && !"".equals(str)){
                        final Mail mail = this.string2Obj(to, subject, content);
                        this.sendMail(mail);
                    }
                }
            }else{
                final Mail mail = this.string2Obj(to, subject, content);
                this.sendMail(mail);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private Mail string2Obj(String to, String subject, String content){
        Mail mail = new Mail();
        mail.setFrom("2242464389@qq.com");
        mail.setTo(to);
        mail.setSuject(subject);
        mail.setContent(content);
        return mail;
    }

    private void sendMail(final Mail mail){
        template.send(new MessageCreator() {
            /**
             * @description: 将mail封装成一个消息对象
             * @param: session
             * @Date: 2019-06-07 12:38
             * @return: javax.jms.Message
             */
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage(mail);
                return message;
            }
        });
    }
}
