package com.example.game7wa_in_progress;

import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
        Board board = new Board();
        System.out.println(board.getPlayerList());
        for (Player player : board.getPlayerList())
            System.out.println(player.getWonder().getName());
    }

    /* Commencer par Game
        - Créer Board (initialisation Player, Wonders, tous les attributs de Board)
        - Premier tour
            - Choix de deck
            - Choix d'action
            - Fin de tour et effets associés
        - Fin de jeu
        - Calcul de points

       Test unitaire = 1ère ligne dans ton main : lancement fonction test()
            test() = System.out.println("ton if en string" + résultat du if (ci dessous))
            exemple : System.out.println("Board correctement créé : " + if (Board créé == Board initialisé))
            if 1 test unitaire marche pas : test() renvoie false, et si false break; dans le main


       Test unitaires
        - Fichier "tests_unitaires"
        - List de ifs dans l'ordre (exemples)
            - Création board : if (Board créé == Board initialisé)
                (ce qui est affiché est ce que j'ai codé, exemple: bon nombre de joueurs, bonnes merveilles, etc)
            - Choix de deck : if (que 3 choix proposés) ou if (informations du deck du milieu non accessible)
                ou if (qu'une seule carte piochée par tour) ou if (3 choix proposés corrects)
            - Choix d'action / fin de tour : if (action possible, assez de ressources / VP)
                ou if (règle du jeu respectées)
        - Changement player : if (player 1 est le suivant de player 0 et player 0 suivant player 2)
        - Changement de tour : if (incrémentation de tour correcte et effets)
        - Calcul de points : if (calcul correct)
     */
}
