package org.example.dto;


import org.example.enums.PokerCombinations;

import java.util.List;

public class PokerHandDTO {
    private List<Card> hand;
    private PokerCombinations combinations;

    public PokerHandDTO(List<Card> hand) {
        this.hand = hand;
    }

    public PokerHandDTO(List<Card> hand, PokerCombinations combinations) {
        this.hand = hand;
        this.combinations = combinations;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public PokerCombinations getCombinations() {
        return combinations;
    }

    public void setCombinations(PokerCombinations combinations) {
        this.combinations = combinations;
    }

    @Override
    public String toString() {
        return "PokerHandDTO{" +
                "hand=" + hand +
                '}';
    }
}

