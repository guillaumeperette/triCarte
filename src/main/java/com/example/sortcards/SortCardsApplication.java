package com.example.sortcards;

import com.example.sortcards.model.Card;
import com.example.sortcards.service.ICardSorterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@RestController
public class SortCardsApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortCardsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SortCardsApplication.class, args);
    }

    @Autowired
    private ICardSorterService cardSorterService;


    @GetMapping("/card")
    public String sortHand() {

        List<Integer> colorRandomOrderList = cardSorterService.getColorRandomOrderList();
        List<Integer> valueOrderRandomList = cardSorterService.getOrderRandomList();
        Set<Card> randomHand = cardSorterService.getRandomHand(colorRandomOrderList, valueOrderRandomList);

        Set<Card> sortedCardSet = cardSorterService.sortHand(randomHand);

        HtmlGeneratorUtil htmlGenerator = new HtmlGeneratorUtil();
        htmlGenerator.buildColorText(colorRandomOrderList);
        htmlGenerator.buildValueText(valueOrderRandomList);
        htmlGenerator.buildHandText(randomHand);
        htmlGenerator.buildSortedHandText(sortedCardSet);

        String response = htmlGenerator.buildHtml();
        LOGGER.debug(response);

        return response;
    }


}
