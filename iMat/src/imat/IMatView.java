/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import imat.controller.UserManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Oskar
 */
public class IMatView extends javax.swing.JFrame implements PropertyChangeListener {
    
    private final IMatDataHandler imat = IMatDataHandler.getInstance();

    /**
     * Listens for changes in {@link SubcategoryList}
     * @param evt 
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String property = evt.getPropertyName();
        
        if (property.equals("subcategoryChange")) {
            if (evt.getNewValue() instanceof Category) {
                Category category = (Category) evt.getNewValue();
                if (category != null) {
                    productListPanel.updateProducts(category.getProducts());
                }
            } else if (evt.getNewValue() instanceof ProfileSubListItem) {
                ProfileSubListItem item = (ProfileSubListItem) evt.getNewValue();
                switchToCard(item.getCard());
            }
        } else if (property.equals("login")
                || property.equals("register")
                || property.equals("showProfileCard")) {
            switchToCard("profile");
            subcategoryList.clear();
            
            List<ProfileSubListItem> list = new ArrayList<>();
            list.add(new ProfileSubListItem("Profil", "profile"));
            list.add(new ProfileSubListItem("Orderhistorik", "orderHistory"));
            list.add(new ProfileSubListItem("Favoriter", "favourites"));
            Object[] arr = list.toArray();
            subcategoryList.update(arr);
        } else if (property.equals("gotoRegister")) {
            switchToCard("register");
            subcategoryList.clear();
            registerPanel.focusFirstField();
        } else if (property.equals("showEditProfileCard")) {
            switchToCard("editProfile");
            subcategoryList.clear();
            
            List<ProfileSubListItem> list = new ArrayList<>();
            list.add(new ProfileSubListItem("Profil", "e"));
            list.add(new ProfileSubListItem("Orderhistorik", "orderHistory"));
            list.add(new ProfileSubListItem("Favoriter", "favourites"));
            subcategoryList.update(list.toArray());
        } else if (property.equals("showLoginCard")) {
            switchToCard("login");
            subcategoryList.clear();
        }
    }
    /**
     * Hidden class {@link ConcreteSearchListener}, listens to when a search is made, thereafter displays the corresponding products.
     */
    private class ConcreteSearchListener implements SearchListener {
        @Override
        public void search(String str) {
            resetButtons();
            List<Product> results = imat.findProducts(str);
            productListPanel.updateProducts(results);
            switchToCard("productList");
            subcategoryList.clear();
        }
    }
    
    /**
     * Creates new form IMatView
     */
    public IMatView() {
        //progressBar
        loadResourcesWithProgressBar();
        
        initComponents();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                imat.shutDown();
            }
        });
        
        //request focus so search panel isnt focus on start
        homeButton.requestFocus();
        
        //topPanel
        searchPanel.addSearchButtonListener(new ConcreteSearchListener());
        
        //sideBar
        subcategoryList.addPropertyChangeListener(this);
        
        //checkoutButtonHandler
        shoppingPanel1.setCheckoutButtonPerformedListener(new ShowCheckoutContentHandler() {
            @Override
            public void showCheckoutContent() {
                resetButtons();
                switchToCard("checkOut");
                subcategoryList.clear();
            }
        });
        
        imat.getShoppingCart().addShoppingCartListener(checkOutItem2);
        
        loginPanel.addPropertyChangeListener(this);
        registerPanel.addPropertyChangeListener(this);
        profilePanel.addPropertyChangeListener(this);
        editProfilePanel.addPropertyChangeListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        homeButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        checkOutItem2 = new imat.CheckOutItem();
        profileButton = new imat.ProfileItem();
        searchPanel = new imat.SearchPanel();
        topHeadPanel = new javax.swing.JPanel();
        fruitButton = new imat.MainCategoryItem();
        fruitButton.setCategory(new MainProductCategory(MainProductCategory.Name.FRUIT_AND_VEGETABLES));
        charkButton = new imat.MainCategoryItem();
        charkButton.setCategory(new MainProductCategory(MainProductCategory.Name.CHARK));
        diaryButton = new imat.MainCategoryItem();
        diaryButton.setCategory(new MainProductCategory(MainProductCategory.Name.DIARIES));
        breadButton = new imat.MainCategoryItem();
        breadButton.setCategory(new MainProductCategory(MainProductCategory.Name.BREAD));
        snacksButton = new imat.MainCategoryItem();
        snacksButton.setCategory(new MainProductCategory(MainProductCategory.Name.DRINKS_AND_SNACKS));
        recipeButton = new imat.MainCategoryItem();
        dryButton = new imat.MainCategoryItem();
        dryButton.setCategory(new MainProductCategory(MainProductCategory.Name.DRY));
        jSplitPane1 = new javax.swing.JSplitPane();
        rightSplitPane = new javax.swing.JPanel();
        mainContentPanel = new javax.swing.JPanel();
        startPagePanel = new imat.StartPagePanel();
        checkOutPanel = new imat.CheckOutPanel();
        profilePanel = new imat.ProfilePanel();
        loginPanel = new imat.LoginPanel();
        registerPanel = new imat.RegisterPanel();
        productListPanel = new imat.ProductListPanel();
        editProfilePanel = new imat.EditProfilePanel();
        orderHistoryMainPanel1 = new imat.OrderHistoryMainPanel();
        favouritesPanel1 = new imat.FavouritesPanel();
        shoppingPanel1 = new imat.ShoppingPanel();
        subcategoryList = new imat.SubcategoryList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iMat - Mat..Mat!");

        mainPanel.setBackground(Constants.BANNER_COLOR);

        topPanel.setBackground(Constants.BANNER_COLOR);
        topPanel.setPreferredSize(new java.awt.Dimension(1120, 160));

        jPanel1.setBackground(Constants.MAIN_BACKGROUND);

        homeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/logo.jpg"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Marker Felt", 1, 36)); // NOI18N
        jLabel2.setForeground(Constants.FONT_BANNER_COLOR);
        jLabel2.setText("Din matbutik i molnet");

        checkOutItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkOutItem2MouseClicked(evt);
            }
        });

        profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkOutItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkOutItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        topHeadPanel.setBackground(new java.awt.Color(183, 227, 176));

        fruitButton.setMinimumSize(new java.awt.Dimension(100, 60));
        fruitButton.setName(""); // NOI18N
        fruitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fruitButtonMouseClicked(evt);
            }
        });

        charkButton.setMinimumSize(new java.awt.Dimension(100, 60));
        charkButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                charkButtonMouseClicked(evt);
            }
        });

        diaryButton.setMinimumSize(new java.awt.Dimension(100, 60));
        diaryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diaryButtonMouseClicked(evt);
            }
        });

        breadButton.setMinimumSize(new java.awt.Dimension(100, 60));
        breadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                breadButtonMouseClicked(evt);
            }
        });

        snacksButton.setMinimumSize(new java.awt.Dimension(100, 60));
        snacksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                snacksButtonMouseClicked(evt);
            }
        });

        recipeButton.setMinimumSize(new java.awt.Dimension(100, 60));
        recipeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipeButtonMouseClicked(evt);
            }
        });

        dryButton.setMinimumSize(new java.awt.Dimension(100, 60));
        dryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dryButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout topHeadPanelLayout = new javax.swing.GroupLayout(topHeadPanel);
        topHeadPanel.setLayout(topHeadPanelLayout);
        topHeadPanelLayout.setHorizontalGroup(
            topHeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topHeadPanelLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(fruitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(breadButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(charkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(diaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(dryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(snacksButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(recipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topHeadPanelLayout.setVerticalGroup(
            topHeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fruitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(charkButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(diaryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(breadButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(snacksButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(recipeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(topHeadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerSize(0);

        mainContentPanel.setMinimumSize(new java.awt.Dimension(934, 602));
        mainContentPanel.setPreferredSize(new java.awt.Dimension(100, 602));
        mainContentPanel.setLayout(new java.awt.CardLayout());
        mainContentPanel.add(startPagePanel, "startPage");
        mainContentPanel.add(checkOutPanel, "checkOut");
        mainContentPanel.add(profilePanel, "profile");
        mainContentPanel.add(loginPanel, "login");
        mainContentPanel.add(registerPanel, "register");
        mainContentPanel.add(productListPanel, "productList");
        mainContentPanel.add(editProfilePanel, "editProfile");
        mainContentPanel.add(orderHistoryMainPanel1, "orderHistory");

        javax.swing.GroupLayout favouritesPanel1Layout = new javax.swing.GroupLayout(favouritesPanel1);
        favouritesPanel1.setLayout(favouritesPanel1Layout);
        favouritesPanel1Layout.setHorizontalGroup(
            favouritesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1106, Short.MAX_VALUE)
        );
        favouritesPanel1Layout.setVerticalGroup(
            favouritesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );

        mainContentPanel.add(favouritesPanel1, "favourites");

        javax.swing.GroupLayout rightSplitPaneLayout = new javax.swing.GroupLayout(rightSplitPane);
        rightSplitPane.setLayout(rightSplitPaneLayout);
        rightSplitPaneLayout.setHorizontalGroup(
            rightSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightSplitPaneLayout.createSequentialGroup()
                .addComponent(mainContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(shoppingPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rightSplitPaneLayout.setVerticalGroup(
            rightSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shoppingPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(rightSplitPane);
        jSplitPane1.setLeftComponent(subcategoryList);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Redirects to handleClick(evt), @see #handleClick(MouseEvent evt)
     * @param evt 
     */
    private void fruitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fruitButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_fruitButtonMouseClicked
    /**
     * Redirects to handleClick(evt), @see #handleClick(MouseEvent evt)
     * @param evt 
     */
    private void breadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_breadButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_breadButtonMouseClicked
    /**
     * Redirects to handleClick(evt), @see #handleClick(MouseEvent evt)
     * @param evt 
     */
    private void charkButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charkButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_charkButtonMouseClicked
    /**
     * Redirects to handleClick(evt), @see #handleClick(MouseEvent evt)
     * @param evt 
     */
    private void diaryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diaryButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_diaryButtonMouseClicked
    /**
     * Redirects to handleClick(evt), @see #handleClick(MouseEvent evt)
     * @param evt 
     */
    private void dryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dryButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_dryButtonMouseClicked
    /**
     * Redirects to handleClick(evt), @see #handleClick(MouseEvent evt)
     * @param evt 
     */
    private void snacksButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_snacksButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_snacksButtonMouseClicked
    /**
     * Redirects to handleClick(evt), @see #handleClick(MouseEvent evt)
     * @param evt 
     */
    private void recipeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_recipeButtonMouseClicked
    
    /**
     * Handles the clicks of the maincategory buttons, reads the source and displays the corresponding products.
     * @param evt 
     */
    private void handleClick(java.awt.event.MouseEvent evt) {
        MainCategoryItem source = (MainCategoryItem)evt.getSource();
  
        resetButtons();
        source.highlight();
        
        switchToCard("productList");
        subcategoryList.clear();
        
        setList(source.getCategory());
    }
    /**
     * Resets all buttons, product list, subcategorylist and displays start page.
     * @param evt 
     */
    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        resetButtons();
        resetProductList();
        
        switchToCard("startPage");
        subcategoryList.clear();
    }//GEN-LAST:event_homeButtonMouseClicked
    /**
     * Checks the state of {@link UserManager}, logged in, switch to profile, not logged in, switch to loginform.
     * @param evt 
     */
    private void profileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseClicked
        resetButtons();
        if (UserManager.getInstance().isLoggedIn()) {
            switchToCard("profile");
            subcategoryList.clear();
            
            List<ProfileSubListItem> list = new ArrayList<>();
            list.add(new ProfileSubListItem("Profil", "profile"));
            list.add(new ProfileSubListItem("Orderhistorik", "orderHistory"));
            list.add(new ProfileSubListItem("Favoriter", "favourites"));
            Object[] arr = list.toArray();
            subcategoryList.update(arr);
        } else {
            switchToCard("login");
            subcategoryList.clear();
        }
    }//GEN-LAST:event_profileButtonMouseClicked
    
    private void checkOutItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkOutItem2MouseClicked
            shoppingPanel1.showContent(!(shoppingPanel1.getCurrentCard().equals("cartCard") && shoppingPanel1.isContentVisible()));
            shoppingPanel1.setContentToCart();
        
    }//GEN-LAST:event_checkOutItem2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IMatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IMatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IMatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IMatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IMatView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private imat.MainCategoryItem breadButton;
    private imat.MainCategoryItem charkButton;
    private imat.CheckOutItem checkOutItem2;
    private imat.CheckOutPanel checkOutPanel;
    private imat.MainCategoryItem diaryButton;
    private imat.MainCategoryItem dryButton;
    private imat.EditProfilePanel editProfilePanel;
    private imat.FavouritesPanel favouritesPanel1;
    private imat.MainCategoryItem fruitButton;
    private javax.swing.JLabel homeButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private imat.LoginPanel loginPanel;
    private javax.swing.JPanel mainContentPanel;
    private javax.swing.JPanel mainPanel;
    private imat.OrderHistoryMainPanel orderHistoryMainPanel1;
    private imat.ProductListPanel productListPanel;
    private imat.ProfileItem profileButton;
    private imat.ProfilePanel profilePanel;
    private imat.MainCategoryItem recipeButton;
    private imat.RegisterPanel registerPanel;
    private javax.swing.JPanel rightSplitPane;
    private imat.SearchPanel searchPanel;
    private imat.ShoppingPanel shoppingPanel1;
    private imat.MainCategoryItem snacksButton;
    private imat.StartPagePanel startPagePanel;
    private imat.SubcategoryList subcategoryList;
    private javax.swing.JPanel topHeadPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
    /**
     * Generic card switcher, also clear {@link SubcategoryList}
     * @param card 
     */
    private void switchToCard(String card) {       
        CardLayout manager = (CardLayout) mainContentPanel.getLayout();
        if(card=="checkOut"){
            CardLayout tmp = (CardLayout) checkOutPanel.getMainPanel().getLayout();
            tmp.show(checkOutPanel.getMainPanel(), "infoCard");
        }
        manager.show(mainContentPanel, card);
    }
    /**
     * Sets the {@link SubcategoryList} to the corresponding {@link Category}s
     * @param mainCategory 
     */
    private void setList(MainProductCategory mainCategory) {
        List<Category> subcategories = mainCategory.getSubcategories();
        subcategories.add(0, mainCategory);
        Object[] arr = subcategories.toArray();
        subcategoryList.update(arr);
    }
    /**
     * Resets all {@link MainCategoryItem}s
     */
    private void resetButtons() {
        fruitButton.reset();
        breadButton.reset();
        charkButton.reset();
        dryButton.reset();
        snacksButton.reset();
        diaryButton.reset();
        recipeButton.reset();
    }
    /**
     * 
     */
    private void resetProductList() {
        productListPanel.reset();
    }
    
    private void loadResourcesWithProgressBar() {
        final JDialog dlg = new JDialog(this, "Loading Resources...", true);
        JProgressBar bar = new JProgressBar(0,500);
        dlg.add(BorderLayout.CENTER, bar);
        dlg.add(BorderLayout.NORTH, new JLabel("Progress..."));
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.setSize(300, 75);
        dlg.setLocationRelativeTo(this);
        bar.setMaximum(150);
        Thread t = new Thread(new Runnable() {
            public void run() {
                dlg.setVisible(true);
            }
        });
        t.start();      
        ResourceHandler.getInstance(bar);
        dlg.setVisible(false);
    }
}
