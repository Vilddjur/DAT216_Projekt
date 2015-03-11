/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.controller;

import imat.CartManagerListener;
import imat.model.ShoppingList;
import imat.model.SubShoppingCart;
import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public class CartManager {

    private final ShoppingCart cart;
    private List<SubShoppingCart> subcarts = new ArrayList<>();
    private final List<CartManagerListener> managerListeners = new ArrayList<>();
    private static final CartManager instance = new CartManager();

    public CartManager() {
        this.cart = IMatDataHandler.getInstance().getShoppingCart();
    }

    public static CartManager getInstance() {
        return instance;
    }

    public void addProduct(double amount, Product item) {
        cart.addProduct(item, amount);
    }

    public void removeItem(int i) {
        cart.removeItem(i);
    }

    public void removeItem(ShoppingItem item) {
        cart.removeItem(item);
    }

    public List<ShoppingItem> getItems() {
        return cart.getItems();
    }

    public void setAmountOfItem(ShoppingItem item, double amount) {
        if (amount <= 0) {
            cart.removeItem(item);
            return;
        }
        item.setAmount(amount);
        cart.fireShoppingCartChanged(item, false);
    }

    public void addShoppingListToCart(ShoppingList shoppingList) {
        System.out.println("shoppingList added");
        SubShoppingCart subcart = new SubShoppingCart();
        
        subcart.setName(shoppingList.getName());
        
        subcarts.add(subcart);
        for (ShoppingItem item : shoppingList.getItems()) {
            subcart.addItem(new ShoppingItem(item.getProduct(), item.getAmount()));
        }
         for(CartManagerListener listener : managerListeners) {
            listener.subCartAdded(subcart);
        }
        
    }

    public boolean containsShoppingItem(ShoppingItem item) {
        return cart.getItems().contains(item);
    }

    public List<SubShoppingCart> getSubShoppingCartList() {
        return subcarts;
    }
    public SubShoppingCart getSubCartForItem(ShoppingItem item) {
        for (SubShoppingCart subcart : subcarts) {
            if (subcart.getItems().contains(item)) {
                return subcart;
            }
        }
        return null;
    }

    public double getTotal() {
        return cart.getTotal();
    }

    public void addCartManagerListener(CartManagerListener listener) {
        managerListeners.add(listener);
    }
    
    public void removeCartManagerListener(CartManagerListener listener) {
        managerListeners.remove(listener);
        
    }
    
  
    public void clear() {
        cart.clear();
    }
    
    
}
