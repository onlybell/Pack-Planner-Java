package com.motiondesign.packplanner.model;

import java.util.Stack;

public class PackPackage {
	private Stack<PackVO> stack = new Stack<PackVO>();

    public Stack<PackVO> getPacksList() {
        return stack;
    }

    public boolean isEmpty() {
        return getPacksList().isEmpty();
    }

    public int getTopPackId() {
        if (getPacksList().isEmpty()) {
            return getPacksList().size();
        }
        return getTopPack().getPackId();
    }

    public PackVO getTopPack() {
        return getPacksList().peek();
    }

    public void addPack(PackVO pack) {
        getPacksList().push(pack);
    }
}
