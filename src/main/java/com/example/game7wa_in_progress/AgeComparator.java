package com.example.game7wa_in_progress;

import java.util.Comparator;

public class AgeComparator implements Comparator<Player> {
    @Override
    public int compare(Player playerAge1, Player playerAge2) {
        return playerAge1.getAge() - playerAge2.getAge();
    }

}

