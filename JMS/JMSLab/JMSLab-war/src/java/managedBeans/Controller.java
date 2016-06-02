/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.JMSException;
import sessionBean.ProducerSesBeanLocal;

/**
 *
 * @author НР
 */
@Named(value = "controller")
@RequestScoped
public class Controller {

    @EJB
    private ProducerSesBeanLocal producerSesBean;

    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }

    public String synchronousProcess() {
        System.out.print("Synchr");
        return null;
    }

    public String asynchronousProcess() {
        try {
            producerSesBean.sendMessageToQueue("SOme Message");

        } catch (JMSException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
