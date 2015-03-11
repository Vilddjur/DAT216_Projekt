/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import com.sun.glass.ui.Cursor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

/**
 *
 * @author win8
 */
public class ExpandButton extends JToggleButton {

    public ExpandButton(int size) {
        setSize(size, size);
        this.setPreferredSize(new Dimension(size, size));
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    // Paint the border of the button using a simple stroke.

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1,
                getSize().height - 1);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1,
                getSize().height - 1);

        g.setColor(getForeground());
        int center = getSize().height /2;
        int leftX = center/2;
        int rightX = center + leftX;
        g.drawLine(leftX, center/2+ (isSelected()? 0 : center/2), rightX, center +(isSelected()? 0 : center/2));
        
        g.drawLine(leftX, (center*3/2)-(isSelected()?  0 : center/2), rightX, center - (isSelected()?  0 : center/2));

    }
// Hit detection.
    Shape shape;

    public boolean contains(int x, int y) {
// If the button has changed size, 
        // make a new shape object.
        if (shape == null
                || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0,
                    getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }


}
