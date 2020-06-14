/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.service;

import com.test.dwp.model.People;
import java.util.List;

/**
 *
 * @author Me
 */
public interface PeopleService {
    List<People> findAll();
    List<People> findByCity(String cityname);
    List<People> findNearLocation(double latitude,  double longitude, double distance, String unit);
}
