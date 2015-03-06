/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import javax.swing.JLabel;

/**
 *
 * @author mats
 */
public class SubcategoryListItem extends JLabel{
    public SubcategoryListItem() {}
    
    public SubcategoryListItem(Category category) {
        setCategory(category);
    }
    
    public void setCategory(Category category) {
        super.setText(category.toString());
    }
}
