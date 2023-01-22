package com.example.game7wa_in_progress;

import java.io.IOException;
import java.util.ArrayList;

public class Game {

    public static void main() throws IOException {

        //creation du Board
        Deck deck = new Deck();
        ArrayList<Player> playerList = new ArrayList<Player>();
        boolean onWards = true;
        int currentPlayer = 0; // players are 0,1,2

        //creation des players
        for (int i = 0; i < 3; i++)
            playerList.add(new Player(i));

        //distribution des Wonders et resources
        ArrayList<Wonder> WonderList = new ArrayList<Wonder>();

        for (String s : Wonder.WONDERS) {
            WonderList.add(new Wonder(s));
        }

        for (int i = 0; i < playerList.size(); i++) {
            int index = (int) (Math.random() * WonderList.size());
            playerList.get(i).setWonder(WonderList.remove(index));
            playerList.get(i).addToResources(playerList.get(i).getWonder().getProduct());

            // Modification de tour et de joueur
            getCurrentPlayer().setWonder(new Wonder("Halikarnassus"));
            getCurrentPlayer().addToResources(new Resources("Ore"));
            getCurrentPlayer().addToResources(new Resources("Ore"));
            getCurrentPlayer().addToResources(new Resources("Ore"));
            getCurrentPlayer().addToResources(new Resources("Clay"));
            getCurrentPlayer().addToResources(new Resources("Clay"));
        }
        Board board = new Board();

        //creation des tours


    }

    private static Player getCurrentPlayer() {
        return null;
    }
}


