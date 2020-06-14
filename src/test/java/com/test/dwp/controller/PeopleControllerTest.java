/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.controller;

import com.test.dwp.model.People;
import com.test.dwp.service.MessageService;
import com.test.dwp.service.PeopleService;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Me
 */
public class PeopleControllerTest {
    
    public PeopleControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setMessageService method, of class PeopleController.
     */
    @Test
    public void testSetMessageService() {
        System.out.println("setMessageService");
        MessageService messageService = null;
        PeopleController instance = new PeopleController();
        instance.setMessageService(messageService);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeopleService method, of class PeopleController.
     */
    @Test
    public void testSetPeopleService() {
        System.out.println("setPeopleService");
        PeopleService peopleService = null;
        PeopleController instance = new PeopleController();
        instance.setPeopleService(peopleService);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listPeople method, of class PeopleController.
     */
    @Test
    public void testListPeople() {
        System.out.println("listPeople");
        PeopleController instance = new PeopleController();
        //List<People> expResult = null;
        List <People> expResult = new ArrayList <People> ();
        People people = new People();
        people.setId(1000);    
        people.setFirst_name("Ches");       
        people.setLast_name("Ertelt");
        people.setEmail("certeltrr@comsenz.com");
        people.setIp_address("214.255.59.57");
        people.setLatitude(28.685244);
        people.setLongitude(80.621591);
        expResult.add(people);    
        List<People> result = instance.listPeople();
        assertEquals(expResult.get(0).getFirst_name(), result.get(1000).getFirst_name());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listPeopleByCity method, of class PeopleController.
     */
    @Test
    public void testListPeopleByCity() throws Exception {
        System.out.println("listPeopleByCity");
        String cityname = "";
        PeopleController instance = new PeopleController();
        List<People> expResult = null;
        List<People> result = instance.listPeopleByCity(cityname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listPeopleNearLocation method, of class PeopleController.
     */
    @Test
    public void testListPeopleNearLocation() throws Exception {
        System.out.println("listPeopleNearLocation");
        double latitude = 0.0;
        double longitude = 0.0;
        String unit = "";
        double distancelimit = 0.0;
        PeopleController instance = new PeopleController();
        List<People> expResult = null;
        List<People> result = instance.listPeopleNearLocation(latitude, longitude, unit, distancelimit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listPeopleWithinNearLocation method, of class PeopleController.
     */
    @Test
    public void testListPeopleWithinNearLocation() throws Exception {
        System.out.println("listPeopleWithinNearLocation");
        String city = "";
        double latitude = 0.0;
        double longitude = 0.0;
        String unit = "";
        double distancelimit = 0.0;
        PeopleController instance = new PeopleController();
        List<People> expResult = null;
        List<People> result = instance.listPeopleWithinNearLocation(city, latitude, longitude, unit, distancelimit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
