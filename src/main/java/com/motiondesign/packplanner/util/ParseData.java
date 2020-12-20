package com.motiondesign.packplanner.util;

import java.util.List;

import com.motiondesign.packplanner.model.InputDataVO;
import com.motiondesign.packplanner.model.ItemVO;
import com.motiondesign.packplanner.model.PackVO;

public class ParseData {
	
	public static InputDataVO parseInputData(List<String> inputDataList) throws Exception {

		InputDataVO inputData = new InputDataVO();
		
        for (int i = 0; i < inputDataList.size(); i++) {
            String data = inputDataList.get(i);
            inputData.addItem((ItemVO) parseData(data));
        }

        return inputData;
    }
	
	public static ItemVO parseData(String data) throws Exception {
		 
		ItemVO result = new ItemVO();
		
		if (data != null) {
			String[] itemValues = data.split(",");
			
            if (itemValues != null && itemValues.length == 4) {
				result.setItemId(Integer.parseInt(itemValues[0]));
				result.setItemLength(Integer.parseInt(itemValues[1]));
				result.setItemQuantity(Integer.parseInt(itemValues[2]));
				result.setItemWeight(Float.parseFloat(itemValues[3]));
            }
	    }
	    return result;
	}
	
	public static String displayFormat(final PackVO data) {
		
		
        if (data == null) {
            return "\n";
        }
        StringBuilder result = new StringBuilder();
        result.append("Pack Number: ");
        result.append(data.getPackId());
        result.append("<br>");
        for (ItemVO item : data.getItems()) {
            result.append(item.getItemId());
            result.append(", ");
            result.append(item.getItemLength());
            result.append(", ");
            result.append(item.getItemQuantity());
            result.append(", ");
            result.append(item.getItemWeight());
            result.append("<br>");
        }
        result.append("Pack Length: ");
        result.append(data.getTotalPackLength());
        result.append(" m");
        result.append(", ");
        result.append("Pack Weight: ");
        result.append(Math.round(data.getTotalPackWeight()*100)/100.0);
        result.append(" kg");
        result.append("<br><br>");
        
        return result.toString();
    }

}
