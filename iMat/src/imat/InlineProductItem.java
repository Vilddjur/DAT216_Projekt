/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author mats
 */
public class InlineProductItem extends javax.swing.JPanel {

    /**
     * Creates new form InlineProductItem
     */
    public InlineProductItem(ShoppingItem item) {
        initComponents();
        updateFields(item);
    }
    
    public void updateFields(ShoppingItem item) {
        Product product = item.getProduct();
        
        img.setIcon(ResourceHandler.getInstance().getImage(product.getImageName()));
        name.setText(product.getName());
        count.setText(item.getAmount() + "");
        price.setText(product.getPrice() + " " + product.getUnit());
        total.setText(item.getTotal() + " kr");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labels = new javax.swing.JPanel();
        imgWrapper = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        count = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        setBackground(new java.awt.Color(246, 246, 246));

        labels.setBackground(new java.awt.Color(246, 246, 246));

        imgWrapper.setBackground(new java.awt.Color(246, 246, 246));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/product_1.jpg"))); // NOI18N

        javax.swing.GroupLayout imgWrapperLayout = new javax.swing.GroupLayout(imgWrapper);
        imgWrapper.setLayout(imgWrapperLayout);
        imgWrapperLayout.setHorizontalGroup(
            imgWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgWrapperLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        imgWrapperLayout.setVerticalGroup(
            imgWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgWrapperLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        name.setText("Namn");

        count.setText("Antal");

        price.setText("Enhetspris");

        total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total.setText("Totalt pris");

        javax.swing.GroupLayout labelsLayout = new javax.swing.GroupLayout(labels);
        labels.setLayout(labelsLayout);
        labelsLayout.setHorizontalGroup(
            labelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelsLayout.createSequentialGroup()
                .addComponent(imgWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        labelsLayout.setVerticalGroup(
            labelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(labelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(imgWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(labels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel count;
    private javax.swing.JLabel img;
    private javax.swing.JPanel imgWrapper;
    private javax.swing.JPanel labels;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}