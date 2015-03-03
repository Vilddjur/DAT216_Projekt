/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.controller;

import imat.IObservable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.User;

/**
 *
 * @author win8
 */
public class UserManager implements IObservable {
    private static final UserManager instance = new UserManager();
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    private boolean isLoggedIn = false;
    
    private final Customer customer;
    private final User user;
    private final CreditCard card;
    
    private UserManager() {
        this.customer = IMatDataHandler.getInstance().getCustomer();
        this.user = IMatDataHandler.getInstance().getUser();
        this.card = IMatDataHandler.getInstance().getCreditCard();
        user.setUserName("Mad Mats");
        user.setPassword("abc123");
    }
    
    public static UserManager getInstance() {
        return instance;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public CreditCard getCard() {
        return this.card;
    }
    public boolean login(String username, String password) {
        if (user.getUserName().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
            isLoggedIn = true;
        } else {
            isLoggedIn = false;
        }
        pcs.firePropertyChange("login", null, null);
        return isLoggedIn;
    }
    
    public void logout() {
        isLoggedIn = false;
        pcs.firePropertyChange("logout", null, null);
    }
    
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    @Override
    public void addObserver(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }
    
    public boolean register(String persnbr, String address, String email,
            String firstname, String lastname, String phoneNumber,
            String city, String postCode, String password) {
        
        if (email.equals("") || password.equals("")) {
            return false;
        } else {
            user.setUserName(email);
            user.setPassword(password);
            
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setFirstName(firstname);
            customer.setLastName(lastname);
            customer.setMobilePhoneNumber(phoneNumber);
            customer.setPostAddress(city);
            customer.setPostCode(postCode);
            
            login(email, password);
        }
        
        return true;
    }
}
