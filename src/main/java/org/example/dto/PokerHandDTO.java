package org.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class PokerHandDTO {
    private String hand;
    private double handStrength;

    public PokerHandDTO(String hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return hand;
    }
}
