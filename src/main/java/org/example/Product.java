package org.example;

public class Product {
    protected int price;
    protected String name;
    protected String description;
    private Type type;

    public static enum Type {
        BEAUTY, SPORT;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Product(int price, String name, String description, Type type) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    @Override
    public int hashCode() {
        return this.name.charAt(0) + this.description.charAt(0);
    }

    @Override
    public String toString() {
        return "Информация по выбранному товару : " + "\n" +
                "цена: " + price + " рублей." + "\n" +
                "Наименование: " + name + "\n" +
                "Краткое описание: " + description;
    }

    public static class ProductBuilder {
        protected int price;
        protected String name;
        protected String description;
        protected Type type;


        public ProductBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setType(Type type) {
            this.type = type;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            return new Product(this.price, this.name, this.description, this.type);
        }
    }
}
