package org.example;

import java.util.Scanner;

public class CustomerService {
    private static Printer printer = (s -> System.out.println(s));
    private static Scanner scanner = new Scanner(System.in);
    private static final String DIVIDER = "----------------";

    public static void start() {
        startMenu();
    }

    private static void menu2(Product.Type type) {
        printer.print(DIVIDER);

        String productCategory = null;
        switch (type) {
            case BEAUTY -> productCategory = "'Косметические Товары'";
            case SPORT -> productCategory = "'Спортивные товары'";
        }
        printer.print("1. Показать список товаров " + productCategory + "." + "\n" +
                "2. Произвести поиск товаров по ключевому слову или части слова." + "\n" +
                "3. Выход в предыдущее меню.");

        printChoice();
        String clientInput = scanner.nextLine();

        switch (clientInput) {
            case "1" -> sellMenu(type);
            case "2" -> {
                printer.print("Введите слово для поиска: ");
                String clientInput2 = scanner.nextLine();
                try {
                    productMenu(Market.get().searchKeyWord(clientInput2, type));
                } catch (NullPointerException e) {
                    menu2(type); /// девайдер силний?
                }
            }
            case "3" -> startMenu();
        }

    }

    public static void productMenu(Product product) {
        if (product != null) {
            printer.print(DIVIDER);
        }
        printer.print(product.toString());
        printer.print("Хотите приобрести данный товар?" + "\n" +
                "1. да." + "\n" +
                "2. нет, вернуться в предыдущее меню.");
        printChoice();
        String clientInput = scanner.nextLine();
        switch (clientInput) {
            case "1" -> {
                printer.print("Поздравляем с покупкой! Перенаправляем в начальное меню");
                Market.get().buyProduct(product);
                startMenu();
            }
            case "2" -> menu2(product.getType());
        }
    }

    private static void startMenu() {
        printer.print(DIVIDER);
        printer.print("Добро пожаловать в наш магазин." + "\n" +
                "Наберите номер нужного вам действия или наберите '3' для завершения программы." + "\n" +
                "1. Открыть раздел 'Косметические товары'." + "\n" +
                "2. Открыть раздел 'Спортивные товары'."
        );
        printChoice();
        String clientInput = scanner.nextLine();
        switch (clientInput) {
            case "1" -> menu2(Product.Type.BEAUTY);
            case "2" -> menu2(Product.Type.SPORT);
            case "3" -> {
            }
        }
    }

    private static void sellMenu(Product.Type type) {
        printer.print(DIVIDER);
        Market.get().showTheList(type);
        printer.print("3. Вернуться в предыдущее меню.");
        printer.print("Выберите номер товара для подробной информации.");
        printChoice();
        String clientInput2 = scanner.nextLine();
        if (clientInput2.equals("3")) {
            menu2(type);
            return;
        }
        for (Product product : Market.get().getProducts()) {
            if (product.hashCode() == Integer.parseInt(clientInput2)) {
                productMenu(product);
                return;
            }
        }
        printer.print("Вы ввели неверный номер товара!");
        sellMenu(type);
    }

    private static void printChoice() {
        System.out.print("Ваш выбор: ");
    }
}
