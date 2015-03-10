/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.model;

import java.util.List;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public class SubShoppingCart extends ShoppingCart implements ShoppingCartListener{
    
    private final ShoppingCart mainCart = IMatDataHandler.getInstance().getShoppingCart();
    private String name;

    public SubShoppingCart() {
        mainCart.addShoppingCartListener(this);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    @Override
    public void removeItem(int index) {
        mainCart.removeItem(index);
        //we are listening on changes on the main cart so we will be alerted when an item has been removed
    }
    @Override
    public void removeItem(ShoppingItem sce) {
        mainCart.removeItem(sce);
        //we are listening on changes on the main cart so we will be alerted when an item has been removed
    }
    
    @Override
    public void addItem(ShoppingItem sce) {
       super.addItem(sce);
       mainCart.addItem(sce);
    }
    
    @Override
    public void addProduct(Product p) {
        super.addProduct(p);
        mainCart.addProduct(p);
    }
    
    @Override
    public void addProduct(Product p, double d) {
        super.addProduct(p, d);
        mainCart.addProduct(p,d);
    }

    @Override
    public void shoppingCartChanged(CartEvent ce) {
        ShoppingItem item =ce.getShoppingItem();
        if(item == null ) {
            //cart was emptied so lets empty this one too
            clear();
        }
        else if(ce.isAddEvent()) {
            //we ignore this because the item seems not be added to this subcart
            return;
        }
        else if(this.getItems().contains(item)) {
            if(!mainCart.getItems().contains(item)) {
                //item was removed from main cart
                super.removeItem(item);
            }
            else {
                //item was probably modified pass on event
                fireShoppingCartChanged(item, ce.isAddEvent());
            }
        }
    }
    
    
    
    
        
}
