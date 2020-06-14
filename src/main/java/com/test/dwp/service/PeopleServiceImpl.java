/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.service;

import com.test.dwp.data.PeopleDao;
import com.test.dwp.model.People;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laud.c.ochei
 */



@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
	PeopleDao peopleDao;

	@Autowired
	public void setPeopleDao(PeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}

        
        @Override
	public List<People> findAll() {
            return peopleDao.findAll();
	}
        
        @Override
	public List<People> findByCity(String cityname) {
            return peopleDao.findByCity(cityname);
	}
        
        
        @Override
	public List<People> findNearLocation(double latitude,  double longitude, double distance, String unit) {
            return peopleDao.findNearLocation(latitude, longitude, distance, unit);
	}
}

