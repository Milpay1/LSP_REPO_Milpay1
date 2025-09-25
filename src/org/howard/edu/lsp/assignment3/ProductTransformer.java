package org.howard.edu.lsp.assignment3;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductTransformer {
    public Product transform(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        // Transform name to uppercase
        product.setName(product.getName().toUpperCase());

        BigDecimal price = product.getPrice();
        if (product.getCategory() != null && product.getCategory().equalsIgnoreCase("Electronics")) {
            price = price.multiply(new BigDecimal("0.90")); // 10% discount
            }
        price = price.setScale(2, RoundingMode.HALF_UP);
        product.setPrice(price);
        

        if (product.getCategory() != null && product.getCategory().equalsIgnoreCase("Electronics") && price.compareTo(new BigDecimal("500.00")) > 0) {
            product.setCategory("Premium Electronic"); 
        }

        product.setPriceRange(computePriceRange(price));

        return product;

}

    private String computePriceRange(BigDecimal price) {
        if (price.compareTo(new BigDecimal("0.00")) >= 0 && price.compareTo(new BigDecimal("10.00")) <= 0) {
            return "Low";
        } else if (price.compareTo(new BigDecimal("10.01")) >= 0 && price.compareTo(new BigDecimal("100.00")) <= 0) {
            return "Medium";
        } else if (price.compareTo(new BigDecimal("100.01")) >= 0 && price.compareTo(new BigDecimal("500.00")) <= 0) {
            return "High";
        } else  {
            return "Premium";
        }
    }
}
