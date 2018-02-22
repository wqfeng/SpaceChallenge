package com.udacity;

public class U1 extends Rocket{
    private static final int WEIGHT = 10;
    private static final int MAX_WEIGHT = 18;
    private static final int COST = 100;
    private final double CHANCE = 0.00002;


    public U1() {
        super(MAX_WEIGHT, WEIGHT, COST);
    }

    @Override
    public boolean launch() {
        double chance = 0.05 * (this.weight - WEIGHT)  / (MAX_WEIGHT - WEIGHT);
        System.out.println("launch chance" + chance);
        if(chance > Math.random()){
            return false;
        }
        return true;
    }

    @Override
    public boolean land() {
        double chance = 0.01 * (this.weight - WEIGHT) / (MAX_WEIGHT - WEIGHT);
        System.out.println("land chance" + chance);
        if(chance > Math.random()){
            return false;
        }
        return true;
    }

}
