package com.test.dwp;

import com.test.dwp.controller.PeopleController;
import com.test.dwp.model.People;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PensionApplicationTests {
        @Autowired
        private PeopleController controller;
    
    
	@Test
	void contextLoads() {
            Assertions.assertNotNull(controller);
	}
        
        
        
    @Test
    public void testListPeople() {
        System.out.println("listPeople");
        //PeopleController instance = new PeopleController();
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
        List<People> result = controller.listPeople();
        System.out.println("ListPeople :" + result.get(0).getFirst_name());
        
        assertEquals(people.getId(), result.get(999).getId());
        assertEquals(1000, result.size());
        assertEquals(1, 1);
       
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    
    @Test
    public void testListPeopleByCity() throws Exception {
        System.out.println("listPeopleByCity");
        String cityname = "London";
        //PeopleController instance = new PeopleController();
        List<People> expResult = null;
        List<People> result = controller.listPeopleByCity("London");
        assertEquals(6, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
    @Test
    public void testListPeopleNearLocation() throws Exception {
        System.out.println("listPeopleNearLocation");
        double latitude = 51.5074;
        double longitude = -0.1278;
        String unit = "M";
        double distancelimit = 50.0;
        //PeopleController instance = new PeopleController();
        //List<People> expResult = null;
        List<People> result = controller.listPeopleNearLocation(latitude, longitude, unit, distancelimit);
        assertEquals(3, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @org.junit.Test
    public void testListPeopleWithinNearLocation() throws Exception {
        System.out.println("listPeopleWithinNearLocation");
        String city = "London";
        double latitude = 51.5074;
        double longitude = -0.1278;
        String unit = "M";
        double distancelimit = 50.0;
        //List<People> expResult = null;
        List<People> result = controller.listPeopleWithinNearLocation(city, latitude, longitude, unit, distancelimit);
        assertEquals(9, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
}
