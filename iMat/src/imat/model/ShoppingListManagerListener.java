/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.model;

import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public interface ShoppingListManagerListener {
    
    public void changedActiveList(ShoppingList shoppingList);
    
    public void itemAddedToActiveList(ShoppingItem item);
    public void itemModifiedInActiveList(ShoppingItem item);
    public void itemDeletedInActiveList(ShoppingItem item);
    
}
