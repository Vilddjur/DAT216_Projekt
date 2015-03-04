/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.controller;

import imat.IPropertyChangeSupport;
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
public class UserManager implements IPropertyChangeSupport {
    private String persnbr = "";
    
    private static final UserManager instance = new UserManager();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    private boolean isLoggedIn = false;
    private boolean isRegistered = false;
    
    private final Customer customer;
    private final User user;
    private final CreditCard card;
    
    private UserManager() {
        this.customer = IMatDataHandler.getInstance().getCustomer();
        this.user = IMatDataHandler.getInstance().getUser();
        this.card = IMatDataHandler.getInstance().getCreditCard();
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
        if (isRegistered && user.getUserName().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
            isLoggedIn = true;
            pcs.firePropertyChange("login", null, null);
        } else {
            isLoggedIn = false;
        }
        return isLoggedIn;
    }
    
    public void logout() {
        isLoggedIn = false;
        pcs.firePropertyChange("logout", null, null);
    }
    
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    
    public boolean register(String persnbr, String address, String email,
            String firstname, String lastname, String phoneNumber,
            String city, String postCode, String password) {
        
        if (email.equals("") || password.equals("")) {
            isRegistered = false;
        } else {
            isRegistered = true;
            
            updateInfo(persnbr, address, email, firstname, lastname, phoneNumber, city, postCode);
            setPassword(password);
            login(email, password);
        }
        
        return isRegistered;
    }
    
    public void updateInfo(String persnbr, String address, String email,
            String firstname, String lastname, String phoneNumber,
            String city, String postCode) {
        
        user.setUserName(email);

        customer.setAddress(address);
        customer.setEmail(email);
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setMobilePhoneNumber(phoneNumber);
        customer.setPostAddress(city);
        customer.setPostCode(postCode);
        
        this.persnbr = persnbr;
        
        pcs.firePropertyChange("updateInfo", null, null);
    }
    
    public String getPersnbr() {
        return this.persnbr;
    }
    
    public void setPassword(String password) {
        user.setPassword(password);
    }
    
    public String getPassword() {
        return user.getPassword();
    }
    
    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }
}
