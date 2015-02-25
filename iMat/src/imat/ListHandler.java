/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author Oskar
 */
public class ListHandler {
    final IMatDataHandler handler = IMatDataHandler.getInstance();
    
    public List<Product> getProducts(String s){
        if(s == null){
            return handler.getProducts();
        }
        List<Product> list = new ArrayList<>();
        switch(s){
            case "FoG"://Frukt och grönt
                list.addAll(handler.getProducts(ProductCategory.POD));
                list.addAll(handler.getProducts(ProductCategory.BERRY));
                list.addAll(handler.getProducts(ProductCategory.CABBAGE));
                list.addAll(handler.getProducts(ProductCategory.CITRUS_FRUIT));
                list.addAll(handler.getProducts(ProductCategory.EXOTIC_FRUIT));
                list.addAll(handler.getProducts(ProductCategory.FRUIT));
                list.addAll(handler.getProducts(ProductCategory.HERB));
                list.addAll(handler.getProducts(ProductCategory.MELONS));
                list.addAll(handler.getProducts(ProductCategory.NUTS_AND_SEEDS));
                list.addAll(handler.getProducts(ProductCategory.ROOT_VEGETABLE));
                list.addAll(handler.getProducts(ProductCategory.VEGETABLE_FRUIT));
                break;
            case "Chark"://Chark
                list.addAll(handler.getProducts(ProductCategory.FISH));
                list.addAll(handler.getProducts(ProductCategory.MEAT));
                break;
            case "Bröd"://Bröd
                list.addAll(handler.getProducts(ProductCategory.BREAD));
                break;
            case "Mejeri"://Mejeri
                list.addAll(handler.getProducts(ProductCategory.DAIRIES));
                break;
            case "Torr"://Torrvaror
                list.addAll(handler.getProducts(ProductCategory.FLOUR_SUGAR_SALT));
                list.addAll(handler.getProducts(ProductCategory.PASTA));
                list.addAll(handler.getProducts(ProductCategory.POTATO_RICE));
                break;
            case "DS"://Dryck/Snacks
                list.addAll(handler.getProducts(ProductCategory.SWEET));
                list.addAll(handler.getProducts(ProductCategory.COLD_DRINKS));
                list.addAll(handler.getProducts(ProductCategory.HOT_DRINKS));
        }
        Collections.sort(list, new Comparator<Product>(){//Sortera alfabetiskt
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return list;
        
    }
    /**
     *
     * @param pc
     * @return
     */
    public List<Product> getProducts(ProductCategory pc){
        return handler.getProducts(pc);
    }
    
    public List<String> getLists(String s){
        List<String> list = new ArrayList<>();
        list.add("ALLA");
        
        switch(s){
            case "FoG"://Frukt och grönt
                list.add("    Baljväxter");
                list.add("    Bär");
                list.add("    Kål");
                list.add("    Citrusfrukter");
                list.add("    Exotiskafrukter");
                list.add("    Örtkryddor");
                list.add("    Meloner");
                list.add("    Nötter och Frön");
                list.add("    Rotfrukter");
                list.add("    Grönsaksfrukter");              
                break;
            case "Chark"://Chark
                list.add("    Kött");
                list.add("    Fisk");
                break;
            case "Bröd"://Bröd
                break;
            case "Mejeri"://Mejeri
                break;
            case "Torr"://Torrvaror
                list.add("    Mjöl, socker, salt");
                list.add("    Pasta");
                list.add("    Potatis och ris");
                break;
            case "DS"://Dryck/Snacks
                list.add("    Sötsaker");
                list.add("    Kalla drycker");
                list.add("    Varma drycker");
                break;
        }
        return list;
    }

    ProductCategory parseString(String p) {
        if(p == "    Baljväxter"){
            return ProductCategory.POD;
        }else if(p == "    Bär"){
            return ProductCategory.BERRY;
        }else if(p == "    Kål"){
            return ProductCategory.CABBAGE;
        }else if(p == "    Citrusfrukter"){
            return ProductCategory.CITRUS_FRUIT;
        }else if(p == "    Exotiskafrukter"){
            return ProductCategory.EXOTIC_FRUIT;
        }else if(p == "    Örtkryddor"){
            return ProductCategory.HERB;
        }else if(p == "    Meloner"){
            return ProductCategory.MELONS;
        }else if(p == "    Nötter och Frön"){
            return ProductCategory.NUTS_AND_SEEDS;
        }else if(p == "    Rotfrukter"){
            return ProductCategory.ROOT_VEGETABLE;
        }else if(p == "    Grönsaksfrukter"){
            return ProductCategory.VEGETABLE_FRUIT;
        }else if(p == "    Kött"){
            return ProductCategory.MEAT;
        }else if(p == "    Fisk"){
            return ProductCategory.FISH;
        }else if(p == "    Mjöl, socker, salt"){
            return ProductCategory.FLOUR_SUGAR_SALT;
        }else if(p == "    Pasta"){
            return ProductCategory.PASTA;
        }else if(p == "    Potatis och ris"){
            return ProductCategory.POTATO_RICE;
        }else if(p == "    Sötsaker"){
            return ProductCategory.SWEET;
        }else if(p == "    Kalla drycker"){
            return ProductCategory.COLD_DRINKS;
        }else if(p == "    Varma drycker"){
            return ProductCategory.HOT_DRINKS;
        }
        
        return null;
    }
}
