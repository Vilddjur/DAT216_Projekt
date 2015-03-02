/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author mats
 */
public class MainProductCategory implements Category {
    private Name name;
    private List<Subcategory> subCategories = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        
        IMatDataHandler imat = IMatDataHandler.getInstance();
        for (Subcategory category : subCategories) {
            products.addAll(imat.getProducts(category.getProductCategory()));
        }
        
        return products;
    }
    
    public enum Name {
        FRUIT_AND_VEGETABLES,
        BREAD,
        CHARK,
        DIARIES,
        DRY,
        DRINKS_AND_SNACKS;
        
        public String toString() {
            switch (this) {
                case FRUIT_AND_VEGETABLES:
                    return "Frukt & grönt";
                case BREAD:
                    return "Bröd";
                case CHARK:
                    return "Chark";
                case DIARIES:
                    return "Mejeri";
                case DRY:
                    return "Torrvaror";
                case DRINKS_AND_SNACKS:
                    return "Dryck & snacks";
            }
            return "";
        }
    }
    
    public String toString() {
        return "Alla";
    }
    
    public String getName() {
        return name.toString();
    }
    
    public MainProductCategory(Name name) {
        this.name = name;
        
        switch (name) {
            case FRUIT_AND_VEGETABLES:
                subCategories.add(new Subcategory(ProductCategory.POD));
                subCategories.add(new Subcategory(ProductCategory.BERRY));
                subCategories.add(new Subcategory(ProductCategory.CABBAGE));
                subCategories.add(new Subcategory(ProductCategory.CITRUS_FRUIT));
                subCategories.add(new Subcategory(ProductCategory.EXOTIC_FRUIT));
                subCategories.add(new Subcategory(ProductCategory.FRUIT));
                subCategories.add(new Subcategory(ProductCategory.HERB));
                subCategories.add(new Subcategory(ProductCategory.MELONS));
                subCategories.add(new Subcategory(ProductCategory.NUTS_AND_SEEDS));
                subCategories.add(new Subcategory(ProductCategory.ROOT_VEGETABLE));
                subCategories.add(new Subcategory(ProductCategory.VEGETABLE_FRUIT));
                break;
            case BREAD:
                subCategories.add(new Subcategory(ProductCategory.BREAD));
                break;
            case CHARK:
                subCategories.add(new Subcategory(ProductCategory.FISH));
                subCategories.add(new Subcategory(ProductCategory.MEAT));
                break;
            case DIARIES:
                subCategories.add(new Subcategory(ProductCategory.DAIRIES));
                break;
            case DRY:
                subCategories.add(new Subcategory(ProductCategory.FLOUR_SUGAR_SALT));
                subCategories.add(new Subcategory(ProductCategory.PASTA));
                subCategories.add(new Subcategory(ProductCategory.POTATO_RICE));
                break;
            case DRINKS_AND_SNACKS:
                subCategories.add(new Subcategory(ProductCategory.SWEET));
                subCategories.add(new Subcategory(ProductCategory.COLD_DRINKS));
                subCategories.add(new Subcategory(ProductCategory.HOT_DRINKS));
                break;
        }
    }
    
    public List<Category> getSubcategories() {
        List<Category> categories = new ArrayList<>();
        for (Subcategory subCategory : subCategories) {
            categories.add((Category) subCategory);
        }
        return categories;
    }
}
