/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.controller;

/**
 *
 * @author win8
 */
public class ShoppingListManager {
    private static final ShoppingListManager  instance = new ShoppingListManager();
    
    public static ShoppingListManager getInstance() {
        return instance;
    }
    
}
