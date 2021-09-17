package com.example.sortcards;

import com.example.sortcards.model.Card;
import com.example.sortcards.model.Color;
import com.example.sortcards.model.Value;

import java.util.List;
import java.util.Set;

public class HtmlGeneratorUtil {

    private StringBuilder colorText = new StringBuilder("Ordre aléatoire des couleurs, de la moins forte à la plus forte : ");
    private StringBuilder valueText = new StringBuilder("Ordre aléatoire des valeurs, de la moins forte à la plus forte : ");
    private StringBuilder handText = new StringBuilder("Main de 10 cartes non triée : ");
    private StringBuilder sortedHandText = new StringBuilder("On trie la main selon les ordres de couleurs et de valeurs définis avant : ");


    public void buildColorText(List<Integer> colorRandomOrderList) {

        String coma = "";
        for (Integer colorIndex : colorRandomOrderList) {

            Color color = Color.fromIndex(colorIndex);
            colorText.append(coma);
            colorText.append(color.getName());
            coma = ", ";
        }

    }


    public void buildValueText(List<Integer> valueOrderRandomList) {

        String coma = "";
        for (Integer valueIndex : valueOrderRandomList) {
            Value value = Value.fromIndex(valueIndex);
            valueText.append(coma);
            valueText.append(value.getName());
            coma = ", ";
        }

    }


    public void buildHandText(Set<Card> cardSet) {

        String coma = "";
        for (Card card : cardSet) {
            handText.append(coma);
            handText.append(card.getValue().getName() + " de " + card.getColor().getName());
            coma = ", ";
        }

    }


    public void buildSortedHandText(Set<Card> sortedCardSet) {
        String coma = "";
        for (Card card : sortedCardSet) {
            sortedHandText.append(coma);
            sortedHandText.append(card.getValue().getName() + " de " + card.getColor().getName());
            coma = ", ";
        }
    }


    public String buildHtml() {
        return "<p>" + colorText.append("</p>").append("<p>").append(valueText).append("</p>").append("<p>")
                .append(handText).append("</p>").append("<p>").append(sortedHandText).toString() + "</p><p><a href=\"/\">Retour</a></p>";
    }
}
