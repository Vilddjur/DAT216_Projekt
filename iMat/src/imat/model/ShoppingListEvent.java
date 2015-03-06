/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.model;

import java.util.EventObject;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public class ShoppingListEvent extends EventObject {

    private ShoppingItem shoppingItem;
    private boolean addEvent;

    public ShoppingListEvent(Object source, ShoppingItem shoppingItem, boolean addEvent) {
        super(source);
        this.shoppingItem = shoppingItem;
        this.addEvent = addEvent;
    }

    public ShoppingItem getShoppingItem() {
        return shoppingItem;
    }

    public void setShoppingItem(ShoppingItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    public boolean isAddEvent() {
        return addEvent;
    }

    public void setAddEvent(boolean addEvent) {
        this.addEvent = addEvent;
    }

}
