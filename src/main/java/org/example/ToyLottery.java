package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyLottery {
    private List<Toy> prizeToys;

    public ToyLottery() {
        prizeToys = new ArrayList<>();
    }

    public void addNewToy(Toy toy) {
        prizeToys.add(toy);
    }

    public void changeToyWeight(int toyId, double newWeight) {
        for (Toy toy : prizeToys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public Toy drawPrizeToy() {
        Random random = new Random();
        double totalWeight = 0;

        for (Toy toy : prizeToys) {
            totalWeight += toy.getWeight();
        }

        double randomNumber = random.nextDouble() * totalWeight;
        double currentWeight = 0;

        for (Toy toy : prizeToys) {
            currentWeight += toy.getWeight();
            if (randomNumber <= currentWeight) {
                prizeToys.remove(toy);
                return toy;
            }
        }

        return null; // No toy available
    }

    public void savePrizeToyToFile(Toy toy) {
        try {
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(toy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}