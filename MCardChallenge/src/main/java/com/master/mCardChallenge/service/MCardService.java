package com.master.mCardChallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.mCardChallenge.dao.MCardFileInputDAO;
import com.master.mCardChallenge.exception.MCardException;
import com.master.mCardChallenge.exception.MCardFileException;
import com.master.mCardChallenge.vo.ConnectCityRequestVO;

@Service
public class MCardService {

	@Autowired
	private MCardFileInputDAO mCardFileInputDAO;
	
	public String getCitiesConnected(ConnectCityRequestVO cityVO) throws MCardException, MCardFileException {
		return mCardFileInputDAO.getCitiesConnected(cityVO);
		
	}
}
