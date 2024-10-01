package org.example;

import java.util.List;

public class CoupangController {
    private CoupangService coupangService = new CoupangService();

    public void addProduct(String name, int price, int stock, String description) {
        coupangService.addProduct(Product.builder().
                id(Product.nextId++).
                name(name).
                price(price).
                stock(stock).
                description(description)
                .build());
    }

    public void viewProducts() {
        System.out.println("상품 목록");
        List<Product> products = coupangService.getProducts();
        String format = "%-5s %-13s %-10s %-7s %-30s%n";
        System.out.printf(format, "ID", "Name", "Price", "Stock", "Description");

        for (Product product : products) {
            System.out.printf(format, product.getId(), product.getName(), product.getPrice(), product.getStock(), product.getDescription());
        }
    }

    public void updateProduct(int id, String name, int price, int stock, String description) {
        coupangService.updateProduct(id, name, price, stock, description);
    }

    public void deleteProduct(int id) {
        coupangService.deleteProduct(id);
    }

    public void saveProducts() {
        coupangService.saveProducts();
    }
}
