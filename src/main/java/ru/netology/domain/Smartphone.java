package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
@Override
    public boolean matches(String text) {
        Product product = new Product();
        if (super.matches(text)) {
            return true;
        }
        if (getManufacturer().contains(text)) {
            return true;
        }
        return false;
    }
}
