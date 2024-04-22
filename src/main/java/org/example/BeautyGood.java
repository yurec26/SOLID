package org.example;

public class BeautyGood extends Product {
    private boolean is_Animal_Tested;
    private boolean is_IHO_Certified;

    public BeautyGood(int price, String name, String description, Type type, boolean is_Animal_Tested, boolean is_IHO_Certified) {
        super(price, name, description, type);
        this.is_Animal_Tested = is_Animal_Tested;
        this.is_IHO_Certified = is_IHO_Certified;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Тестирование на жтвотных: " + (this.is_Animal_Tested ? "да" : "нет") + "\n" +
                "Сертифицировано: " + (this.is_IHO_Certified ? "да" : "нет");
    }

    public static class BeautyProductBuilder extends ProductBuilder {
        private boolean is_Animal_Tested;
        private boolean is_IHO_Certified;

        public BeautyProductBuilder setIs_Animal_Tested(boolean is_Animal_Tested) {
            this.is_Animal_Tested = is_Animal_Tested;
            return this;
        }

        public BeautyProductBuilder setIs_IHO_Certified(boolean is_IHO_Certified) {
            this.is_IHO_Certified = is_IHO_Certified;
            return this;
        }

        @Override
        public BeautyGood build() {
            return new BeautyGood(super.price, super.name, super.description, super.type, this.is_Animal_Tested, this.is_IHO_Certified);
        }
    }


}
