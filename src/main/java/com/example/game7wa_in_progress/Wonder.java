package com.example.game7wa_in_progress;

import java.util.List;

import static com.example.game7wa_in_progress.CardDecks.*;

public enum Wonder {

    EmptyDeck("Empty","Default deck", emptyDeck ,true),

    Alexandrie("Alexandrie",
            "Prenez la première carte d'une pioche au choix, n'importe où sur la table, et posez-la devant vous",
            deckCardQuantities_Alexandrie, true),
    Halicarnasse("Halicarnasse",
            "Prenez les 5 premières cartes de la pioche à votre gauche ou à votre droite, choisissez-en 1 et posez-la devant vous"
                    + "Mélangez-les cartes restantes dans leur pioche",deckCardQuantities_Halicarnasse, true),

    Ephese("Ephese",
            "Prenez la première carte de la pioche centrale et posez-la devant vous",deckCardQuantities_Ephese, true),

    Olympie("Olympie",
            "Prenez la première carte de la pioche à votre gauche et de celle à votre droite, et posez-les devant vous",
            deckCardQuantities_Olympie, true),

    Babylone("Babylone",
            "Choisissez 1 jeton Progrès parmi les 4 disponibles, et posez-le devant vous",
            deckCardQuantities_Babylon, true),

    Rhodes("Rhodes",
            "Ajoutez 1 Bouclier à votre total de Boucliers",deckCardQuantities_Rhodes, true),

    Gizeh("Gizeh",
            "Cette merveille n'a pas d'effet particulier, mais rapporte plus de points de victoire que les autres Merveilles",
            deckCardQuantities_Gizeh, true);

    // ------------------------------------------------------------------------

    public final String displayName;


    public final String effectDescription;

    public final List<CardDecks.CardTypeQuantity> cardDeck;
    public Boolean available;

    Wonder(String displayName, String effectDescription, List<CardTypeQuantity> cardDeck, boolean available) {
        this.displayName = displayName;

        this.effectDescription = effectDescription;
        this.cardDeck=cardDeck;
        this.available = available;
    }
    public Boolean getAvailable() {return available;}
    public void setAvailableFalse() {available = false;}
}


