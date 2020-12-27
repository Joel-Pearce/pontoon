package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;
import java.util.Random;

import com.bham.pij.assignments.pontoon.Card.Suit;
import com.bham.pij.assignments.pontoon.Card.Value;


//Joel Pearce 2233255

public class Deck {
	public ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		for(Suit suit : Suit.values()){
			for(Value value : Value.values()){
				this.deck.add(new Card(suit,value));
			}
		}
	}
	
	public void reset() {
		this.deck.clear();
		for(Suit suit : Suit.values()){
			for(Value value : Value.values()){
				this.deck.add(new Card(suit,value));
			}
		}
	}
	
	public void shuffle(){
		ArrayList<Card> temp = new ArrayList<Card>();
		int index = 0;
		int size = this.deck.size();
		Random r = new Random();
		for(int i = 0; i < size;i++){
			index = r.nextInt((this.deck.size() - 1 - 0) + 1) + 0;
			temp.add(this.deck.get(index));
			this.deck.remove(index);
		}
		this.deck = temp;
	}

	public Card getCard(int i) {
		return this.deck.get(i);
	}
	
	public void removeCard(int i) {
		this.deck.remove(i);
	}
	
	public Card dealRandomCard() {
		Random r = new Random();
		int index = r.nextInt((this.deck.size() - 1 - 0) + 1) + 0;
		Card c = this.deck.get(index);
		this.deck.remove(index);
		return c;
	}
	
	public int size() {
		return this.deck.size();
	}


}
