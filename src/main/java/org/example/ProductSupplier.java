package org.example;

public class ProductSupplier {
    public static void supply(Market market) {
        BeautyGood.BeautyProductBuilder beautyBuilder = new BeautyGood.BeautyProductBuilder();
        SportGood.SportGoodBuilder sportBuilder = new SportGood.SportGoodBuilder();

        Product eyeliner = beautyBuilder.setIs_Animal_Tested(false).setIs_IHO_Certified(true).setName("Подводка для глаз")
                .setDescription("Попробуй нашу новую разработку!")
                .setPrice(1000).setType(Product.Type.BEAUTY).build();
        Product shampoo = beautyBuilder.setIs_Animal_Tested(true).setIs_IHO_Certified(false).setName("Шампунь 'Биба и Боба'")
                .setDescription("Купи наш шампунь, не будь как Бмба и Боба!")
                .setPrice(1500).setType(Product.Type.BEAUTY).build();

        Product basketball = sportBuilder.setIs_WSO_Accepted(true).setPlayerLevel(SportGood.playerLevel.SEMIPROFESSIONAL).setName("Мяч для баскетбола")
                .setDescription("Оригинальный мяч, натуральная кожа").setPrice(2600).setType(Product.Type.SPORT).build();

        Product runningShoes = sportBuilder.setIs_WSO_Accepted(false).setPlayerLevel(SportGood.playerLevel.YOUTH).setName("Беговые кроссовки")
                .setDescription("Детские кроссовки 26 размера, для длительных дистанций").setPrice(18000).setType(Product.Type.SPORT).build();

        market.putProduct(eyeliner).putProduct(shampoo).putProduct(basketball).putProduct(runningShoes);
    }
}
