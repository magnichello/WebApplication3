/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapplication3.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import webapplication3.entities.Computers;

/**
 *
 * @author nmagdun1
 */

@Stateless
public class ComputersDao {

    private String msg = "yaya";

    /*@Resource(lookup = "jms/sendQueueFactory")
    private static ConnectionFactory cf;

    @Resource(lookup = "jms/sendQueue")
    private static Queue queue;*/

    @PersistenceContext
    EntityManager em;

    public List<Computers> ComputersList() {
        return em.createQuery("SELECT p FROM Computers p", Computers.class).getResultList();
    }

    public String getMsg() {
        System.out.println("getting");
        readmsg();
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void readmsg() {
        
       
        try {
            Context context = new InitialContext();           
            ConnectionFactory cf = (ConnectionFactory)context.lookup("jms/sendQueueFactory");
            Queue queue = (Queue)context.lookup("jms/sendQueue");
            Connection connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer messageConsumer = session.createConsumer(queue);
            connection.start();
            TextMessage message = (TextMessage)messageConsumer.receive();
            System.out.println("messsage received");    
            System.out.println(queue.toString());  
            if(message!=null)
            this.msg=message.getText();
            connection.close();
        } catch (NamingException|JMSException ex) {
            Logger.getLogger(ComputersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
