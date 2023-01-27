package com.example.game7wa_in_progress;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    static Random random = new Random();
    public static ArrayList<Player> playerListGame =new ArrayList<>();
    private static Wonder wondersSelect;
    Player arthur = new Player("Test0",15,Wonder.Alexandrie);

    Player matteo = new Player("Test1",15,Wonder.Gizeh);
    public static void main(String[] args) {
        Player arthur = new Player("arthur",15,Wonder.Alexandrie);

        Player matteo = new Player("matteo",15,Wonder.Gizeh);
        playerListGame.add(arthur);
        playerListGame.add(matteo);

        gameInitialisation(playerListGame); /** On génère les les joueurs. Ils sélectionnent une merveille et se voient attribué une pioche*/

        Player joueur = playerListGame.get(0);
        drawCard(joueur.piochePersonnelle, joueur);
        drawCard(joueur.piochePersonnelle, joueur);
        System.out.println("Wonder en cours : " + joueur.getWonder());
        for(Card c : joueur.inventory){
            System.out.println(c.front);
        }
        Scanner scanner = new Scanner(System.in);
        while(true){
            drawCard(joueur.piochePersonnelle, joueur);
            System.out.println("Indication paquet:");
            for(Card c : joueur.inventory){
                System.out.println(c.front);
            }
            int test = scanner.nextInt();
            verificationConstruction(joueur);
            test = scanner.nextInt();
        }

    }

    public static void importDeckCard(Wonder wonder, Player player) {
        player.piochePersonnelle = triCarte(wonder);
    }

    public static ArrayList<Card> triCarte(Wonder wonder){
        ArrayList<Card> listeCarte = new ArrayList<>();
        for(CardDecks.CardTypeQuantity cardTypeQuantity : wonder.cardDeck){
            for (int i = 0; i < cardTypeQuantity.quantity ; i++){
                listeCarte.add(new Card(cardTypeQuantity.cardType, cardTypeQuantity.cardBack));
            }
        }
        for(int tri = 0 ; tri<500 ; tri++){
            Card carteAMelanger = listeCarte.get(0);
            listeCarte.remove(0);
            int randomTriCarte = random.nextInt(listeCarte.size());
            listeCarte.add(randomTriCarte, carteAMelanger);
        }
        return listeCarte;
    }

    public static void gameInitialisation(ArrayList<Player> playerList) {
        int idAgeMin=0;
        int ageMin=playerList.get(0).getAge();
        for(int i=1; i < playerList.size(); i++){
            if(playerList.get(i).getAge()<ageMin){
                idAgeMin = i;
            }
        }
        for(int i=0; i<idAgeMin; i++){
            playerList.add(playerList.get(0));
            playerList.remove(0);
        }
        System.out.println("""
                ##############Resume game settings##############

                Game turn order whit resume of wonders selected :
                """);
        for(Player player : playerList) {
            importDeckCard(player.getWonder(), player);
            System.out.println(player.getName() + " with wonder deck : " + player.getWonder());
        }
    }

    public static void availableDecks() {
        List<Wonder> availableDecksList = new ArrayList<>();
        availableDecksList.add(Wonder.Alexandrie);
        availableDecksList.add(Wonder.Babylone);
        availableDecksList.add(Wonder.Ephese);
        availableDecksList.add(Wonder.Gizeh);
        availableDecksList.add(Wonder.Halicarnasse);
        availableDecksList.add(Wonder.Olympie);
        availableDecksList.add(Wonder.Rhodes);
        for(int i = 0; i< availableDecksList.size(); i++) {
            if(availableDecksList.get(i).getAvailable()) {
                System.out.println("[" + (i+1) + "]: " + availableDecksList.get(i) + " : available");
            }
            else {
                System.out.println("[" + (i+1) + "]: " + availableDecksList.get(i) + " : disable");
            }
        }
    }

    /**Fonction pour définir le nombre de jetons de paix/guerre dans la partie **/
    public static int nbJeton(int nbJoueur){
        int nbJetonR = 0;
        if (nbJoueur == 2 || nbJoueur == 3){
            nbJetonR = 3;
        }
        else if (nbJoueur == 4){
            nbJetonR = 4;
        }
        else if (nbJoueur == 5){
            nbJetonR = 5;
        }
        else{
            nbJetonR = 6;
        }
        return nbJetonR;
    }

    public static void drawCard(List<Card> pioche, Player player){
        Card cartePiochee = pioche.get(0);
        pioche.remove(0);
        player.inventory.add(cartePiochee);

    }

    public static ArrayList<Integer> verificationConstruction(Player player){

        ArrayList<Card> materialCard = new ArrayList<Card>();
        int [][][] progression;
        ArrayList<Integer> constructionsPossibles = new ArrayList<>();
        int [] ressources = {0,0,0,0,0,0};  // [Stone,Wood,Paper,Brick,Glass,Gold]
        for(Card card : player.inventory){
            if(card.front.material != null){
                materialCard.add(card);
            }
        }
        for(Card card : materialCard){
            switch(card.front.material){
                case Stone -> ressources[0]++;
                case Wood -> ressources[1]++;
                case Paper -> ressources[2]++;
                case Brick -> ressources[3]++;
                case Glass -> ressources[4]++;
                case Gold -> ressources[5]++;

            }
        }
        int maxNbRessourceEgale;
        int maxNbRessourcesDifferente;
        int valeurMax=0;
        int differenceMax=0;

        for(int i=0; i<ressources.length; i++){
            if(valeurMax<ressources[i]){
                valeurMax=ressources[i];
            }
            if(ressources[i]!=0){
                differenceMax++;
            }
        }
        maxNbRessourceEgale = valeurMax;
        maxNbRessourcesDifferente = differenceMax;
        switch(player.getWonder()){
            case Alexandrie -> progression = progressionAlexendrie;
            case Babylone -> progression = progressionBabylone;
            case Gizeh -> progression = progressionGizeh;
            case Ephese -> progression = progressionEphese;
            case Halicarnasse -> progression = progressionHalicarnasse;
            case Rhodes -> progression = progressionRhodes;
            case Olympie -> progression = progressionOlympie;
            default -> progression= new int[0][][];
        }

        for(int i=progression.length-1; i>=0; i--){
            boolean estConstructible = false;
            int compteur=0;
            if(progression[i][0][compteur] == 0 || (progression[i][0][compteur] == 1 && progression[compteur][2][0] == 1)){
                compteur++;
                if(progression[i][0][compteur] == 0 || (progression[i][0][compteur] == 1 && progression[compteur][2][0] == 1)){
                    compteur++;
                    if(progression[i][0][compteur] == 0 || (progression[i][0][compteur] == 1 && progression[compteur][2][0] == 1)){
                        compteur++;
                        if(progression[i][0][compteur] == 0 || (progression[i][0][compteur] == 1 && progression[compteur][2][0] == 1)){
                            compteur++;
                            if(progression[i][0][compteur] == 0 || (progression[i][0][compteur] == 1 && progression[compteur][2][0] == 1)){
                                estConstructible = true;
                            }
                        }
                    }
                }
            }

            if(estConstructible){
                if(progression[i][2][0] == 0){
                    if(progression[i][1][1] == 0){
                        if(progression[i][1][0] <= maxNbRessourceEgale){
                            constructionsPossibles.add(i);
                            break;
                        }
                    }else{
                        if(progression[i][1][0] <= maxNbRessourcesDifferente){    //Test "le joueur possède assez de ressource ?"
                            constructionsPossibles.add(i);
                            break;
                        }
                    }
                }
            }

        }
        return constructionsPossibles;


    }

    
    public static void constructionMerveille(Player player, ArrayList<Integer> constructionsPossibles){
        //TODO FAIRE LE CHOIX DE QUELLE PIECE MONTER SI Y A LE CHOIX + ENLEVER LES CARTES UTILISEES

    }



    static int [][][] progressionAlexendrie = {{{0,0,0,0,0},{2,1},{0}},{{1,0,0,0,0},{2,0},{0}},{{1,1,0,0,0},{3,1},{0}},{{1,1,1,0,0},{3,0},{0}},{{1,1,1,1,0},{4,1},{0}}};
    static int [][][] progressionBabylone = {{{0,0,0,0,0},{2,1},{0}},{{1,0,0,0,0},{2,0},{0}},{{1,1,0,0,0},{3,1},{0}},{{1,1,1,0,0},{3,0},{0}},{{1,1,1,0,0},{4,1},{0}}};
    static int [][][] progressionGizeh = {{{0,0,0,0,0},{2,1},{0}},{{1,0,0,0,0},{2,0},{0}},{{1,1,0,0,0},{3,1},{0}},{{1,1,1,0,0},{3,0},{0}},{{1,1,1,1,0},{4,1},{0}}};
    static int [][][] progressionEphese = {{{0,0,0,0,0},{2,1},{0}},{{1,0,0,0,0},{2,0},{0}},{{1,0,0,0,0},{3,1},{0}},{{1,0,0,0,0},{3,0},{0}},{{1,1,1,1,0},{4,1},{0}}};
    static int [][][] progressionHalicarnasse = {{{0,0,0,0,0},{2,1},{0}},{{1,0,0,0,0},{2,0},{0}},{{1,1,0,0,0},{3,1},{0}},{{1,1,0,0,0},{3,0},{0}},{{1,1,1,1,0},{4,1},{0}}};
    static int [][][] progressionOlympie = {{{0,0,0,0,0},{2,1},{0}},{{1,0,0,0,0},{2,0},{0}},{{1,0,0,0,0},{3,1},{0}},{{1,1,1,0,0},{3,0},{0}},{{1,1,1,1,0},{4,1},{0}}};
    static int [][][] progressionRhodes = {{{0,0,0,0,0},{2,1},{0}},{{0,0,0,0,0},{2,0},{0}},{{1,1,0,0,0},{3,1},{0}},{{1,1,1,0,0},{3,0},{0}},{{1,1,1,1,0},{4,1},{0}}};


}


