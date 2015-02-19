/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import javax.swing.JLabel;

/**
 *
 * @author Oskar
 */
public class GradientLabel extends JLabel{
    private Color start = new Color(255, 252, 40);
    private Color end = new Color(255,252,60);
    private boolean selected = false;
    private String text;
    public GradientLabel(){
        text = "";
    }
    public void setSelected(boolean b){
        selected = b;
    }
    public void setText(String s){
        super.setText(s);
        text = s;
    }
    @Override
    public void paintComponent( Graphics g ){
        if(selected){
            int width = getWidth();
            int height = getHeight();

            // Create the gradient paint
            GradientPaint paint = new GradientPaint( width/2, 0, start, width/2, height/2, end, true );

            // we need to cast to Graphics2D for this operation
            Graphics2D g2d = ( Graphics2D )g;

            // save the old paint
            Paint oldPaint = g2d.getPaint();

            // set the paint to use for this operation
            g2d.setPaint( paint );

            // fill the background using the paint
            g2d.fillRect( 0, 0, width, height );
            g2d.setPaint(Color.BLACK);
            g2d.drawString(text, 0, 18);
            // restore the original paint
            g2d.setPaint( oldPaint );

            //super.paintComponent(g);
        }else{
            super.paintComponent(g);
        }
    }
}
