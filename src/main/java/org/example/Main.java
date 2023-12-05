package org.example;

import org.example.comparator.PokerHandComparator;
import org.example.dto.DeckDTO;
import org.example.form.CardDeckForm;
import org.example.dto.PokerHandDTO;
import org.example.form.CardHandForm;
import org.example.pokerhandcompaerer.PokerComparer;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CardDeckForm cardDeckForm = new CardDeckForm();
        CardHandForm cardHandForm = new CardHandForm();
        DeckDTO deckDTO = cardDeckForm.Deck();
        List<PokerHandDTO> hands = cardHandForm.formPokerHand(deckDTO,5);
        PokerComparer.checkCombination(hands);
        for (int i = 0; i < hands.size(); i++) {
            System.out.println(hands.get(i).getHand());
            System.out.println(hands.get(i).getCombinations());
        }

    }
}