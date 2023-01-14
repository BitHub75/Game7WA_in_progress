package com.example.game7wa_in_progress;

import java.util.ArrayList;

public class Card implements Comparable {
    private String name;
    private ArrayList<Resources> cost; // Resource cost
    private String chain; // holds NAME of card that card chains from
    private boolean isFree;
    private String type; // also color
    private String effect;

    public Card(String scientistsguild, String purple, String sAll, int i, String s, String aFalse, String s1) {
        this("", "", "", "", "false", "");
    }

    public Card(String name, String color, String effect, String chain, String isFree, String cost) {
        this.name = name;
        this.type = color.toLowerCase();
        this.chain = chain; // if no chain String is " "
        this.effect = effect;

        this.cost = new ArrayList<Resources>();
        String[] temp = cost.split(",");

        for (int i = 0; i < temp.length; i++)
            this.cost.add(new Resources(temp[i]));

        this.isFree = isFree.equals("true");
    }

    public int compareTo(Object obj) {
        Card card = (Card) obj;
        if (getType().compareTo(card.getType()) > 0)
            return 1;
        else if (getType().compareTo(card.getType()) < 0)
            return -1;
        else if (getName().compareTo(card.getName()) > 0)
            return 1;
        else if (getName().compareTo(card.getName()) < 0)
            return -1;
        return 0;
    }

    public String toString() {
        return getName() + ", " + getEffect();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Resources> getCost() {
        return cost;
    }

    public void setCost(ArrayList<Resources> cost) {
        this.cost = cost;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getStats() {
        return "Name: " + getName() + " Cost: " + getCost() + " Chain: " + getChain() + " isFree: " + isFree()
                + " type: " + getType() + " effect: " + getEffect();
    }
}