package org.example;

public class SportGood extends Product {
    public SportGood(int price, String name, String description, boolean is_WSO_Accepted, SportGood.playerLevel playerLevel, Type type) {
        super(price, name, description, type);
        this.is_WSO_Accepted = is_WSO_Accepted;
        this.playerLevel = playerLevel;
    }

    public static enum playerLevel {
        YOUTH, ADULT, SEMIPROFESSIONAL, PROFESSIONAL;
    }

    private boolean is_WSO_Accepted;
    private playerLevel playerLevel;

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Сертифицировано: " + (this.is_WSO_Accepted ? "да" : "нет") + "\n" +
                "Уровень экипировки : " +
                switch (this.playerLevel) {
                    case YOUTH -> "детский";
                    case ADULT -> "взрослый";
                    case SEMIPROFESSIONAL -> "продвинутый";
                    case PROFESSIONAL -> "профессиональный";
                };
    }

    public static class SportGoodBuilder extends ProductBuilder {
        private boolean is_WSO_Accepted;
        private playerLevel playerLevel;

        public SportGoodBuilder setIs_WSO_Accepted(boolean is_WSO_Accepted) {
            this.is_WSO_Accepted = is_WSO_Accepted;
            return this;
        }

        public SportGoodBuilder setPlayerLevel(SportGood.playerLevel playerLevel) {
            this.playerLevel = playerLevel;
            return this;
        }

        @Override
        public Product build() {
            return new SportGood(super.price, super.name, super.description, this.is_WSO_Accepted, this.playerLevel, super.type);
        }
    }

}
