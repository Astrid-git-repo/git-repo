package com.master.mCardChallenge.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.master.mCardChallenge.exception.MCardException;
import com.master.mCardChallenge.exception.MCardFileException;
import com.master.mCardChallenge.vo.ConnectCityRequestVO;

@Component
public class MCardFileInputDAO {

	@Autowired
	MCardFileUtil mCardFileUtil;
	
	public String getCitiesConnected(ConnectCityRequestVO request) throws MCardException, MCardFileException {
		
		
		String found=mCardFileUtil.getCitiesConnected(request);
		
		return found;
		
		
		
	}
}
