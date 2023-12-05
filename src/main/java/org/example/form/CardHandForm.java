package org.example.form;

import org.example.dto.Card;
import org.example.dto.DeckDTO;
import org.example.dto.PokerHandDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardHandForm {
    public List<PokerHandDTO> formPokerHand(DeckDTO deck, int countPerson) {
        List<PokerHandDTO> hands = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < countPerson; i++) {
            List<Card> intermediateHand = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                int count = random.nextInt(deck.getDeck().size());
                intermediateHand.add(deck.getDeck().remove(count));
            }
            hands.add(new PokerHandDTO(intermediateHand));
        }
        return hands;
    }
}
