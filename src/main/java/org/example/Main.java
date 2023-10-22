package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        ToyLottery toyLottery = new ToyLottery();

        Toy toy1 = new Toy(1, "Teddy Bear", 10, 30);
        Toy toy2 = new Toy(2, "Lego Set", 5, 20);
        Toy toy3 = new Toy(3, "Doll", 8, 15);

        toyLottery.addNewToy(toy1);
        toyLottery.addNewToy(toy2);
        toyLottery.addNewToy(toy3);

        toyLottery.changeToyWeight(1, 40);

        Toy prizeToy = toyLottery.drawPrizeToy();
        if (prizeToy != null) {
            toyLottery.savePrizeToyToFile(prizeToy);
            prizeToy.getQuantity();
        }
    }
}