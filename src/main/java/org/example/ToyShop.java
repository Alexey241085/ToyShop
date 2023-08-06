package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ToyShop {

    private ArrayList<Toy> toys = new ArrayList<>();
    private  ArrayList<Toy> prize = new ArrayList<>();

    public void addToy (int id, String name, int quantity, double weight){
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void setToyWeight (int id, double weight){
        for (Toy toy : toys) {
            if (toy.getId() == id){
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void lotery(){
        // всчитываем общий вес игрушек
        double totalWeight = 0;
        for (Toy i : toys) {
            totalWeight = totalWeight + i.getWeight();
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;
        // ищем призовую игрушку
        Toy prizeToy = null;
        for (Toy i : toys) {
            if (randomNumber < i.getWeight()){
                prizeToy = i;
                break;
            }
            randomNumber = randomNumber - i.getWeight();
        }
        // добовляем призовую игрушку в список призов
        if (prizeToy != null && prizeToy.getQuantity() > 0){
            prize.add(prizeToy);

            // уменьшаем количество игрушек на 1
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);

        }
    }

    public  void getPrize() throws IOException {
        if (prize.size() > 0){
            Toy prizeToy = prize.remove(0);

            //Записываем приз в файл
            FileWriter writer = new FileWriter("prize.txt", true);
            writer.write(prizeToy.getId() + " , " + prizeToy.getName() + "\n");
            writer.close();
        }
    }
}
