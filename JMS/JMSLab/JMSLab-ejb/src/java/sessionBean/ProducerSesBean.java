/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.*;

/**
 *
 * @author НР
 */
@Stateless
public class ProducerSesBean implements ProducerSesBeanLocal {

    @Resource(mappedName = "jms/jque")
    private Queue jque;
    @Resource(mappedName = "jms/jquepoolfactory")
    private ConnectionFactory jquepoolfactory;

    @Inject
    @JMSConnectionFactory("jms/jquepoolfactory")
    private JMSContext context;

    private Message createJMSMessageForjmsjque(Session session, Object messageData) throws JMSException {
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private void sendJMSMessageToJque(String messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = jquepoolfactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(jque);
            messageProducer.send(createJMSMessageForjmsjque(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    @Override
    public void sendMessageToQueue(String message) throws JMSException{
        sendJMSMessageToJque(message);
    }
}
