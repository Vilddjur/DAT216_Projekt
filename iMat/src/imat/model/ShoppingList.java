/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.model;

import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public class ShoppingList {

    private String name;
    private List<ShoppingItem> items;
    private List<ShoppingListListener> listeners;

    private void notifyAllObservers(ShoppingListEvent e) {
        for (ShoppingListListener listener : listeners) {
            listener.shoppingListChanged(e);
        }
    }
    
    
    public ShoppingList(String name, List<ShoppingItem> items) {
        this.name = name;
        this.items = items;
        listeners = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShoppingItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingItem> items) {
        this.items = items;
    }

    public void removeItem(ShoppingItem item) {
        items.remove(item);
        notifyAllObservers(new ShoppingListEvent(this, item, false));
    }

    public void addItem(ShoppingItem item) {
        items.add(item);
        notifyAllObservers(new ShoppingListEvent(this, item, true));
    }

    public void addShoppingListListener(ShoppingListListener listener) {
        listeners.add(listener);

    }

    
}
