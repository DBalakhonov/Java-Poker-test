package org.example.form;

import org.example.dto.Card;
import org.example.dto.DeckDTO;
import org.example.enums.Rank;
import org.example.enums.Suit;

import java.util.ArrayList;
import java.util.List;

public class CardDeckForm {
    private DeckDTO cardsDeck = new DeckDTO();
    private List<Card> deck = new ArrayList<>();

    public DeckDTO Deck() {

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit,rank));
            }
        }
        cardsDeck.setDeck(deck);
        return cardsDeck;
    }
}
