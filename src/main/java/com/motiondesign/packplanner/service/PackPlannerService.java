package com.motiondesign.packplanner.service;

import com.motiondesign.packplanner.model.InputDataVO;
import com.motiondesign.packplanner.model.PackPackage;

/**
 * Service to plan packs
 */
public interface PackPlannerService {
	PackPackage packCheck(final InputDataVO inputData) throws Exception;
}
