package org.example;

import java.util.List;

public class CoupangRepository {
    private static final String FILE_PATH = "products.txt";

    public void save(List<Product> products) {
        FileUtil.writeProductsToFile(FILE_PATH, products);
    }

    public List<Product> loadProducts() {
        return FileUtil.readProductsFromFile(FILE_PATH);
    }
}
