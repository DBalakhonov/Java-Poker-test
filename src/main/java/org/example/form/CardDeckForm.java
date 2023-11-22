package org.example.form;

import org.example.enums.Ranks;
import org.example.enums.Suit;

import java.util.ArrayList;

public class CardDeckForm {
    private ArrayList<String> cardsDeck;

    public ArrayList<String> Deck() {
        cardsDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Ranks rank : Ranks.values()) {
                cardsDeck.add(rank.getDisplayName() + suit.getDisplayName());
            }
        }
        return cardsDeck;
    }
}
