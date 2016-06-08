/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model1.Client;

/**
 *
 * @author Serbin 
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client>{

    @PersistenceContext(unitName = "transact-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void createNotSupportedTransaction(Client client){
        em.persist(client);
    }
}
