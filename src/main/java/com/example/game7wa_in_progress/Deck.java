package com.example.game7wa_in_progress;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Deck {
    private ArrayList<Card> discard;

    public Deck() throws IOException {
        discard = new ArrayList<Card>();
        ///readInCards(new File("cards.txt"));
        shuffle(1);
        shuffle(2);
        shuffle(3);
//    	printall();
    }

    public Deck(ArrayList<Card> d) {
        discard = d;
    }
    public void setDiscard(ArrayList<Card> d) {
        discard = d;
    }

    public void addDiscard(Card c) {
        discard.add(c);
    }

    public void removeDiscard(Card c) {
        discard.remove(c);
    }

    public void draw(Player p, int age) {
    }

    /** Fisher-Yates Shuffle */
    public void shuffle(int age) {
            }



    public void readInCards(File file) throws IOException {
        Scanner scan = new Scanner(file);
        scan.nextLine();
        scan.nextLine();
        ArrayList<Card> guilds = new ArrayList<>();
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            if (!input.equals("DIVIDER TO CTRL-V")) {
                String[] temp = input.split("\\|");
//	            for(String s:temp)
//	            	System.out.print(s);
//	            System.out.println("\n"+temp[3]);
                System.out.println(temp.length);
                int age = Integer.parseInt(temp[3]);
                Card card = new Card(temp[0], temp[1], temp[2], temp[4], temp[5], temp[6]);
            }
        }
        Collections.shuffle(guilds);
        for (int i = 0; i < 5; i++)
//      System.out.println(ageOne);
        scan.close();
    }

    /*
    public static void main(String[] args) throws IOException {
        Deck deck = new Deck();
        for (Card card : deck.getAgeThree())
            System.out.println(card.getName());
    }

     */
}
