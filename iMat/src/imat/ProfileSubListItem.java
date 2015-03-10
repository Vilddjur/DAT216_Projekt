/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

/**
 *
 * @author mats
 */
public class ProfileSubListItem implements SubListItem {
    
    private String text;
    private String card;
    
    public ProfileSubListItem(String text, String card) {
        this.text = text;
        this.card = card;
    }
    
    public String getCard() {
        return card;
    }
    
    public String toString() {
        return text;
    }
}
