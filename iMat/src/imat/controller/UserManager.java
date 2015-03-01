/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.controller;

import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.User;

/**
 *
 * @author win8
 */
public class UserManager {
    
    private final Customer customer;
    private final User user;
    
    public UserManager(){
        this.customer = IMatDataHandler.getInstance().getCustomer();
        this.user = IMatDataHandler.getInstance().getUser();
    }
    
    public Customer getCustomer(){
        return this.customer;
    }
    
    public User getUser(){
        return this.user;
    }
}
