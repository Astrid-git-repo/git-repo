package com.master.mCardChallenge.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import com.master.mCardChallenge.exception.MCardException;
import com.master.mCardChallenge.exception.MCardFileException;
import com.master.mCardChallenge.vo.ConnectCityRequestVO;
@Component
public class MCardFileUtil {
	/*
	 * This method will read an input file present in resources in classpath and check if source and destination cities have a Route defined
	 */
	public String getCitiesConnected(ConnectCityRequestVO req) throws MCardException, MCardFileException {
		
		String sourceCity=req.getSource();
		String destCity=req.getDestination();
		
		boolean found=false;
		Map<String,String> cityMap=new ConcurrentHashMap<String,String>();
		try {
			
			/*
			 * Source file city.txt is should on the classpath --If not, IOException will
			 * be thrown back to the controller. //Exception will propagate to the Exception
			 * Handler and get handled accordingly -(Return no in this case)
			 */			
			File file = ResourceUtils.getFile("classpath:city.txt");
			
			
			/*
			 * Process each line in input file and tokenize based on comma-separator //Add
			 * each input path to a hashMap
			 */
			Files.lines(file.toPath()).forEach(line->{
				String[] input=line.split(", ");
				if(StringUtils.trimAllWhitespace(input[0]).length()>0||StringUtils.trimAllWhitespace(input[1]).length()>0)
					cityMap.put(input[0],input[1]);
			});
			
			
		//	Check if path from Source to destination is present
			if(!(found=checkIfPresent(sourceCity, destCity, cityMap)))
				found=checkIfPresent(destCity, sourceCity, cityMap);	//If not, check vice-versa ie. Path from Destination to Source
			
			if(found)
				return "yes";
			else
				return "no";
		} catch (IOException e) {
			String response="no";
			e.printStackTrace();
			throw new MCardFileException(response);
		}
		catch (Exception e) {
			String response="no";
			e.printStackTrace();
			throw new MCardException(response);
		}
	}


	private boolean checkIfPresent(String sourceCity, String destCity, Map<String, String> cityMap) {
		boolean found=false;
		String nextCity=cityMap.get(sourceCity);
		//Navigate through the hashMap to check for path from source to destination till destination is found OR any connecting path ie. Key is not present
		while(nextCity!=null&&!nextCity.equalsIgnoreCase(destCity))
		{
			if(cityMap.containsKey(nextCity))
				nextCity=cityMap.get(nextCity);
			else 
				return false;
		}
		if(nextCity!=null&&nextCity.equalsIgnoreCase(destCity))
			found=true;
		return found;
	}
}
