package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ToyShop shop = new ToyShop();

        shop.addToy(1, "Конструктор", 5, 5);
        shop.addToy(2, "Робот", 5, 20);
        shop.addToy(3, "Кукла", 5, 75);

        //shop.setToyWeight(3, 5);

        shop.lotery();

        shop.getPrize();

    }
}