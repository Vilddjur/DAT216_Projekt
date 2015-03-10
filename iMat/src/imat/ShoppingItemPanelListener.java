/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public interface ShoppingItemPanelListener {
    
    public void amountChanged(ShoppingItem item, double changedTo);
    public void itemRemoved(ShoppingItem item);
}
