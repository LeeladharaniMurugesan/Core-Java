package com.chainsys.miniproject.pojo;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent arg0) {
        System.out.println("Value bound " + arg0.getName());
        System.out.println("value :" + arg0.getValue().getClass().getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent arg0) {
        System.out.println("Value Unbound " + arg0.getName());

    }

    private String user_id;
    private String password;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
	
