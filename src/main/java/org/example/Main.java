package org.example;

import org.example.form.CardDeckForm;
import org.example.dto.PokerHandDTO;
import org.example.form.CardHandForm;
import org.example.pokerhandcompaerer.PokerHandComparer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CardDeckForm cardDeckForm = new CardDeckForm();
        CardHandForm cardHandForm = new CardHandForm();
        PokerHandComparer pokerHandComparer = new PokerHandComparer();
        List<PokerHandDTO> hands = new ArrayList<PokerHandDTO>();
        List<String> cardDeck=cardDeckForm.Deck();
        hands=cardHandForm.formPokerHand(cardDeck,10);
        hands=pokerHandComparer.getStrength(hands);
        for (int i = 0; i < hands.size(); i++) {
            System.out.println(hands.get(i));
        }
    }
}