package com.master.mCardChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.mCardChallenge.exception.MCardException;
import com.master.mCardChallenge.exception.MCardFileException;
import com.master.mCardChallenge.service.MCardService;
import com.master.mCardChallenge.vo.ConnectCityRequestVO;

@RestController
public class MCardController {
	
	@Autowired
	private MCardService mCardService;
	
	/*
	 * Mapping to check if source and destination cities provided in request query parameters are connected
	 * 
	 */
	@GetMapping(path="/connected")
	@ResponseBody
	public String getConnectedCities(@RequestParam String origin,@RequestParam String destination) throws MCardException, MCardFileException
	{
		
		ConnectCityRequestVO request=new ConnectCityRequestVO();
		String trimOrig=StringUtils.trimWhitespace(origin);
		String trimDest=StringUtils.trimWhitespace(destination);
		String response="no";
		if(trimOrig.length()>0&&trimDest.length()>0)
		{
			request.setSource(trimOrig);
			request.setDestination(trimDest);
			response=mCardService.getCitiesConnected(request);
		}
		
		
		return response;
	}

}
