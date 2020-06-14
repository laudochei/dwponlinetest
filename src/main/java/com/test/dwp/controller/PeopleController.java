/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.dwp.exception.MessageException;
import com.test.dwp.model.Location;
import com.test.dwp.model.People;
import com.test.dwp.service.MessageService;
import com.test.dwp.service.PeopleService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Me
 */


@ControllerAdvice
@RestController
@RequestMapping(value = "/people")
public class PeopleController {
    
        private MessageService messageService;
	@Autowired
	public void setMessageService(MessageService messageService) {
            this.messageService = messageService;
	}
        
        
        private PeopleService peopleService;
	@Autowired
	public void setPeopleService(PeopleService peopleService) {
            this.peopleService = peopleService;
	}
        
        
        @RequestMapping(value = "/peoplelist", method=GET)
        public List<People> listPeople() {
            return peopleService.findAll();
        }
        
        
        // display users by city
        // use capital letters for the first character  
        @RequestMapping(value = "/city/{cityname}/users", method = RequestMethod.GET)
	public List<People> listPeopleByCity(@PathVariable("cityname") String cityname) throws MessageException {
            List<People> people = peopleService.findByCity(cityname);
            if (people.size() == 0) {
                throw new MessageException("No record found for city name " + cityname);
            }
            return people;
        }
        
        
        
        // get people living within a specified distance of a particular  position
        @RequestMapping(value = "/{latitude}/{longitude}/{distancelimit}/{unit}/users", method = RequestMethod.GET)
	public List<People> listPeopleNearLocation(@PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude, @PathVariable("unit") String unit, @PathVariable("distancelimit") double distancelimit) throws MessageException { 
            // get people living within a specified distance of a particular position
            List<People> peoplewithin = peopleService.findNearLocation(latitude,  longitude, distancelimit, unit);
            
            if (peoplewithin.size() == 0) {
                throw new MessageException("No record found for people living within a specified distance of a particular  position: " + latitude + "(latitude)" + " : " + longitude + "(longitude)" + " distance: " + distancelimit);
            }
            return peoplewithin;
        }
        
        // get people living in London, or within a 50 miles of London       
        @RequestMapping(value = "/{city}/{latitude}/{longitude}/{distancelimit}/{unit}/users", method = RequestMethod.GET)
	public List<People> listPeopleWithinNearLocation(@PathVariable("city") String city, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude, @PathVariable("unit") String unit, @PathVariable("distancelimit") double distancelimit) throws MessageException {
            // get people living in London
            List<People> peoplein = peopleService.findByCity(city);
            
            // get people living within a specified distance of a particular position
            List<People> peoplewithin = peopleService.findNearLocation(latitude,  longitude, distancelimit, unit);
            
            // combine the two list and exclude duplicates 
            List<People> peoplelist = new ArrayList<People>();
            for (int i = 0; i<peoplewithin.size(); i++){
                if(!peoplein.contains(peoplewithin.get(i)))
                    peoplein.add(peoplewithin.get(i));
            }
            
            if (peoplein.size() == 0) {
                throw new MessageException("No record found for people near specified location with cordinates: " + latitude + "(latitude)" + " : " + longitude + "(longitude)");
            }
            return peoplein;
        }
        
        
        
        
}
