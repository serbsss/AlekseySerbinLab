/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model2.Orders;

/**
 *
 * @author Сергей
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> {
    @Resource
    private SessionContext sc;
    @PersistenceContext(unitName = "transact2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }
    
    public void createRollback(Orders orders){
        em.persist(orders);
        sc.setRollbackOnly();
    }
    public void createRollbackEJBException(Orders orders) throws Exception{
        em.persist(orders);
        throw new EJBException("Soryan");
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createTransactionRequiresNew(Orders orders){
        em.persist(orders);
    }
}
