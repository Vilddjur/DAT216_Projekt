/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.controller;

import imat.IPropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 *
 * @author win8
 */
public class OrderManager implements IPropertyChangeSupport {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    private static final OrderManager instance = new OrderManager();
    private IMatDataHandler imat = IMatDataHandler.getInstance();
    
    private OrderManager() {
        
    }
    
    public static OrderManager getInstance() {
        return instance;
    }
    
    public void placeOrder() {
        UserManager um = UserManager.getInstance();
        if (um.isLoggedIn()) {
            imat.placeOrder(true);
        }
        pcs.firePropertyChange("order", null, null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }
}
