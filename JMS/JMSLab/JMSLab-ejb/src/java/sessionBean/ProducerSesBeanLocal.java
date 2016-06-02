/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import javax.ejb.Local;
import javax.jms.JMSException;

/**
 *
 * @author НР
 */
@Local
public interface ProducerSesBeanLocal {
    public void sendMessageToQueue(String message) throws JMSException;
}
