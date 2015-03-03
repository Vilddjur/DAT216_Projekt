/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Oskar
 */
public class CellRenderer extends SubcategoryListItem
        implements ListCellRenderer<Category> {
    
    public CellRenderer() {
        setOpaque(true);
        setFont(new Font(this.getFont().getName(), Font.PLAIN, 18));
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Category> list, Category value, int index, boolean isSelected, boolean cellHasFocus) {
        setCategory(value);
        
        if (isSelected) {
            setBackground(Constants.HIGHLIGHT_COLOR);
        } else {
            setBackground(Constants.DEFAULT_COLOR);
        }
        
        return this;
    }
}
