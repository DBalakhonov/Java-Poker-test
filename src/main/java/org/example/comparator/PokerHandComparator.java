package org.example.comparator;

import org.example.dto.PokerHandDTO;

import java.util.Comparator;

public class PokerHandComparator implements Comparator<PokerHandDTO> {
    @Override
    public int compare(PokerHandDTO hand1, PokerHandDTO hand2) {
        return hand2.getCombinations().compareTo(hand1.getCombinations());
    }
}