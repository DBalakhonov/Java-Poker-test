package org.example.pokerhandcompaerer;

import org.example.dto.PokerHandDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class PokerHandComparer {
    List<Integer> values = new ArrayList<>();

    public List<PokerHandDTO> getStrength(List<PokerHandDTO> pokerHands) {
        ArrayList<PokerHandDTO> sortedHands = new ArrayList<>(pokerHands.size());
        for (int i = 0; i < pokerHands.size(); i++) {
            PokerHandDTO pokerHand = pokerHands.get(i);
            pokerHand.setHandStrength(checkStrenght(pokerHand));
            sortedHands.add(i, pokerHand);
        }
        Collections.sort(sortedHands, Collections.reverseOrder(Comparator.comparingDouble(PokerHandDTO::getHandStrength)));
        return sortedHands;
    }

    private double checkHighCard() {
        return values.get(values.size() - 1);
    }

    private double checkHighCardForWheel() {
        return values.get(values.size() - 2);
    }

    private boolean checkFlushRoyal() {
        if (values.contains(14) & values.contains(13) & values.contains(12) & values.contains(11) & values.contains(10)) {
            return true;
        } else {
            return false;
        }
    }

    private double checkStrenght(PokerHandDTO pokerHand) {
        boolean resultFlush = false;
        boolean resultStrength = false;
        Map<Character, Integer> suitsCount = new HashMap<>();
        for (String card : pokerHand.getHand().split(" ")) {
            char suit = card.charAt(1);
            suitsCount.put(suit, suitsCount.getOrDefault(suit, 0) + 1);
        }
        if (suitsCount.containsValue(5)) {

            resultFlush = true;
        }
        values = new ArrayList<>();
        Map<Character, Integer> cardValues = new HashMap<>();
        cardValues.put('2', 2);
        cardValues.put('3', 3);
        cardValues.put('4', 4);
        cardValues.put('5', 5);
        cardValues.put('6', 6);
        cardValues.put('7', 7);
        cardValues.put('8', 8);
        cardValues.put('9', 9);
        cardValues.put('T', 10);
        cardValues.put('J', 11);
        cardValues.put('Q', 12);
        cardValues.put('K', 13);
        cardValues.put('A', 14);
        for (String card : pokerHand.getHand().split(" ")) {
            char value = card.charAt(0);
            values.add(cardValues.get(value));
        }

        Collections.sort(values);

        for (int i = 0; i < 1; i++) {
            if (values.get(values.size() - 1) - values.get(0) == 4) {
                resultStrength = true;
            }
        }

        if (values.contains(14) && values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5)) {
            resultStrength = true;
        }
        if (resultStrength & resultFlush) {
            if (checkFlushRoyal()) {
                return 10.14;
            } else if (values.contains(2) & values.contains(14)) {
                return 9.0 + (checkHighCardForWheel() / 100.0);
            } else {

                return 9.0 + (checkHighCard() / 100.0);
            }
        } else if (resultFlush | resultStrength) {
            if (resultFlush) {
                return 5.0 + (checkHighCard() / 100.0);
            } else if (values.contains(2)) {
                return 4.0 + (checkHighCard() / 100.0);
            }
        }
        return checkFullPair(pokerHand);
    }

    private double checkFullPair(PokerHandDTO pokerHand) {
        boolean hasPair = false;
        boolean hasTwoPairs = false;
        boolean hasThreeOfAKind = false;
        boolean hasFullHouse = false;
        boolean hasFourOfAKind = false;
        int result = 0;
        Map<Character, Integer> cardCounts = new HashMap<>();
        for (String card : pokerHand.getHand().split(" ")) {
            char value = card.charAt(0);
            int count = cardCounts.getOrDefault(value, 0);
            cardCounts.put(value, count + 1);
        }
        for (int count : cardCounts.values()) {
            if (count == 2) {
                if (hasPair) {
                    hasTwoPairs = true;
                } else {
                    hasPair = true;
                }
            } else if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 4) {
                hasFourOfAKind = true;
            }
        }
        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                if (values.get(i).equals(values.get(j))) {
                    if (result < values.get(i)) {
                        result = values.get(i);
                    }
                }
            }
        }
        hasFullHouse = hasPair & hasThreeOfAKind;
        if (hasPair && !hasFullHouse && !hasTwoPairs) {
            BigDecimal bd1 = new BigDecimal("1.0");
            BigDecimal bd2 = new BigDecimal(result);
            BigDecimal bd3 = new BigDecimal("100.0");
            BigDecimal bd4 = bd2.divide(bd3, 2, RoundingMode.HALF_UP);
            BigDecimal bd5 = bd1.add(bd4);
            return bd5.doubleValue();
        }
        if (hasTwoPairs) {
            return 2.0 + (result / 100.0);
        }
        if (hasThreeOfAKind && !hasFullHouse) {
            return 3.0 + (result / 100.0);
        }
        if (hasFourOfAKind) {
            return 7.0 + (result / 100.0);
        }
        if (hasFullHouse) {
            return 6.0 + (result / 100.0);
        } else {
            return 0 + (checkHighCard() / 100.0);
        }
    }
}
