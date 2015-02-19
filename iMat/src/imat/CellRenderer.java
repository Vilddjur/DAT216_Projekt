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
public class CellRenderer extends GradientLabel implements ListCellRenderer<String>{

    public CellRenderer(){
        setOpaque(true);
        setFont(new Font(this.getFont().getName(), Font.PLAIN, 18));
        setBackground(Color.WHITE);
    }
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
       
        setText(value);
        setSelected(isSelected);
        return this;
   }
    
}
