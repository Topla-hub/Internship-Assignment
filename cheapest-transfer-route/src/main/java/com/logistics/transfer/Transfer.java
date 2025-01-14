package com.logistics.transfer;

public class Transfer {
    private int weight;
    private int cost;

    // Constructor
    public Transfer(int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }

    // Getters and Setters
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    // To String Method
    @Override
    public String toString() {
        return "Transfer{" +
                "weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
