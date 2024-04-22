package org.example;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private static Market market;
    private List<Product> products = new ArrayList<>();

    private Market() {
    }

    public static Market get() {
        if (market == null) {
            market = new Market();
        }
        return market;
    }

    public Market putProduct(Product product) {
        products.add(product);
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void buyProduct(Product product) {
        products.remove(product);
    }

    public void showTheList(Product.Type type) {
        if (products.stream().filter(s -> s.getType().equals(type)).count() == 0) {
            System.out.println("Товаров данной категории больше нет! Ожидайте поступления.");
            return;
        }
        for (Product product : this.products) {
            if (type.equals(Product.Type.BEAUTY)) {
                if (product.getClass().equals(BeautyGood.class)) {
                    System.out.println("Номер товара: " + product.hashCode() + " Наименование: " + product.name);
                }
            } else if (type.equals(Product.Type.SPORT)) {
                if (product.getClass().equals(SportGood.class)) {
                    System.out.println("Номер товара: " + product.hashCode() + " Наименование: " + product.name);
                }
            }
        }
    }

    public Product searchKeyWord(String keyWord, Product.Type type) {
        for (Product product : products) {
            if (product.getType().equals(type)) {
                if (product.getName().contains(keyWord)) {
                    System.out.println("Товар в наличии!");
                    return product;
                } else if (product.getDescription().contains(keyWord)) {
                    System.out.println("Товар в наличии!");
                    return product;
                }
            }
        }
        System.out.println("К сожалению, товар отсутствует:(");
        return null;
    }
}
