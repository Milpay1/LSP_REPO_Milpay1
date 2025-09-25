package org.howard.edu.lsp.assignment3;
import java.math.BigDecimal;
public class Product {
    private final int productId;
    private  String name;
    private  BigDecimal price;
    private  String category;
    private  String priceRange;

    public Product(int productId, String name, BigDecimal price, String category, String priceRange) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = priceRange;
    }

    public int getProductId() {
        return productId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getPriceRange() {
        return priceRange;
    }
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
    

}
