package com.example.sortcards.service;

import com.example.sortcards.model.Card;

import java.util.List;
import java.util.Set;


public interface ICardSorterService {
    List<Integer> getColorRandomOrderList();

    List<Integer> getOrderRandomList();

    Set<Card> getRandomHand(List<Integer> colorRandomOrderList, List<Integer> valueOrderRandomList);

    Set<Card> sortHand(Set<Card> hand);
}
