/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.data;

import com.test.dwp.model.People;
import java.util.List;

/**
 *
 * @author Me
 */
public interface PeopleDao {
    //People findByNo(Integer peopleid);
    List<People> findAll();
    List<People> findByCity(String cityname);
    List<People> findNearLocation(double latitude,  double longitude, double distance, String unit);
    
    //void savePeople(People people);
    //void updatePeople(People people);
    //void deletePeople(Integer peopleid);
    //int peopleIDExists(Integer peopleid);
    //int peopleNameExists(String name);
    
}
