package com.test.dwp;

import com.test.dwp.controller.PeopleController;
import com.test.dwp.model.People;
import java.util.ArrayList;
import java.util.List;
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
        assertEquals(people.getId(), result.get(999).getId());
        assertEquals(1000, result.size());
        
    }

    
    
    @Test
    public void testListPeopleByCity() throws Exception {
        System.out.println("listPeopleByCity");
        List<People> result = controller.listPeopleByCity("London");
        assertEquals(6, result.size());
    }
    
    
    @Test
    public void testListPeopleNearLondon() throws Exception {
        System.out.println("listPeopleWithinNearLocation");
        double distancelimit = 50.0;
        List<People> result = controller.listPeopleNearLondon(distancelimit);
        assertEquals(9, result.size());
    }
    
    
    
}
