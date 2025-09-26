package org.howard.edu.lsp.assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Responsible for writing transformed {@link Product} data
 * to a CSV file. This class handles the "Load" stage of the ETL pipeline.
 */
public class CSVWriter {
    private final String outputPath;

    /**
     * Constructs a CSVWriter with the given output file path.
     *
     * @param outputPath the relative or absolute path of the CSV file
     *                   where transformed products will be written
     */
    public CSVWriter(String outputPath) {
        this.outputPath = outputPath;
    }

    /**
     * Writes a list of {@link Product} objects to the configured output CSV file.
     * Each product is written as a row with the following columns:
     * ProductID, Name, Price, Category, and PriceRange.
     *
     * @param products the list of products to write
     * @throws IOException if an error occurs while writing to the file
     */
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
