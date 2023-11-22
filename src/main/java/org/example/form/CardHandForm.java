package org.example.form;

import org.example.dto.PokerHandDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardHandForm {
    public List<PokerHandDTO> formPokerHand(List<String> deck, int countPerson) {
        List<PokerHandDTO> hands = new ArrayList<>();
        Random random = new Random();
        String intermediateHand = "";
        for (int i = 0; i < countPerson; i++) {
            intermediateHand = "";
            for (int j = 0; j < 5; j++) {
                int count = random.nextInt(deck.size());
                intermediateHand += deck.get(count) + " ";
                deck.remove(count);
            }
            intermediateHand = intermediateHand.trim();
            hands.add(new PokerHandDTO(intermediateHand));
        }
        return hands;
    }
}
