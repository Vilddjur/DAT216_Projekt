/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Oskar
 */
public class CellRenderer extends JLabel implements ListCellRenderer<String>{

    public CellRenderer(){
        setOpaque(true);
        setFont(new Font(this.getFont().getName(), Font.PLAIN, 18));

    }
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
       
        setText(value);
        Color background;
        Color foreground;
        // check if this cell is selected
        if (isSelected) {
            background = Color.YELLOW;
            foreground = Color.BLACK;

        // unselected, and not the DnD drop location
        } else {
            background = Color.WHITE;
            foreground = Color.BLACK;
        };

        setBackground(background);
        setForeground(foreground);

        return this;
   }
    
}
