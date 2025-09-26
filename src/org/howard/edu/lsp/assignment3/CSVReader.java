package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for reading product data from a CSV file.
 * This class handles the "Extract" stage of the ETL pipeline.
 */
public class CSVReader {
    private final String inputPath;

    /**
     * Constructs a CSVReader with the given input file path.
     *
     * @param inputPath the relative or absolute path of the CSV file
     *                  containing raw product data
     */
    public CSVReader(String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * Reads product data from the configured CSV file and converts each valid
     * row into a {@link Product} object. Malformed or empty lines are skipped.
     *
     * @return a list of {@link Product} objects extracted from the CSV
     * @throws IOException if an error occurs while reading the file
     * @throws FileNotFoundException if the input file does not exist
     */
    public List<Product> readProducts() throws IOException {
        File f = new File(inputPath);
        if (!f.exists()) {
            throw new FileNotFoundException("Input file not found at " + inputPath);
        }

        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String header = br.readLine();
            if (header == null || header.trim().isEmpty()) {
                return products; // Return empty list if file is empty
            }

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    continue; // Skip malformed lines
                }
                try {
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    BigDecimal price = new BigDecimal(parts[2].trim());
                    String category = parts[3].trim();
                    products.add(new Product(productId, name, price, category, ""));
                } catch (NumberFormatException e) {
                    // Skip rows with invalid numeric fields
                }
            }
        }
        return products;
    }
}
