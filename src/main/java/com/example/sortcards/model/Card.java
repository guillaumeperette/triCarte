package com.example.sortcards.model;

public class Card implements Comparable<Card> {
    private Value value;
    private Color color;
    private int colorOrder;
    private int valueOrder;

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getColorOrder() {
        return colorOrder;
    }

    public void setColorOrder(int colorOrder) {
        this.colorOrder = colorOrder;
    }

    public int getValueOrder() {
        return valueOrder;
    }

    public void setValueOrder(int valueOrder) {
        this.valueOrder = valueOrder;
    }

    public Integer getOrder() {
        return colorOrder + valueOrder;
    }

    public Card(Value value, Color color) {
        super();
        this.value = value;
        this.color = color;
    }

    public int compareTo(Card card) {
        return getOrder().compareTo(card.getOrder());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (color != other.color)
            return false;
        if (value != other.value)
            return false;
        return true;
    }
}
