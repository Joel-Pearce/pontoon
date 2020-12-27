package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;

//Joel Pearce 2233255

public abstract class CardGame {
	public ArrayList<Player> players = new ArrayList<Player>();
	public Deck deck;
	public int numOfPlayers;
	
	public CardGame (int nplayers) {
		this.numOfPlayers = nplayers;
		this.deck = new Deck();
		for(int i = 0; i < nplayers; i++) {
			int x = i + 1;
			this.players.add(new Player("player" + Integer.toString(x)));
		}
	}
	
	public abstract void dealInitialCards();
	
	public abstract int compareHands(Player hand1, Player hand2);
	
	public Deck getDeck() {
		return this.deck;
	}
	
	public Player getPlayer(int i) {
		return this.players.get(i);
	}
	
	public int getNumPlayers() {
		return this.numOfPlayers;
	}
	
	


}
