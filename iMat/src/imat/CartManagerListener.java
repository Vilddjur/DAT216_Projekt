/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import imat.model.SubShoppingCart;

/**
 *
 * @author win8
 */
public interface CartManagerListener {
    public void subCartAdded(SubShoppingCart cart);
    public void subCartRemoved(SubShoppingCart cart);
}
