/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.controller;

import com.test.dwp.exception.MessageException;
import com.test.dwp.model.People;
import com.test.dwp.service.MessageService;
import com.test.dwp.service.PeopleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

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
        
        
        // display users by city. Use capital letters for the first character  
        @RequestMapping(value = "/city/{cityname}/users", method = RequestMethod.GET)
	public List<People> listPeopleByCity(@PathVariable("cityname") String cityname) throws MessageException {
            List<People> people = peopleService.findByCity(cityname);
            if (people.size() == 0) {
                throw new MessageException("No record found for city name " + cityname);
            }
            return people;
        }
        
    
        @RequestMapping(value = "/city/London/{distancelimitinmiles}/users", method = RequestMethod.GET)
	public List<People> listPeopleNearLondon(@PathVariable("distancelimitinmiles") double distancelimitinmiles) throws MessageException {
            // get people living in London
            List<People> peoplein = peopleService.findByCity("London");
            
            // get people living within a specified distance of a particular position
            List<People> peoplewithin = peopleService.findNearLocation(distancelimitinmiles, "M");
            
            // combine the two list and exclude duplicates 
            for (int i = 0; i<peoplewithin.size(); i++){
                if(!peoplein.contains(peoplewithin.get(i)))
                    peoplein.add(peoplewithin.get(i));
            }
            
            if (peoplein.size() == 0) {
                throw new MessageException("No record found for people within 50 miles of London");
            }
            return peoplein;
        }
        
        
        
        
        
}
