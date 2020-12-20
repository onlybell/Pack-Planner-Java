package com.motiondesign.packplanner.model;

import java.util.ArrayList;
import java.util.List;

public class InputDataVO {
	private String sortOrder;
	private int maxPieces;
	private float maxWeight;
	private String items;
	
	private List<ItemVO> itemList = new ArrayList<ItemVO>();
	
	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getMaxPieces() {
		return maxPieces;
	}

	public void setMaxPieces(int maxPieces) {
		this.maxPieces = maxPieces;
	}
	
	public float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public List<ItemVO> getItemList() {
		return itemList;
	}

	public void addItem(ItemVO item) {
	    getItemList().add(item);
	}



}
