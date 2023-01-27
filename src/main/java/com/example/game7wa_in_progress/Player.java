package com.example.game7wa_in_progress;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Player {
    private final String name;
    List<Card> inventory;
    public List<Card> piochePersonnelle;
    private int resources;
    private int victoryPoints;

    private Wonder chosenWonder;

    private int age;

    private int[][] progression;

    public Player(String name, int age, Wonder wonder) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.piochePersonnelle = new ArrayList<>();
        this.resources = 0;
        this.victoryPoints = 0;
        this.age = age ;
        this.chosenWonder = wonder;
    }

    public void drawCard(Card card) {
        inventory.add(card);
    }

    public void playCard(Card card) {
        inventory.remove(card);
    }

    public void gainResources(int resources) {
        this.resources += resources;
    }

    public void spendResources(int resources) {
        this.resources -= resources;
    }

    public void gainVictoryPoints(int victoryPoints) {
        this.victoryPoints += victoryPoints;
    }

    public String getName() {return name;}

    public int getAge() {return age;}

    public Wonder getWonder() {return chosenWonder;}
    public void setChosenDeck(Wonder c) {chosenWonder = c;}


}

