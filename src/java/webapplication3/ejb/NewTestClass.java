/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapplication3.ejb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sun.net.www.http.HttpClient;
import webapplication3.entities.Computers;
import java.net.*;
/**
 *
 * @author nmagdun1
 */

public class NewTestClass {       
               
    
    public void getContext()
    {
        try {
            URL url= new URL("http://www.bigmir.net");        
            BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream())); 
            String str;
            while((str=br.readLine())!=null)
            {
                System.out.println();
            }
                
        }
    catch(Exception e){
    
}

}
}
