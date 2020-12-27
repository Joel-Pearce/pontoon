package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;

public class Card {
	
	//Joel Pearce 2233255
	
	private Suit suit;
	private Value value;
	
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	public static enum Suit {	
		CLUBS, HEARTS, DIAMONDS, SPADES
	}
	
	public static enum Value {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
		
	}
	
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public void setValue(Value value) {
		this.value = value;
	}
	
	public Value getValue() {
		return this.value;
	}
	
	public ArrayList<Integer> getNumericalValue(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Value v = this.value;
		
		if(v == Value.ACE){
			list.add(1);
		}
		if(v == Value.TWO) {
			list.add(2);
		}
		if(v == Value.THREE) {
			list.add(3);
		}
		if(v == Value.FOUR) {
			list.add(4);
		}
		if(v == Value.FIVE) {
			list.add(5);
		}
		if(v == Value.SIX) {
			list.add(6);
		}
		if(v == Value.SEVEN) {
			list.add(7);
		}
		if(v == Value.EIGHT) {
			list.add(8);
		}
		if(v == Value.NINE) {
			list.add(9);
		}
		if(v == Value.TEN) {
			list.add(10);
		}
		if(v == Value.JACK) {
			list.add(10);
		}
		if(v == Value.QUEEN) {
			list.add(10);
		}
		if(v == Value.KING) {
			list.add(10);
		}
		if(v == Value.ACE) {
			list.add(11);
		}
		
		return list;
		
	}



}
