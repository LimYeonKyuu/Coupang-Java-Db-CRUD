package org.example;

import lombok.Getter;

import java.util.List;

public class CoupangService {
    private CoupangRepository coupangRepository = new CoupangRepository();


    public void addProduct(Product product) {
        coupangRepository.addProduct(product);
    }

    public void updateProduct(int id, String name, int price, int stock, String description) {
        coupangRepository.updateProduct(id, name, price, stock, description);
    }

    public void deleteProduct(int id) {
        coupangRepository.deleteProduct(id);
    }

    public List<Product> getProducts() {
        return coupangRepository.findAll();
    }
}
