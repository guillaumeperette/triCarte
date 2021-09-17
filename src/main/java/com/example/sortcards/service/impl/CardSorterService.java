package com.example.sortcards.service.impl;

import com.example.sortcards.model.Card;
import com.example.sortcards.model.Color;
import com.example.sortcards.model.Value;
import com.example.sortcards.service.ICardSorterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CardSorterService implements ICardSorterService {

	@Override
	public List<Integer> getColorRandomOrderList() {
		Integer[] colorArray = { 0, 1, 2, 3 };

		List<Integer> colorRandomOrderList = Arrays.asList(colorArray);

		Collections.shuffle(colorRandomOrderList);
		return colorRandomOrderList;
	}

	@Override
	public List<Integer> getOrderRandomList() {
		Integer[] valueArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

		List<Integer> valueOrderRandomList = Arrays.asList(valueArray);

		Collections.shuffle(valueOrderRandomList);

		valueOrderRandomList.toArray(valueArray);
		return valueOrderRandomList;
	}
	@Override
	public Set<Card> getRandomHand(List<Integer> colorRandomOrderList, List<Integer> valueOrderRandomList) {
		Set<Card> cardSet = new HashSet<>();
		while(cardSet.size() < 10){
			Card card = new Card(Value.fromIndex(getRandomNnumber(13)), Color.fromIndex(getRandomNnumber(4)));
			card.setValueOrder(valueOrderRandomList.indexOf(card.getValue().getIndex()));
			card.setColorOrder((colorRandomOrderList.indexOf(card.getColor().getIndex()) + 1) * 100);
			cardSet.add(card);
		}
		return cardSet;
	}

	@Override
	public Set<Card> sortHand(Set<Card> hand) {
		Set<Card> sortedCardSet = new TreeSet<>(Comparator.comparing(Card::getOrder));
		sortedCardSet.addAll(hand);
		return sortedCardSet;
	}

	private int getRandomNnumber(int max){
		Random randomGene = new Random();
		return randomGene.nextInt(max);
	}

}
