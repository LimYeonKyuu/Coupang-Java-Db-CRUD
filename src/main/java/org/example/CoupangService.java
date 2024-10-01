package org.example;

import lombok.Getter;

import java.util.List;

public class CoupangService {
    private CoupangRepository coupangRepository = new CoupangRepository();
    @Getter
    private List<Product> products;

    public CoupangService() {
        products = coupangRepository.loadProducts();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int id, String name, int price, int stock, String description) {
        Product product = findById(id);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            product.setDescription(description);
        }
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public Product findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public void saveProducts() {
        coupangRepository.save(products);
    }
}
