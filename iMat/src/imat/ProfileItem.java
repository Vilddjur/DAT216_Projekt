/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import imat.controller.UserManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import se.chalmers.ait.dat215.project.User;

/**
 *
 * @author Albertsson
 */
public class ProfileItem extends javax.swing.JPanel implements PropertyChangeListener {

    /**
     * Creates new form ProfileItem
     */
    public ProfileItem() {
        initComponents();
        UserManager um = UserManager.getInstance();
        um.addObserver(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/my-profile-icon.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(40, 40));

        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Logga in");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("login")) {
            UserManager um = UserManager.getInstance();
            if (um.isLoggedIn()) {
                User user = um.getUser();
                label.setText(user.getUserName());
            } else {
                label.setText("Logga in");
            }
        } else if (evt.getPropertyName().equals("logout")) {
            label.setText("Logga in");
        }
    }
}
