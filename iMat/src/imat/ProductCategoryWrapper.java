/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author mats
 */
public class ProductCategoryWrapper {
    private ProductCategory category;
    
    public ProductCategoryWrapper(ProductCategory category) {
        this.category = category;
    }
    
    public ProductCategory getProductCategory() {
        return this.category;
    }
    
    public String toString() {
        switch (category) {
            case POD:
                return "Baljväxter";
            case BREAD:
                return "Bröd";
            case BERRY:
                return "Bär";
            case CITRUS_FRUIT:
                return "Citrusfrukter";
            case HOT_DRINKS:
                return "Varma drycker";
            case COLD_DRINKS:
                return "Kalla drycker";
            case EXOTIC_FRUIT:
                return "Exotiska frukter";
            case FISH:
                return "Fisk";
            case VEGETABLE_FRUIT:
                return "Grönsaksfrukter";
            case CABBAGE:
                return "Kål";
            case MEAT:
                return "Kött";
            case DAIRIES:
                return "Mejeriprodukter";
            case MELONS:
                return "Meloner";
            case FLOUR_SUGAR_SALT:
                return "Mjöl, socker, salt";
            case NUTS_AND_SEEDS:
                return "Nötter och frön";
            case PASTA:
                return "Pasta";
            case POTATO_RICE:
                return "Potatis, ris";
            case ROOT_VEGETABLE:
                return "Rotfrukter";
            case FRUIT:
                return "Stenfrukter";
            case SWEET:
                return "Sötsaker";
            case HERB:
                return "Örtkryddor";
        }
        return "";
    }
}
