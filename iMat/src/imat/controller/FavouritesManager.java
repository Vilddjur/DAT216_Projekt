/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.controller;

import imat.IPropertyChangeSupport;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Oskar
 */
public class FavouritesManager implements IPropertyChangeSupport{
    private static final FavouritesManager instance = new FavouritesManager();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final IMatDataHandler imat = IMatDataHandler.getInstance();
    private FavouritesManager() {
    }

    public static FavouritesManager getInstance() {
        return instance;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }
    public void addFavourite(Product p){
        imat.addFavorite(p);
        pcs.firePropertyChange("addFavourite",null,null);
    }
    public void removeFavourite(Product p){
        imat.removeFavorite(p);
        pcs.firePropertyChange("removeFavourite",null,null);
    }
    public void toggleFavourite(Product p){
        if(imat.isFavorite(p)){
            removeFavourite(p);
        }else{
            addFavourite(p);
        }
    }
}
