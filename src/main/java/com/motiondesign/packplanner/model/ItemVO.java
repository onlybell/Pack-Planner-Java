package com.motiondesign.packplanner.model;

public class ItemVO {
	private int itemId;
	private int itemLength;
	private int itemQuantity;
	private float itemWeight;
	
	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public int getItemLength() {
		return itemLength;
	}
	
	public void setItemLength(int itemLength) {
		this.itemLength = itemLength;
	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	public float getItemWeight() {
		return itemWeight;
	}
	
	public void setItemWeight(float itemWeight) {
		this.itemWeight = itemWeight;
	}
	
}
