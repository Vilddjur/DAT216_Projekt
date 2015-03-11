/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat.controller;

import imat.model.ShoppingList;
import imat.model.ShoppingListManagerListener;
import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public class ShoppingListManager {

    private static final ShoppingListManager instance = new ShoppingListManager();

    private List<ShoppingList> availableLists = new ArrayList();
    private ShoppingList currentList;
    private List<ShoppingListManagerListener> listeners = new ArrayList();

    private ShoppingListManager() {
        IMatDataHandler data = IMatDataHandler.getInstance();
        List<ShoppingItem> items = new ArrayList<>();
        items.add(new ShoppingItem(data.getProduct(1), 3));
        items.add(new ShoppingItem(data.getProduct(2), 3));
        items.add(new ShoppingItem(data.getProduct(3), 7));
        items.add(new ShoppingItem(data.getProduct(4), 5));
        items.add(new ShoppingItem(data.getProduct(5), 4));
        currentList = new ShoppingList("Vardag", items);
        List<ShoppingItem> items2 = new ArrayList<>();
        items2.add(new ShoppingItem(data.getProduct(6), 3));
        items2.add(new ShoppingItem(data.getProduct(7), 3));
        items2.add(new ShoppingItem(data.getProduct(8), 7));
        items2.add(new ShoppingItem(data.getProduct(9), 5));
        items2.add(new ShoppingItem(data.getProduct(10), 4));
        availableLists.add(currentList);
        availableLists.add(new ShoppingList("Arabpack", items2));

    }

    public static ShoppingListManager getInstance() {
        return instance;
    }

    public void removeItemInCurrentList(ShoppingItem item) {
        currentList.removeItem(item);
    }

    public void addShoppingItemToCurrentShoppingList(Product p, double amount) {
        currentList.addItem(new ShoppingItem(p, amount));
    }

    public List<ShoppingList> getListOfShoppingLists() {
        return availableLists;
    }

    public ShoppingList getCurrentList() {
        return currentList;
    }

    public void setCurrentShoppingList(ShoppingList list) {
        if (!availableLists.contains(list)) {
            throw new IllegalArgumentException("Not possible to set an list that is not added to manager");
        }
        setCurrentShoppingList(availableLists.indexOf(list));
    }

    public void setCurrentShoppingList(int index) {
        if (availableLists.indexOf(currentList) != index) {
            currentList = availableLists.get(index);
            for(ShoppingListManagerListener listener : listeners) {
                listener.currentListChanged(currentList);;
            }
        }
    }

    public void addShoppingList(ShoppingList list) {
        if (list != null && !availableLists.contains(list)) {
            availableLists.add(list);
        }
    }

    public void addListener(ShoppingListManagerListener listener) {
        listeners.add(listener);
    }
}
