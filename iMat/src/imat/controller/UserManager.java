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
    
    private String regPersnbr;
    private String regAddress;
    private String regEmail;
    private String regFirstname;
    private String regLastname;
    private String regPhoneNumber;
    private String regCity;
    private String regPostCode;
    
    private static final UserManager instance = new UserManager();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    private boolean isLoggedIn = false;
    
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
        if (user.getUserName().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
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
            return false;
        } else {
            updateInfo(persnbr, address, email, firstname, lastname, phoneNumber, city, postCode);
            setPassword(password);
            resetCreditCard(firstname + " " + lastname);
            login(email, password);
            return true;
        }
    }
    
    private void resetCreditCard(String lastname) {
        card.setCardNumber("");
        card.setCardType("");
        if (!lastname.trim().equals("")) {
            card.setHoldersName(lastname);
        } else {
            card.setHoldersName("");
        }
        card.setValidMonth(1);
        card.setValidYear(2015);
        card.setVerificationCode(123);
        
        pcs.firePropertyChange("resetCreditCard", null, null);
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
    
    public void updateRegisterInfo(String persnbr, String address, String email,
            String firstname, String lastname, String phoneNumber,
            String city, String postCode) {
        this.regPersnbr = persnbr;
        this.regAddress = address;
        this.regEmail = email;
        this.regFirstname = firstname;
        this.regLastname = lastname;
        this.regPhoneNumber = phoneNumber;
        this.regCity = regCity;
        this.regPostCode = postCode;
        
        pcs.firePropertyChange("updateRegisterInfo", null, null);
    }
    
    public void resetRegisterInfo() {
        updateRegisterInfo("","","","","","","","");
    }
    
    public String getRegPersnbr() {
        return regPersnbr;
    }
    
    public String getRegAddress() {
        return regAddress;
    }
    
    public String getRegEmail() {
        return regEmail;
    }
    
    public String getRegFirstName() {
        return regFirstname;
    }
    
    public String getRegLastName() {
        return regLastname;
    }
    
    public String getRegPhoneNumber() {
        return regPhoneNumber;
    }
    
    public String getRegCity() {
        return regCity;
    }
    
    public String getRegPostCode() {
        return regPostCode;
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
