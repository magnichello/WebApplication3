/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapplication3.bean;

import java.net.URL;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;
import static java.lang.System.out;
import java.net.MalformedURLException;
import java.util.Scanner;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.UIDFolder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import webapplication3.ejb.ComputersDao;
import webapplication3.entities.Computers;

/**
 *
 * @author nmagdun1
 */
@Named
@RequestScoped
public class ComputersBean {
    private String fff;
    private String filter;
    private List<Computers> computers;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Inject
    ComputersDao computersDao;

    public List<Computers> getComputers() {
        
            computers = computersDao.ComputersList();
        
        return computers;
    }
    public String tralala() throws MalformedURLException, SAXException, IOException, ParserConfigurationException{
        URL url=new URL("http://www.reuters.com/tools/rss");
        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
        DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = df.newDocumentBuilder();
        //Document doc = db.parse(url.openStream());
        //Element root = doc.getDocumentElement();
        ;
                String a;
                String b="";
        while((a=br.readLine())!=null)
            b=b+a;
        return b;
        
    }
    
    

}