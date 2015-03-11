/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.awt.Color;

/**
 *
 * @author mats
 */
public final class Constants {
    public static final Color DEFAULT_COLOR = new Color(0xB7E3B0);
    public static final Color HOVER_COLOR = new Color(0x8FD084);
    public static final Color PRESSED_COLOR = new Color(0xd8fec6);
    
    public static final Color HIGHLIGHT_COLOR = new Color(0xF6F6F6);
    public static final Color HIGHLIGHT_HOVER_COLOR = new Color(0xF4FBF3);
    public static final Color HIGHLIGHT_PRESSED_COLOR = new Color(255, 219, 15);
    
    public static final Color ERROR_COLOR = new Color(0xe80000);
    public static final Color MAIN_BACKGROUND = new Color(0xF6F6F6);
    
    public static final Color SOFT_HIGHLIGHT_COLOR = new Color(0xFFFFE5);
    public static final Color CART_COLOR = new Color(0xFFFFE5);
    public static final Color LIST_COLOR = new Color(0xA0B7C3);
    
    public static final Color BANNER_COLOR = new Color(0xF6F6F6);
    public static final Color FONT_BANNER_COLOR = new Color(0x6B9937);
    
    public static final Color ADD_TO_CHECKOUT_BUTTON_COLOR = new Color(0xB7E3B0);
    public static final Color CHECKOUT_BUTTON_COLOR = new Color(0x89d57c);
    public static final Color HOVER_ADD_TO_CHECKOUT_BUTTON_COLOR = new Color(0xB7E3B0);
    public static final Color HOVER_CHECKOUT_BUTTON_COLOR = new Color(0x89d57c);
    
    public static final Color DISABLED_TEXT_FIELD_COLOR = new Color(0xD6D6D6);
    
    private Constants() {
        throw new AssertionError();
    }
}
