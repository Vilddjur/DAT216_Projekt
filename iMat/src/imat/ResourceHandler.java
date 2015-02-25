/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author Oskar
 */
public class ResourceHandler {
    private static ResourceHandler instance;
    
    private Map<String, ImageIcon> imageMap;
    
    private ResourceHandler(){
        imageMap = new HashMap<>();
        File folder = new File(System.getProperty("user.home") + "/.dat215/imat/images/");
        int count = 0;
        for(File i: folder.listFiles()){
            ImageIcon tmp = new ImageIcon(i.getPath());
            Image image = tmp.getImage(); // transform it 
            Image newimg = image.getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // scale it the smooth way  
            tmp = new ImageIcon(newimg);  // transform it back
            
            imageMap.put(i.getName(), tmp);
            count++;
            System.out.println(count);
        }
    }
    public static ResourceHandler getInstance(){
        if(instance == null){
            instance = new ResourceHandler();
        }
        return instance;
    }
    public ImageIcon getImage(String s){
        return imageMap.get(s);
    }
    
}
