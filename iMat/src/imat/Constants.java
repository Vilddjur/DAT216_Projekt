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
    public static final Color HOVER_COLOR = new Color(0xaaed93);
    public static final Color PRESSED_COLOR = new Color(0xd8fec6);
    
    //public static final Color DEFAULT_COLOR = Color.white;
    //public static final Color HOVER_COLOR = new Color(246, 246, 246);
    //public static final Color PRESSED_COLOR = new Color(237, 237, 237);
    
    public static final Color HIGHLIGHT_COLOR = new Color(0xF6F6F6);
    public static final Color HIGHLIGHT_HOVER_COLOR = new Color(0x767676);
    public static final Color HIGHLIGHT_PRESSED_COLOR = new Color(255, 219, 15);
    
    //public static final Color HIGHLIGHT_COLOR = new Color(255, 251, 10);
    //public static final Color HIGHLIGHT_HOVER_COLOR = new Color(255, 238, 5);
    //public static final Color HIGHLIGHT_PRESSED_COLOR = new Color(255, 219, 15);
    
    public static final Color ERROR_COLOR = new Color(0xe80000);
    public static final Color MAIN_BACKGROUND = new Color(0xF6F6F6);
    
    public static final Color SOFT_HIGHLIGHT_COLOR = new Color(0xFFFFE5);
    public static final Color CART_COLOR = new Color(0xFFFFE5);
    public static final Color LIST_COLOR = new Color(0xFFFFE5);
    public static final Color BANNER_COLOR = new Color(0xFBC7A0);
    
    private Constants() {
        throw new AssertionError();
    }
}
