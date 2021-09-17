package com.example.sortcards.model;

public enum Value {
	AS(0, "As"), TWO(1, "2"), THREE(2,"3"), FOUR(3, "4"), FIVE(4, "5"), SIX(5, "6"), SEVEN(6, "7"), EIGHT(7, "8"), NINE(8, "9"), TEN(9, "10"), JACK(10, "V"), QUEEN(11, "D"), KING(
			12, "R");

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
