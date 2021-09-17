package com.example.sortcards.model;

public enum Value {
	AS(0, "As"), TWO(1, "Deux"), THREE(2,"Trois"), FOUR(3, "Quatre"), FIVE(4, "Cinq"), SIX(5, "Six"), SEVEN(6, "Sept"), EIGHT(7, "Huit"), NINE(8, "Neuf"), TEN(9, "Dix"), JACK(10, "Valet"), QUEEN(11, "Dame"), KING(
			12, "Roi");

	private int index;
	private String name;

	private Value(int index, String name ) {

		this.index = index;
		this.name = name;
	}

	public int getIndex() {
		return index;
	}
	public String getName() {return name;};


	public static Value fromIndex(final int index) {
		for (Value myEnum : Value.values()) {
			if (myEnum.index == index) {
				return myEnum;
			}
		}
		return null;
	}
}
