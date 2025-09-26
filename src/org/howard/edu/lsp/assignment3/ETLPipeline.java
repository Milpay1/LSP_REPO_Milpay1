package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Orchestrator for the ETL pipeline. Extracts from CSV, transforms products,
 * and writes the result to the output CSV. Prints a run summary.
 */
public class ETLPipeline {
    private static final String INPUT_PATH = "data/products.csv";
    private static final String OUTPUT_PATH = "data/transformed_products.csv";

    /**
     * Main entry point. Runs the ETL pipeline. Prints summary to stdout.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        CSVReader reader = new CSVReader(INPUT_PATH);
        CSVWriter writer = new CSVWriter(OUTPUT_PATH);
        ProductTransformer transformer = new ProductTransformer();

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        try {
            // === Extract ===
            List<Product> products = reader.readProducts();
            rowsRead = products.size();

            // === Transform ===
            List<Product> transformed = new ArrayList<>();
            for (Product p : products) {
                try {
                    transformed.add(transformer.transform(p));
                } catch (Exception e) {
                    rowsSkipped++;
                }
            }
            rowsTransformed = transformed.size();

            // Ensure output directory exists (data/ should exist per instructions, but be defensive)
            File outFile = new File(OUTPUT_PATH);
            File parent = outFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            // === Load ===
            writer.writeProducts(transformed);

            // === Summary ===
            System.out.println("ETL Summary:");
            System.out.println("Rows read: " + rowsRead);
            System.out.println("Rows transformed: " + rowsTransformed);
            System.out.println("Rows skipped: " + rowsSkipped);
            System.out.println("Output written to: " + OUTPUT_PATH);

        } catch (IOException e) {
            System.err.println("ERROR processing file: " + e.getMessage());
        }
    }
}
