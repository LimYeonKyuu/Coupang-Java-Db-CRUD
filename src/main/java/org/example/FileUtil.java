package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void writeProductsToFile(String filePath, List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(Product.nextId));
            writer.newLine();

            for (Product product : products) {
                writer.write(product.getId() + "|" + product.getName() + "|" + product.getPrice() + "|" + product.getStock() + "|" + product.getDescription());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readProductsFromFile(String filePath) {
        List<Product> products = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return products;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                Product.nextId = Integer.parseInt(line);
            }

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int price = Integer.parseInt(parts[2]);
                    int stock = Integer.parseInt(parts[3]);
                    String description = parts[4];
                    products.add(new Product(id, name, price, stock, description));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}
