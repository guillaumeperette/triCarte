package com.example.sortcards.model;

public enum Color {
    DIAMOND(0, "Carreaux"), SPADE(1, "Pique"), HEART(2, "Coeur"), CLUB(3, "Trèfle");

    private int index;
    private String name;


    private Color(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static Color fromIndex(final int index) {
        for (Color myEnum : Color.values()) {
            if (myEnum.index == index) {
                return myEnum;
            }
        }
        return null;
    }

}
