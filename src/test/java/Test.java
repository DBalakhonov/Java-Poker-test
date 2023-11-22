import lombok.Data;
import org.example.Main;
import org.example.dto.PokerHandDTO;
import org.example.form.CardDeckForm;
import org.example.form.CardHandForm;
import org.example.pokerhandcompaerer.PokerHandComparer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class Test {
    private PokerHandComparer pokerHandComparer;
    private CardDeckForm cardDeckForm;
    private CardHandForm cardHandForm;


    @DisplayName("Провека определение комбинации и сортировки по силе")
    @org.junit.jupiter.api.Test
    void checkCombinationAndStrength(){
        this.cardDeckForm = new CardDeckForm();
        this.cardHandForm = new CardHandForm();
        this.pokerHandComparer = new PokerHandComparer();
        List<String> deck = cardDeckForm.Deck();
        PokerHandDTO lowStrengthHand = new PokerHandDTO("2D 3C 4H 5D 7C");
        PokerHandDTO highStrengthHand = new PokerHandDTO("AC KC QC JC TC");
        List<PokerHandDTO> hands = cardHandForm.formPokerHand(deck,10);
        hands.add(lowStrengthHand);
        hands.add(highStrengthHand);
        hands=pokerHandComparer.getStrength(hands);
        assertEquals(lowStrengthHand,hands.get(hands.size()-1));
        assertEquals(highStrengthHand,hands.get(0));
    }
}
