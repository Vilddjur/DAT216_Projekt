/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.beans.PropertyChangeListener;

/**
 *
 * @author mats
 */
public interface IObservable {
    public void addObserver(PropertyChangeListener pcl);
}
