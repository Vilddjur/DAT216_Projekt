/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import imat.controller.UserManager;
import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import se.chalmers.ait.dat215.project.Customer;

/**
 *
 * @author Albertsson
 */
public class ProfilePanel extends javax.swing.JPanel
        implements PropertyChangeListener {
    
    private final UserManager um = UserManager.getInstance();
    
    /**
     * Creates new form profilePanel
     */
    public ProfilePanel() {
        initComponents();
        um.addPropertyChangeListener(this);
        
        fillFields();
    }
    
    public void fillFields() {
        Customer customer = um.getCustomer();
        
        nameLabel.setText(customer.getFirstName() + " " + customer.getLastName());
        persnbrLabel.setText(um.getPersnbr());
        emailLabel.setText(customer.getEmail());
        phoneLabel.setText(customer.getMobilePhoneNumber());
        adressLabel.setText(customer.getAddress());
        postcodeLabel.setText(customer.getPostCode());
        cityLabel.setText(customer.getPostAddress());
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("updateInfo")) {
            fillFields();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        headLabel = new javax.swing.JLabel();
        adressLabel = new javax.swing.JLabel();
        persnbrLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        postcodeLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        orderHistoryPanel2 = new imat.OrderHistoryPanel();
        nameLabel = new javax.swing.JLabel();

        headLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        headLabel.setText("Kontaktupgifter");

        adressLabel.setText("Kålgårdsgatan 3B");

        persnbrLabel.setText("920801-3293");

        emailLabel.setText("carl.albertsson@gmail.com");

        postcodeLabel.setText("41469");

        cityLabel.setText("Göteborg");

        phoneLabel.setText("0706-145301");

        editButton.setText("Redigera");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Carl Albertsson");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 887, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(orderHistoryPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                        .addComponent(adressLabel)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(postcodeLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cityLabel))
                        .addComponent(headLabel)
                        .addComponent(persnbrLabel)
                        .addComponent(emailLabel)
                        .addComponent(phoneLabel)
                        .addComponent(nameLabel)
                        .addComponent(editButton))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(headLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nameLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(persnbrLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(emailLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(phoneLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(adressLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cityLabel)
                        .addComponent(postcodeLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(editButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(orderHistoryPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        firePropertyChange("showEditProfileCard", null, null);
    }//GEN-LAST:event_editButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adressLabel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel headLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private imat.OrderHistoryPanel orderHistoryPanel2;
    private javax.swing.JLabel persnbrLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel postcodeLabel;
    // End of variables declaration//GEN-END:variables
}
