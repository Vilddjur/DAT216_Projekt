/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.util.List;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Oskar
 */
public class IMat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Starting iMat...");
       
        new IMatView().setVisible(true);
    }
    
}
