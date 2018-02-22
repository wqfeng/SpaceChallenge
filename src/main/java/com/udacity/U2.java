package com.udacity;

public class U2 extends Rocket{
    private static final int WEIGHT = 18;
    private static final int MAX_WEIGHT = 29;
    private static final int COST = 120;
    private final double CHANCE = 0.0002;


    public U2() {
        super(MAX_WEIGHT, WEIGHT, COST);
    }

    @Override
    public boolean launch() {
        double chance = 0.04 * (this.weight - WEIGHT) / (MAX_WEIGHT - WEIGHT);
        if(chance < CHANCE){
            return false;
        }
        return true;
    }

    @Override
    public boolean land() {
        double chance = 0.08 * (this.weight - WEIGHT) / (MAX_WEIGHT - WEIGHT);
        if(chance < CHANCE){
            return false;
        }
        return true;
    }

}
