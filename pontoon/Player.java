package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;


public class Player {
	
	
	public String name;
	public ArrayList<Card> hand = new ArrayList<Card>();
	
	public boolean checkAce(ArrayList<Integer> list) {
		boolean ace = false;
		for(int i : list) {
			if(i == 11) {
				ace = true;
			}
		}
		return ace;
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void dealToPlayer(Card card) {
		this.hand.add(card);
	}
	
	public void removeCard(Card card) {
		this.hand.remove(card);
	}
	
	public ArrayList<Integer> getNumericalHandValue(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int count = 0;
		int aceCount = 0;
		for(Card card : hand) {
			nums = card.getNumericalValue();
			count += nums.get(0);
			nums.clear();
		}
		result.add(count);
		count = 0;
		for(Card card : hand) {
			nums = card.getNumericalValue();
			if(checkAce(nums)) {
				count += nums.get(1);
				aceCount++;
			}
			else {
				count += nums.get(0);
			}
			nums.clear();
		}
		
		if(count != result.get(0)) {
			result.add(count);
		}
		count = 0;
		
		if(aceCount == 2) {
			aceCount = 1;
			for(Card card : hand) {
				nums = card.getNumericalValue();
				if(checkAce(nums) && aceCount > 0) {
					count += nums.get(1);
					aceCount--;
				}
				else {
					count += nums.get(0);
				}
				nums.clear();
			}
		}
		
		if(count != result.get(0)) {
			result.add(count);
		}
		count = 0;
		
		if(aceCount == 3) {
			aceCount = 2;
			for(Card card : hand) {
				nums = card.getNumericalValue();
				if(checkAce(nums) && aceCount > 0) {
					count += nums.get(1);
					aceCount--;
				}
				else {
					count += nums.get(0);
				}
				nums.clear();
			}
			if(count != result.get(0)) {
				result.add(count);
			}
			count = 0;
			aceCount = 1;
			for(Card card : hand) {
				nums = card.getNumericalValue();
				if(checkAce(nums) && aceCount > 0) {
					count += nums.get(1);
					aceCount--;
				}
				else {
					count += nums.get(0);
				}
				nums.clear();
			}
			if(count != result.get(0)) {
				result.add(count);
			}
			count = 0;
		}
		
		if(aceCount == 4) {
			aceCount = 3;
			for(Card card : hand) {
				nums = card.getNumericalValue();
				if(checkAce(nums) && aceCount > 0) {
					count += nums.get(1);
					aceCount--;
				}
				else {
					count += nums.get(0);
				}
				nums.clear();
			}
			if(count != result.get(0)) {
				result.add(count);
			}
			count = 0;
			aceCount = 2;
			for(Card card : hand) {
				nums = card.getNumericalValue();
				if(checkAce(nums) && aceCount > 0) {
					count += nums.get(1);
					aceCount--;
				}
				else {
					count += nums.get(0);
				}
				nums.clear();
			}
			if(count != result.get(0)) {
				result.add(count);
			}
			count = 0;
			aceCount = 1;
			for(Card card : hand) {
				nums = card.getNumericalValue();
				if(checkAce(nums) && aceCount > 0) {
					count += nums.get(1);
					aceCount--;
				}
				else {
					count += nums.get(0);
				}
				nums.clear();
			}
			if(count != result.get(0)) {
				result.add(count);
			}
			count = 0;
		}
		
		for(int i = 0; i < result.size(); i ++) {
			if(result.get(i) == 0){
				result.remove(i);
				i--;
			}
		}
		
		ArrayList<Integer> sorted = sorter(result);
		
		return sorted;
		
	}
	
	public ArrayList<Integer> sorter(ArrayList<Integer> list){
		for(int i = 0; i < list.size(); i++){
            for(int j = list.size() - 1; j > i; j--){
                if(list.get(i) > list.get(j)) {
                	int t = list.get(i);
                	list.set(i, list.get(j));
                	list.set(j, t);
                }
                
        }
       
        }
		return list;
	}
	
	public int getBestNumericalHandValue(){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int count1 = 0;
		int count2 = 0;
		int max = 0;
		for(Card card : hand) {
			nums = card.getNumericalValue();
			count1 += nums.get(0);
			nums.clear();
		}
		for(Card card : hand) {
			nums = card.getNumericalValue();
			if(checkAce(nums)) {
				count2 += nums.get(1);
			}
			else {
				count2 += nums.get(0);
			}
			nums.clear();
		}
		
		if(count1 > count2) {
			max = count1;
		}
		else if(count2 > count1) {
			max = count2;
		}
		else {
			max = count1;
		}
		
		return max;
		
	}
	
	public ArrayList<Card> getCards(){
		return this.hand;
	}
	
	public int getHandSize() {
		return this.hand.size();
	}




}
