/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author mats
 */
public enum MainProductCategory {
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
    
    public List<ProductCategoryWrapper> getSubcategories() {
        List<ProductCategoryWrapper> categories = new ArrayList<>();
        
        switch (this) {
            case FRUIT_AND_VEGETABLES:
                categories.add(new ProductCategoryWrapper(ProductCategory.POD));
                categories.add(new ProductCategoryWrapper(ProductCategory.BERRY));
                categories.add(new ProductCategoryWrapper(ProductCategory.CABBAGE));
                categories.add(new ProductCategoryWrapper(ProductCategory.CITRUS_FRUIT));
                categories.add(new ProductCategoryWrapper(ProductCategory.EXOTIC_FRUIT));
                categories.add(new ProductCategoryWrapper(ProductCategory.FRUIT));
                categories.add(new ProductCategoryWrapper(ProductCategory.HERB));
                categories.add(new ProductCategoryWrapper(ProductCategory.MELONS));
                categories.add(new ProductCategoryWrapper(ProductCategory.NUTS_AND_SEEDS));
                categories.add(new ProductCategoryWrapper(ProductCategory.ROOT_VEGETABLE));
                categories.add(new ProductCategoryWrapper(ProductCategory.VEGETABLE_FRUIT));
                break;
            case BREAD:
                categories.add(new ProductCategoryWrapper(ProductCategory.BREAD));
                break;
            case CHARK:
                categories.add(new ProductCategoryWrapper(ProductCategory.FISH));
                categories.add(new ProductCategoryWrapper(ProductCategory.MEAT));
                break;
            case DIARIES:
                categories.add(new ProductCategoryWrapper(ProductCategory.DAIRIES));
                break;
            case DRY:
                categories.add(new ProductCategoryWrapper(ProductCategory.FLOUR_SUGAR_SALT));
                categories.add(new ProductCategoryWrapper(ProductCategory.PASTA));
                categories.add(new ProductCategoryWrapper(ProductCategory.POTATO_RICE));
                break;
            case DRINKS_AND_SNACKS:
                categories.add(new ProductCategoryWrapper(ProductCategory.SWEET));
                categories.add(new ProductCategoryWrapper(ProductCategory.COLD_DRINKS));
                categories.add(new ProductCategoryWrapper(ProductCategory.HOT_DRINKS));
                break;
        }
        
        return categories;
    }
}
