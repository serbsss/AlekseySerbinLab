
package components;

import dao1.ClientFacade;
import dao2.OrdersFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import model1.Client;
import model2.Orders;

/**
 *
 * @author Serbin
 */
@Stateless
@LocalBean
public class SeansComp {

    @EJB
    private ClientFacade cf;

    @EJB
    private OrdersFacade of;


    public void Exp1(Orders order) {
        Client client = new Client();
        client.setName("ASDSA");
        client.setSurname("Pupkin");
        
        cf.create(client);
        of.create(order);
        
    }
    //rollback transaction
    public void Exp2(Orders order) {
        Client client = new Client();
        client.setName("Ivan");
        client.setSurname("wegwegweg");
        cf.create(client);
        of.createRollback(order);
    }

    //ejb exception
    public void Exp3(Orders order) throws Exception {
        Client client = new Client();
        client.setName("people");
        client.setSurname("wegwegweg");
        cf.create(client);
        of.createRollbackEJBException(order);
    }

    public void Exp4(Client client) {
        Orders order = new Orders();
        order.setClientId(client.getIdClient());
        order.setTotalSum(777);
        of.create(order);
        cf.createNotSupportedTransaction(client);
    }

    //requires new
    public void Exp5(Orders order) {
        Client client = new Client();
        client.setName("nname");
        client.setSurname("aaaa");
        cf.create(client);
        of.createTransactionRequiresNew(order);
    }
}
