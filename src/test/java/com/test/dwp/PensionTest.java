/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp;

import com.test.dwp.controller.PeopleController;
import com.test.dwp.model.People;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *
 * @author Me
 */
public class PensionTest  extends AbstractTest{
    
//    @Test
//    public void getPeopleList() throws Exception {
//       //String uri = "/products";
//       String uri = "/people/peoplelist";
//       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//          .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//       int status = mvcResult.getResponse().getStatus();
//       assertEquals(200, status);
//       String content = mvcResult.getResponse().getContentAsString();
//       People[] peoplelist = super.mapFromJson(content, People[].class);
//       assertTrue(peoplelist.length > 0);
//    }
//    
    
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
        assertEquals(people.getId(), result.get(1000).getId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
    
    
    
}
