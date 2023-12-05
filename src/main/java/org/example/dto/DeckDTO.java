package org.example.dto;

import java.util.List;

public class DeckDTO {
    private List<Card> deck;

    public DeckDTO() {
    }

    public DeckDTO(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
}
