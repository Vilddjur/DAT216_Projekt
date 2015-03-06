/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Oskar
 */
public class CellRenderer extends SubcategoryListItem
        implements ListCellRenderer<Category> {
    private MouseAdapter    handler;
    private int             hoverIndex = -1;
    public CellRenderer() {
        setOpaque(true);
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Category> list, Category value, int index, boolean isSelected, boolean cellHasFocus) {
        setCategory(value);
        
        if (isSelected) {
            setBackground(Constants.HIGHLIGHT_COLOR);
        } else {
            if(index == hoverIndex){
                setBackground(Constants.HIGHLIGHT_HOVER_COLOR);
            }
            else{
                setBackground(Constants.DEFAULT_COLOR);
            }
        }
        
        return this;
    }
    public MouseAdapter getHandler(JList list){
        if(handler == null){
            handler = new HoverHandler(list);
        }
        return handler;
    }

    private class HoverHandler extends MouseAdapter {
        private final JList list;
        public HoverHandler(JList list) {
            this.list = list;
        }
        @Override
        public void mouseExited(MouseEvent e) {
            setHoverIndex(-1);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if(list.getModel().getSize()!=0){
                int index = list.locationToIndex(e.getPoint());
                setHoverIndex(list.getCellBounds(index, index).contains(e.getPoint())
                  ? index : -1);
            }
        }

        private void setHoverIndex(int index) {
        if (hoverIndex == index) return;
            hoverIndex = index;
            list.repaint();
        }
    }
}
