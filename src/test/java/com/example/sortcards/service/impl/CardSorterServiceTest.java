package com.example.sortcards.service.impl;

import com.example.sortcards.model.Card;
import com.example.sortcards.model.Color;
import com.example.sortcards.model.Value;
import com.example.sortcards.service.ICardSorterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CardSorterServiceTest {

    List<Integer> randomValueOrder;
    List<Integer> ramdomColorOrder;
    Set<Card> hand = new HashSet<>();

    @BeforeEach
    public void init(){
        initValueOrder();
        initColorOrder();;
        initHand();
    }

    @Test
    void sortHand() {
        ICardSorterService cardSorterService = new CardSorterService();
       Set<Card> sortedSet = cardSorterService.sortHand(hand);
       assertEquals(10, sortedSet.size());

        List<Card> cardList = new ArrayList<>();
        cardList.addAll(sortedSet);
       assertTrue(cardList.get(0).equals(new Card(Value.JACK,Color.SPADE)));
       assertTrue(cardList.get(1).equals(new Card(Value.FIVE,Color.SPADE)));
       assertTrue(cardList.get(2).equals(new Card(Value.AS,Color.HEART)));
       assertTrue(cardList.get(3).equals(new Card(Value.SIX,Color.HEART)));
       assertTrue(cardList.get(4).equals(new Card(Value.QUEEN,Color.HEART)));
       assertTrue(cardList.get(5).equals(new Card(Value.KING,Color.DIAMOND)));
       assertTrue(cardList.get(6).equals(new Card(Value.AS,Color.DIAMOND)));
       assertTrue(cardList.get(7).equals(new Card(Value.FIVE,Color.DIAMOND)));
       assertTrue(cardList.get(8).equals(new Card(Value.EIGHT,Color.CLUB)));
       assertTrue(cardList.get(9).equals(new Card(Value.SIX,Color.CLUB)));

    }

    private void initValueOrder() {
        randomValueOrder = new ArrayList<>();
        randomValueOrder.add(7);
        randomValueOrder.add(2);
        randomValueOrder.add(3);
        randomValueOrder.add(10);
        randomValueOrder.add(12);
        randomValueOrder.add(8);
        randomValueOrder.add(0);
        randomValueOrder.add(4);
        randomValueOrder.add(5);
        randomValueOrder.add(1);
        randomValueOrder.add(11);
        randomValueOrder.add(6);
    }

    private void initColorOrder(){
        ramdomColorOrder = new ArrayList<>();
        ramdomColorOrder.add(2);
        ramdomColorOrder.add(0);
        ramdomColorOrder.add(3);
        ramdomColorOrder.add(4);
    }

    private void initHand(){
        hand.add(initCard(Value.FIVE,Color.DIAMOND));
        hand.add(initCard(Value.EIGHT,Color.CLUB));
        hand.add(initCard(Value.QUEEN,Color.HEART));
        hand.add(initCard(Value.JACK,Color.SPADE));
        hand.add(initCard(Value.AS,Color.DIAMOND));
        hand.add(initCard(Value.SIX,Color.HEART));
        hand.add(initCard(Value.SIX,Color.CLUB));
        hand.add(initCard(Value.KING,Color.DIAMOND));
        hand.add(initCard(Value.AS,Color.HEART));
        hand.add(initCard(Value.FIVE,Color.SPADE));
    }

    private  Card initCard(Value value, Color color){
        Card card = new Card(value, color);
        card.setValueOrder(randomValueOrder.indexOf(card.getValue().getIndex()));
        card.setColorOrder((ramdomColorOrder.indexOf(card.getColor().getIndex()) + 1) * 100);
        return card;
    }
}