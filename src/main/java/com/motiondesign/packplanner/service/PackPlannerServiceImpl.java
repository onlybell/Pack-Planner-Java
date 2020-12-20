package com.motiondesign.packplanner.service;

import java.util.Collections;

import com.motiondesign.packplanner.model.InputDataVO;
import com.motiondesign.packplanner.model.ItemVO;
import com.motiondesign.packplanner.model.PackPackage;
import com.motiondesign.packplanner.model.PackVO;

public final class PackPlannerServiceImpl implements PackPlannerService {

	private static final PackPlannerService packPlannerService = new PackPlannerServiceImpl();
	
    public static PackPlannerService getInstance() {
        return packPlannerService;
    }

    public PackPackage packCheck(InputDataVO inputData) throws Exception {
        
    	if (inputData == null || inputData.getItemList().isEmpty()) {
            throw new Exception("Exception!");
        }
        
    	sortInputData(inputData);
        
    	return packGenerate(inputData);
    
    }

    private void sortInputData(final InputDataVO inputData) throws Exception {
    
    	if (inputData == null) {
            throw new Exception("Exception!");
        }

        switch (inputData.getSortOrder()) {
            case "SHORT_TO_LONG":
                //Collections.sort(inputData.getItemList());
                break;
            case "LONG_TO_SHORT":
                Collections.reverse(inputData.getItemList());
                break;
            case "NATURAL":
                // Does Nothing
        }
    
    }

    private PackPackage packGenerate(InputDataVO inputData) {

    	PackPackage packStack = new PackPackage();
        PackVO topPack;
        int totalPieces = 0;
        float totalWeight = 0.0f;
        int prePieces = 0;
        
    	int maxPiecesPerPack = inputData.getMaxPieces();
        float maxWeightPerPack = inputData.getMaxWeight();
        
        for (ItemVO item : inputData.getItemList()) {
        	totalPieces += item.getItemQuantity();
        	
        	if (totalPieces < inputData.getMaxPieces()) {
        		topPack = getTopPack(packStack, inputData, false);	
        	}
        	else {
        		item.setItemQuantity(item.getItemQuantity() - (item.getItemQuantity() - (inputData.getMaxPieces() - prePieces)));
        		topPack = getTopPack(packStack, inputData, false);
        	}
        	prePieces = item.getItemQuantity();

        	totalWeight += item.getItemQuantity() * item.getItemWeight();
        	
            float nextPackWeight = topPack.getTotalPackWeight() + item.getItemWeight();
            
            boolean addToTopPack = (maxPiecesPerPack > topPack.getPackPieces() && nextPackWeight <= maxWeightPerPack);
            topPack = getTopPack(packStack, inputData, !addToTopPack);
            topPack.addItem(item);
        }
        
        return packStack;
        
    }
    
    private PackVO getTopPack(PackPackage packPackage, InputDataVO inputData, boolean isNewPack) {
        
    	if (packPackage.isEmpty() || isNewPack) {
    		
        	PackVO pack = new PackVO();
            pack.setPackWeight(inputData.getMaxPieces());
            pack.setPackWeight(inputData.getMaxWeight());
            pack.setPackId(packPackage.getTopPackId() + 1);
            packPackage.addPack(pack);
        }
        
        return packPackage.getTopPack();
        
    }

}
