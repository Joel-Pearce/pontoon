package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;

//Joel Pearce 2233255

public class Pontoon extends CardGame {

	public Pontoon(int nplayers) {
		super(nplayers);
		// TODO Auto-generated constructor stub
	}
	
	public int getMinValue(ArrayList<Integer> list) {
		int min = list.get(0);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) < min) {
				min = list.get(i);
			}
	
	}
		return min;
	}

	@Override
	public void dealInitialCards() {
		for(int i = 0; i < this.getNumPlayers(); i++) {
			players.get(i).dealToPlayer(this.deck.dealRandomCard());
			players.get(i).dealToPlayer(this.deck.dealRandomCard());
		}
		
	}
	
	public boolean has21(ArrayList<Integer> list) {
		boolean has21 = false;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == 21) {
				has21 = true;
				break;
			}
		}
		
		return has21;
	}
	
	public boolean smallerThan21(ArrayList<Integer> list) {
		boolean smallerThan21 = false;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) < 21) {
				smallerThan21 = true;
				break;
			}
		}
		
		return smallerThan21;
	}
	
	public int bestValueUnder21(ArrayList<Integer> list) {
		int max = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) > 21) {
				list.remove(i);
				i--;
				
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) > max) {
				max = list.get(i);
			}
		}
		
		return max;
		
	}
	
    

	public int compareHands(Player hand1, Player hand2) {
		int reply = 0;
		ArrayList<Integer> h1 = hand1.getNumericalHandValue();
		ArrayList<Integer> h2 = hand2.getNumericalHandValue();
		int minHand1 = h1.get(0);
		int minHand2 = h2.get(0);
		
		if(hand1.getHandSize() == 2 && has21(h1) && hand2.getHandSize() == 2 && has21(h2)) {
			reply = 0;
		}
		else if(hand1.getHandSize() == 2 && hand1.getBestNumericalHandValue() == 21) {
			reply = -1;
		}
		else if(hand2.getHandSize() == 2 && hand2.getBestNumericalHandValue() == 21) {
			reply = 1;
		}
		else if(hand1.getHandSize() == 5 && minHand1 < 21 && hand2.getHandSize() == 5 && minHand2 < 21) {
			reply = 0;
		}
		else if(hand1.getHandSize() == 5 && minHand1 < 21) {
			reply = -1;
		}
		else if(hand2.getHandSize() == 5 && minHand2 < 21) {
			reply = 1;
		}
		else if(has21(h1) && has21(h2)) {
			reply = 0;
		}
		else if(has21(h1)) {
			reply = -1;
		}
		else if(has21(h2)) {
			reply = 1;
		}
		else if(!smallerThan21(h1) && !smallerThan21(h2)) {
			reply = 0;
		}
		else if(!smallerThan21(h1)) {
			reply = 1;
		}
		else if(!smallerThan21(h2)) {
			reply = -1;
		}
		else if(bestValueUnder21(h1) > bestValueUnder21(h2)) {
			reply = -1;
		}
		else if(bestValueUnder21(h1) < bestValueUnder21(h2)) {
			reply = 1;
		}
		return reply;
	}
	


}
