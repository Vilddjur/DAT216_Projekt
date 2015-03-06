/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.controller;

import imat.model.ShoppingList;
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
    
    public CartManager(){
        this.cart = IMatDataHandler.getInstance().getShoppingCart();
    }
    public void addProduct(double amount,Product item){
        cart.addProduct(item, amount);
    }
    public void removeItem(int i){
        cart.removeItem(i);
    }
    public void removeItem(ShoppingItem item){
        cart.removeItem(item);
    }
    public List<ShoppingItem> getItems(){
        return cart.getItems();
    }
    
    public ShoppingList getShoppingListForItem(ShoppingItem item) {
        return null;
    }
    public double getTotal(){
        return cart.getTotal();
    }
}
