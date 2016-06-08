/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import components.SeansComp;
import dao1.ClientFacade;
import dao2.OrdersFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model1.Client;
import model2.Orders;

/**
 *
 * @author Serbin
 */
@Named(value = "controllerBean")
@SessionScoped
public class ControllerBean implements Serializable {

    @EJB
    private SeansComp seansComp;
    private Orders order;
    private Client client;

    @PostConstruct
    public void init() {
        setOrder(new Orders());
        setClient(new Client());
    }
    @EJB
    private ClientFacade cf;

    @EJB
    private OrdersFacade of;

    
 
    public ClientFacade getCf() {
        return cf;
    }

    public void setCf(ClientFacade cf) {
        this.cf = cf;
    }

    public OrdersFacade getOf() {
        return of;
    }

    public void setOf(OrdersFacade of) {
        this.of = of;
    }
    
     public List<Orders> getAllOrders() {
        return of.findAll();
    }
    public List<Client> getAllClients() {
        return cf.findAll();
    }

    public String addNewOrder() {
        seansComp.Exp1(order);
        return "/Clients.xhtml";
    }
    public String addNewOrder1() {
        seansComp.Exp2(order);
        return "/Clients.xhtml";
    }

    public String addNewOrder2() throws Exception {
        seansComp.Exp3(order);
        return "/Clients.xhtml";
    }

    public String addNewOrder3() {
        seansComp.Exp4(client);
        return "/index.xhtml";
    }
    
    public String addNewOrder4(){
        seansComp.Exp5(order);
        return "/Clients.xhtml";  
     
    }
    /**
     * @return the order
     */
    public Orders getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Orders order) {
        this.order = order;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
