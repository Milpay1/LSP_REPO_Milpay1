package org.howard.edu.lsp.assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVWriter {
    private final String outputPath;

    public CSVWriter(String outputPath) {
        this.outputPath = outputPath;
    }

    public void writeProducts(List<Product> products) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            writer.println("ProductID,Name,Price,Category,PriceRange");
            for (Product product : products) {
                writer.printf("%d,%s,%.2f,%s,%s%n",
                        product.getProductId(),
                        product.getName(),
                        product.getPrice(),
                        product.getCategory(),
                        product.getPriceRange());
            }
        }
    }
}
