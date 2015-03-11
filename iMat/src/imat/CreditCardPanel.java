/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 *
 * @author Albertsson
 */
public class CreditCardPanel extends javax.swing.JPanel {
    
    CreditCard card = IMatDataHandler.getInstance().getCreditCard();
    private boolean editState;

    /**
     * Creates new form CreditCardPanel
     */
    public CreditCardPanel() {
        initComponents();
        editState=false;
        setFieldsEditable(false);
        updateCardInfo();
    }

    private void updateCardInfo(){
        ccvTextField.setText("" + card.getVerificationCode());
        dateTextField.setText(card.getValidMonth() + "/" + card.getValidYear());
        nameTextField.setText(card.getHoldersName());
        
        String cardNumber = card.getCardNumber();
        if(cardNumber.length() == 16){
            nbr1TextField.setText(cardNumber.substring(0, 4));
            nbr2TextField.setText(cardNumber.substring(4, 8));
            nbr3TextField.setText(cardNumber.substring(8, 12));
            nbr4TextField.setText(cardNumber.substring(12, 16));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nbr1TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nbr2TextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nbr3TextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nbr4TextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ccvTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(500, 350));

        jPanel1.setBackground(new java.awt.Color(24, 70, 132));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_01.jpg"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_02.jpg"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_04.jpg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_06.jpg"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_08.jpg"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_10.jpg"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_11.jpg"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_12.jpg"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_14.jpg"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_16.jpg"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_17.jpg"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_18.jpg"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_new_21.jpg"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_custom_21.jpg"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/visa/credit_card_custom_23.jpg"))); // NOI18N

        editButton.setText("Redigera");
        editButton.setPreferredSize(new java.awt.Dimension(128, 35));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(nbr1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(nbr2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(nbr3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(nbr4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, 0)
                                .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel9)
                                .addGap(0, 0, 0)
                                .addComponent(ccvTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel10))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, 0)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel15)
                                .addGap(1, 1, 1)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbr3TextField)
                    .addComponent(nbr4TextField)
                    .addComponent(nbr2TextField)
                    .addComponent(nbr1TextField))
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(jLabel9)
                        .addComponent(ccvTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(0, 0, 0)
                .addComponent(jLabel11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameTextField)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jLabel14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if(!editState) {
            setFieldsEditable(true);
            editState=true;
            editButton.setText("Spara");
        }else{
            editState=false;
            card.setHoldersName(nameTextField.getText());
            if(dateTextField.getText().contains("/")){
                String[] my = dateTextField.getText().split("/");
                try{
                    card.setValidMonth(Integer.parseInt(my[0]));
                    card.setValidYear(Integer.parseInt(my[1]));
                }catch(NumberFormatException e){
                    
                }
            }
            card.setCardNumber(nbr1TextField.getText() + nbr2TextField.getText() + nbr3TextField.getText() + nbr4TextField.getText());
            editButton.setText("Redigera");
            setFieldsEditable(false);
        }
    }//GEN-LAST:event_editButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ccvTextField;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField nbr1TextField;
    private javax.swing.JTextField nbr2TextField;
    private javax.swing.JTextField nbr3TextField;
    private javax.swing.JTextField nbr4TextField;
    // End of variables declaration//GEN-END:variables

    private void setFieldsEditable(boolean b) {
        ccvTextField.setEditable(b);
        dateTextField.setEditable(b);
        nameTextField.setEditable(b);
        nbr3TextField.setEditable(b);
        nbr2TextField.setEditable(b);
        nbr4TextField.setEditable(b);
        nbr1TextField.setEditable(b);
    }
}
