package com.udacity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Simulation {
    public List<Item> loadItems(String fileName) {
        List<Item> list = new ArrayList<Item>();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(Simulation.class.getResourceAsStream(fileName))));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] array = line.split("=");
            Item item = new Item(array[0], Integer.parseInt(array[1])/1000);
            list.add(item);
        }

        return list;

    }

    public List<Rocket> loadU1(List<Item> itemList) {
        List<Rocket> rocketList = new ArrayList<Rocket>();
        U1 u1 = new U1();
        for (Item item: itemList) {
            if (u1.canCarry(item)) {
                u1.carry(item);
            }
            else {
                rocketList.add(u1);
                u1 = new U1();
                u1.carry(item);
            }
        }

        return rocketList;
    }

    public List<Rocket> loadU2(List<Item> itemList) {
        List<Rocket> rocketList = new ArrayList<Rocket>();
        U2 u2 = new U2();
        for (Item item: itemList) {
            if (u2.canCarry(item)) {
                u2.carry(item);
            }
            else {
                rocketList.add(u2);
                u2 = new U2();
                u2.carry(item);
            }
        }

        return rocketList;
    }

    public int runSimulation(List<Rocket> rocketList) {
        int totalCost = 0;
        for (Rocket r: rocketList) {
            // keep trying if not launch
            while(!r.launch()) {
                totalCost += r.getCost();
            }
            while(!r.land()){
                totalCost += r.getCost();
                // have to launch a new one if not land.
                while (!r.launch()) {
                    totalCost += r.getCost();
                }
            }
            // finally succeed!
            totalCost += r.getCost();
        }

        return totalCost;

    }
}
