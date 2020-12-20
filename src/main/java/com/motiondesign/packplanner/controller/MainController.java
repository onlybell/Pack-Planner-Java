package com.motiondesign.packplanner.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.motiondesign.packplanner.model.InputDataVO;
import com.motiondesign.packplanner.model.PackPackage;
import com.motiondesign.packplanner.model.PackVO;
import com.motiondesign.packplanner.service.PackPlannerService;
import com.motiondesign.packplanner.service.PackPlannerServiceImpl;
import com.motiondesign.packplanner.util.ParseData;


@Controller
public class MainController {

	@RequestMapping("/PackPlanner")
	public String packplanner(Model model) {
		
		return "packplanner";
	}
	
	@RequestMapping("/PackCheck")
    public ModelAndView packCheck(InputDataVO inputData) throws Exception{
		ModelAndView mv = new ModelAndView("packcheck");
	
		String[] items = inputData.getItems().split("\\n");
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList(items));

		InputDataVO parseInputData = ParseData.parseInputData(itemList);
		parseInputData.setSortOrder(inputData.getSortOrder());
		parseInputData.setMaxPieces(inputData.getMaxPieces());
		parseInputData.setMaxWeight(inputData.getMaxWeight());
		 
		PackPlannerService packPlanner = PackPlannerServiceImpl.getInstance();
        PackPackage packStack = packPlanner.packCheck(parseInputData);
        String resutlStr = "";
        
        for (PackVO pack : packStack.getPacksList()) {
            if (pack != null) {
            	System.out.println(ParseData.displayFormat(pack));
            	resutlStr += ParseData.displayFormat(pack);
            }
        }
        
        mv.addObject("sortOrder", inputData.getSortOrder());
        mv.addObject("maxPieces", inputData.getMaxPieces());
        mv.addObject("maxWeight", inputData.getMaxWeight());
        mv.addObject("items", inputData.getItems());
        mv.addObject("Package", resutlStr);
        
        return mv;
    }
}