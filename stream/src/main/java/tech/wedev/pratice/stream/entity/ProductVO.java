package tech.wedev.pratice.stream.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductVO implements Serializable {

    private String Name;

    private String brand;

    private double price;

    public double getPrice() {
        return price;
    }
}

