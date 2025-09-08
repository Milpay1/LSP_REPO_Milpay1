package org.howard.edu.lsp.assignment2;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class ETLPipeline {

    private static final String INPUT_PATH = "data/products.csv"
    private static final String OUTPUT_PATH = "data/transformed_products.csv"

    public static void main(String[] args) {
        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(INPUT_PATH);
        if (!inputFile.exists()) {
            System.err.println("ERROR: Input file not found at " + INPUT_PATH);
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
            PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH));
        ) {
            String header = reader.readLine();
            if (header == null || header.trim().isEmpty()) {
                writer.println("ProductID,Name,Price,Category,PriceRange");
                System.out.println("Input file is empty. Only header written to " + OUTPUT_PATH);
                return;
            }

            writer.println("ProductID,Name,Price,Category,PriceRange");

            String line;
            whlie((line = reader.readLine()) != null) {
                rowsRead++;
                String[] parts = line.split(",");

                if (parts.length < 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int productId = Integer.parseInt(parst[0].trim());
                    String name = parts[1].trim();
                    BigDecimal price = new BigDecimal(parts[2].trim());
                    String category = parts[3].trim();

                    name = name.toUpperCase();

                    BigDecimal originalPrice = price;
                    if (category.equalsIgnoreCase("Electronics")) {
                        price = price.multiply(new BigDecimal("0.90"));
                        price = price.setScale(2, RoundingMode.HALF_UP);
                    } else {
                        price = price.setScale(2, RoundingMode.HALF_UP);
                    }

                    if (category.equalsIgnoreCase("Electronics") && price.compareTo(new BigDecimal("500.00")) > 0) {
                        category = "Premium Electronics";
                    }

                    String priceRange;
                    if (price.compareTo(new BigDecimal("0.00")) >= 0 && price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("10.00")) > 0 && price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("100.00")) > 0 && price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium"
                    }

                    writer.printf("%d, %s, %.2f, %s, %s%n", productId, name, price.doubleValue(), category, priceRange);

                    rowsTransformed++;


                } catch (Exception e) {
                    rowsSkipped++;
                }
            }

        System.out.println("ETL Summary: ");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + OUTPUT_PATH);

        } catch (IOException e) {
            System.err.println("ERROR processing file: " + e.getMessage());
        }
// test changes

        
    }
}
