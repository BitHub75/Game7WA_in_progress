package com.example.game7wa_in_progress;

public enum CardBack {

    CentralDeck(null), //

    Alexandrie(Wonder.Alexandrie), //
    Halicarnasse(Wonder.Halicarnasse),
    Ephese(Wonder.Ephese), //
    Olympie(Wonder.Olympie), //,
    Babylone(Wonder.Babylone), //
    Rhodes(Wonder.Rhodes), //
    Gizeh(Wonder.Gizeh); //

    public final boolean centralDeck;
    public final Wonder wonderDeck;

    private CardBack(Wonder wonderDeck) {
        this.centralDeck = (wonderDeck == null);
        this.wonderDeck = wonderDeck;
    }

}
