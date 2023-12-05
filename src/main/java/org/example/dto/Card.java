package org.example.dto;

import org.example.enums.Rank;
import org.example.enums.Suit;

public class Card{
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        String result= "";
        result += rank.getDisplayName() + suit.getDisplayName();
        return result;
    }

}
