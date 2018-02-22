package com.udacity;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	Simulation simulation = new Simulation();
	List<Item> itemList1 = simulation.loadItems("/main/resources/phase-1.txt");
	List<Item> itemList2 = simulation.loadItems("/main/resources/phase-2.txt");

	int totalCost = simulation.runSimulation(simulation.loadU1(itemList1));
	totalCost += simulation.runSimulation(simulation.loadU1(itemList2));

	System.out.println("With U1 rocket, the total cost is $" + totalCost + " millions.");


	int totalCost2 = simulation.runSimulation(simulation.loadU2(itemList1));
	totalCost2 += simulation.runSimulation(simulation.loadU2(itemList2));

	System.out.println("With U2 rocket, the total cost is $" + totalCost2 + " millions.");

    }
}
