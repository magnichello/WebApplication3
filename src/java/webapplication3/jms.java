/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapplication3;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import com.sun.tools.xjc.model.CBuiltinLeafInfo;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;


import javax.inject.Inject;
import javax.inject.Named;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import webapplication3.bean.ComputersBean;
import webapplication3.ejb.ComputersDao;
import webapplication3.ejb.Test;

/**
 *
 * @author nmagdun1
 */
/*
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/sendQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})

public class jms implements MessageListener {
    private static List<String> msgs;
    private String msg="empty";

    public jms() {        
    }

    public String getMsg() {
        return msg;
    }

    
    
    @EJB
    ComputersBean cb;    
    
                  
    @Override
    public void onMessage(Message message) {        
        TextMessage msg = null;              
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
               cb.setMsg("vvvv");             
               this.msg=msg.getText();
               cb.ListAdd(this.msg);
            }

        } catch (JMSException ex) {
            Logger.getLogger(jms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<String> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<String> msgs) {
        this.msgs = msgs;
    }

}
*/