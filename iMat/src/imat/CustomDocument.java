package imat;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mats
 */
public class CustomDocument extends PlainDocument {
    @Override
    public void insertString(int offset, String string, AttributeSet attr) throws BadLocationException {
        if (getLength() + string.length() <= 4) {
            super.insertString(offset, string, attr);
        }
    }

    @Override
    public void replace(int offset, int length, String string, AttributeSet attr) throws BadLocationException {
        if (getLength() - length + string.length() <= 4) {
            super.replace(offset, length, string, attr);
        }
    }
}
