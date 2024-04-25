package org.example.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class ToysDraw {

    private ArrayList<Toy> toys;
    private Random rnd;
    private Queue<Toy> queue;
    public ToysDraw(ArrayList<Toy> toys) {
        this.toys = toys;
        rnd = new Random();
        queue = new ArrayDeque<>();
    }

    public void controlGeneralWeight() throws Exception {
        double generalWeight = 0.0;
        for  (Toy toy : toys) {
            generalWeight += toy.getWeight();
        }
        if (generalWeight != 100.0) {
            throw new Exception("Общая вероятность выпадения игрушек должна быть равна 100%");
        }
    }

    public void roll() throws Exception {

        double r = rnd.nextDouble();
        double p = 0;

        for (Toy toy : toys) {
            double curWeight = toy.getWeight()/100.0;
            if (p <= r && r < p + curWeight)
                if (toy.getCount() ==0 ) {
                    throw new Exception("Закончились запасы игрушки "+toy);
                }
                else {
                    toy.decrementCount();
                    queue.add(toy);
                }
            p = p + curWeight;
        }
    }

    public Toy getPrize() {

        return queue.poll();

    }

}
