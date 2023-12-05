package org.example.pokerhandcompaerer;

import org.example.comparator.PokerHandComparator;
import org.example.dto.Card;
import org.example.dto.PokerHandDTO;
import org.example.enums.PokerCombinations;
import org.example.enums.Rank;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerComparer {
    public static void checkCombination(List<PokerHandDTO> hands) {
        for (int i = 0; i < hands.size(); i++) {
            List<Card> hand = hands.get(i).getHand();

            if (isRoyalFlush(hand)) {
                hands.get(i).setCombinations(PokerCombinations.ROYAL_FLUSH);
            } else if (isStraightFlush(hand)) {
                hands.get(i).setCombinations(PokerCombinations.STRAIGHT_FLUSH);
            } else if (isFourOfAKind(hand)) {
                hands.get(i).setCombinations(PokerCombinations.FOUR_OF_A_KIND);
            } else if (isFullHouse(hand)) {
                hands.get(i).setCombinations(PokerCombinations.FULL_HOUSE);
            } else if (isFlush(hand)) {
                hands.get(i).setCombinations(PokerCombinations.FLUSH);
            } else if (isStraight(hand)) {
                hands.get(i).setCombinations(PokerCombinations.STRAIGHT);
            } else if (isThreeOfAKind(hand)) {
                hands.get(i).setCombinations(PokerCombinations.THREE_OF_A_KIND);
            } else if (isTwoPair(hand)) {
                hands.get(i).setCombinations(PokerCombinations.TWO_PAIR);
            } else if (isOnePair(hand)) {
                hands.get(i).setCombinations(PokerCombinations.PAIR);
            } else {
                hands.get(i).setCombinations(PokerCombinations.HIGH_CARD);
            }
        }
        Collections.sort(hands,new PokerHandComparator());
    }

    private static boolean isRoyalFlush(List<Card> hand) {
        return isStraightFlush(hand) && hand.get(0).getRank() == Rank.Ten;
    }

    private static boolean isStraightFlush(List<Card> hand) {
        return isFlush(hand) && isStraight(hand);
    }

    private static boolean isFourOfAKind(List<Card> hand) {
        return hasNOfAKind(hand, 4);
    }

    private static boolean isFullHouse(List<Card> hand) {
        return hasNOfAKind(hand, 3) && hasNOfAKind(hand, 2);
    }

    private static boolean isFlush(List<Card> hand) {
        return hand.stream().allMatch(c -> c.getSuit() == hand.get(0).getSuit());
    }

    private static boolean isStraight(List<Card> hand) {
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getRank().ordinal() != hand.get(i - 1).getRank().ordinal() + 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isThreeOfAKind(List<Card> hand) {
        return hasNOfAKind(hand, 3);
    }

    private static boolean isTwoPair(List<Card> hand) {
        int pairs = 0;
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
                pairs++;
                i++;
            }
        }
        return pairs == 2;
    }

    private static boolean isOnePair(List<Card> hand) {
        return hasNOfAKind(hand, 2);
    }

    private static boolean hasNOfAKind(List<Card> hand, int n) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }
        return rankCount.values().contains(n);
    }
}
