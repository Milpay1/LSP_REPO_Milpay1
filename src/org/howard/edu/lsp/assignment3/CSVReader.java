package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private final String inputPath;

    public CSVReader(String inputPath) {
        this.inputPath = inputPath;
    }

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
                }
        }
    }
    return products;
    }
}
