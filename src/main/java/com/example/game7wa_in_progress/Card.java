package com.example.game7wa_in_progress;

import java.util.ArrayList;

public class Card {
    public final CardType front;
    public final CardBack back;

    public Card(CardType front, CardBack back) {
        this.front = front;
        this.back = back;
    }

    public void displayCard(){
        System.out.println("############\n" +
                "front : " + front +"\n" +
                "back : " + back +"\n############");
    }

}