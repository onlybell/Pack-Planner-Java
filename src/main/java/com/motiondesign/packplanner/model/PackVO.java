package com.motiondesign.packplanner.model;

import java.util.List;
import java.util.Stack;

public class PackVO {

	private int packId;
	private float packLength;
	private float packWeight;
	
	private Stack<ItemVO> items = new Stack<ItemVO>();

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public float getPackLength() {
		return packLength;
	}

	public void setPackLength(float packLength) {
		this.packLength = packLength;
	}

	public float getPackWeight() {
		return packWeight;
	}

	public void setPackWeight(float packWeight) {
		this.packWeight = packWeight;
	}

    public Stack<ItemVO> getItems() {
        return items;
    }
    
    public float getTotalPackWeight() {
        float totalWeight = 0.0f;
        for (ItemVO item : getItems()) {
            if (item != null) {
                totalWeight += item.getItemQuantity() * item.getItemWeight();
            }
        }
        return totalWeight;
    }

    public int getPackPieces() {
    	int totalPieces = 0;
    	for (ItemVO item : getItems()) {
            if (item != null) {
            	totalPieces += item.getItemQuantity();
            }
        }
        return totalPieces;
    }

    public int getPackSize() {
        return getItems().size();
    }
    
    public void addItem(ItemVO item) {
        if (item != null) {
            getItems().push(item);
        }
    }
    
    public int getTotalPackLength() {
    	int totalLength = 0;
        for (ItemVO item : getItems()) {
            if (item != null) {
            	if (totalLength < item.getItemLength()) {
            		totalLength = item.getItemLength();
            	}
            }
        }
        return totalLength;
    }
}
