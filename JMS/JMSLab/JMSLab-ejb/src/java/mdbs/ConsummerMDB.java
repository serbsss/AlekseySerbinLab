/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdbs;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.*;

/**
 *
 * @author НР
 */
@MessageDriven(mappedName = "jms/jque", activationConfig = {
    @ActivationConfigProperty(propertyName="acknowledgeMode", propertyValue="Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/jque"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ConsummerMDB implements MessageListener {
    
    public ConsummerMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage=(TextMessage) message;
        for(int i=0;i<10;i++){
            try{
                System.out.println(i+":"+textMessage.getText());
                Thread.sleep(1000);
            } catch(Exception ex){
                Logger.getLogger(ConsummerMDB.class.getName()).log(Level.SEVERE, null,ex);
            }
        }
    }
    
}
