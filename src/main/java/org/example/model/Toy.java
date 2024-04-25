package org.example.model;

public class Toy {
    private int id;
    private String name;
    private int count;
    private double weight;
    public Toy (int id, String name, int count, double weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }
    public double getWeight() {
        return weight;
    }

    public void addCount(int count) {
        this.weight += count;
    }

    public void decrementCount() {
        this.weight --;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name +
                "(id=" + id +
                ", частота выпадения=" + weight +"%)";
    }



}
