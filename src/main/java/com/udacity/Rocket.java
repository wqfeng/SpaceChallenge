package com.udacity;

public class Rocket implements SpaceShip {

    private int maxWeight;
    protected int weight;
    private int cost;

    public Rocket(int maxWeight, int weight, int cost) {
        this.maxWeight = maxWeight;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (this.weight + item.getWeight() > maxWeight){
            return false;
        }
        return true;
    }

    @Override
    public void carry(Item item) {
        this.weight += item.getWeight();

    }

    public int getCost() {
        return  this.cost;
    }
}
