package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Product {
    public static int nextId = 1;
    private int id;
    private String name;
    private int price;
    private int stock;
    private String description;
}
