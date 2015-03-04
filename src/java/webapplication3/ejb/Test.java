/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapplication3.ejb;

import java.util.List;

/**
 *
 * @author nmagdun1
 */
public class Test {
    static private List<String> messages; 
    
    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Test() {
    }
    
    public void ListAdd(String msg){
        this.messages.add(msg);
    }
}
