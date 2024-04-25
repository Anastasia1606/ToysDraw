package org.example.controller;

import org.example.model.Toy;
import org.example.model.ToysDraw;
import org.example.view.ViewConsole;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private ViewConsole view;

    public Controller() {
        view = new ViewConsole();
    }

    ArrayList<Toy> generateData() {

        ArrayList<Toy> toys = new ArrayList<>();
        toys.add(new Toy(1, "Мишка", 10, 45.5));
        toys.add(new Toy(2, "Зайчик", 20, 30.0));
        toys.add(new Toy(3, "Кукла", 10, 24.5));

        return toys;
    }

    public void WriteReceivedPrizeInFile(Toy toy) throws IOException {

        FileWriter writer = new FileWriter("ReceivedPrizes.txt", true);
        writer.write(toy.getName()+ "\n");
        writer.close();
    }
    public void start()  {
        try {
            ArrayList<Toy> toysArr = generateData();
            ToysDraw toys = new ToysDraw(toysArr);
            toys.controlGeneralWeight();
            for (int i = 0; i < 5; i++) {
                toys.roll();
            }
            WriteReceivedPrizeInFile(toys.getPrize());

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            view.printMsg(e.getMessage());
        }

    }






}
