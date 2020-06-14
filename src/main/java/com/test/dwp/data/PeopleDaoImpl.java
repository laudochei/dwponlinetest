/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.data;

//import com.sphera.model.Availproducts;
//import com.sphera.model.Bar;
//import com.sphera.model.ComposeOrder;
//import com.sphera.model.Ordered;
//import com.sphera.model.Price;
//import com.sphera.model.Product;
//import com.sphera.model.Round;
//import com.sphera.service.OrderedService;
import com.test.dwp.model.People;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author laud.c.ochei
 */

@Repository
public class PeopleDaoImpl implements PeopleDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    DataSource dataSource;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


//    private OrderedService orderedService;
//    @Autowired
//    public void setProjectDataService(OrderedService orderedService) {
//        this.orderedService = orderedService;
//    }


    public static HashMap < String, String > searchvalue = new HashMap < > ();
    public static HashMap < String, String > searchcond = new HashMap < > ();
    ArrayList < String > searchoperator = new ArrayList < String > ();


    //NOTE: THE ASSUMPTION IS THAT ITEMS ARE ALREADY SETUP, AND THE CUSTOMER JUST HAS TO COMPOSE

    @Override
    public List<People> findAll() {
        
        List <People> peoplelist = new ArrayList <People> ();
        
        final String uri = "https://bpdts-test-app.herokuapp.com/users";
        RestTemplate restTemplate = new RestTemplate();
        
        People[] result = restTemplate.getForObject(uri, People[].class);
        int lenghtRes = restTemplate.getForObject(uri, People[].class).length;
        //System.out.println("Length of Items: " + lenghtRes);
        
        for (int i=0; i<result.length; i++){
            People people = new People();
            people.setId(result[i].getId());    
            people.setFirst_name(result[i].getFirst_name());       
            people.setLast_name(result[i].getLast_name());
            people.setEmail(result[i].getEmail());
            people.setIp_address(result[i].getIp_address());
            people.setLatitude(result[i].getLatitude());
            people.setLongitude(result[i].getLongitude());
            peoplelist.add(people);    
            
        }
        
        return peoplelist;
    }


    
    @Override
    public List<People> findByCity(String cityname) {
        
        List <People> peoplelist = new ArrayList <People> ();
        final String uri = "https://bpdts-test-app.herokuapp.com/city/" + cityname + "/users";
        RestTemplate restTemplate = new RestTemplate();
        People[] result = restTemplate.getForObject(uri, People[].class);
        
        for (int i=0; i<result.length; i++){
            People people = new People();
            people.setId(result[i].getId());    
            people.setFirst_name(result[i].getFirst_name());       
            people.setLast_name(result[i].getLast_name());
            people.setEmail(result[i].getEmail());
            people.setIp_address(result[i].getIp_address());
            people.setLatitude(result[i].getLatitude());
            people.setLongitude(result[i].getLongitude());
            peoplelist.add(people);    
        }
        
        return peoplelist;
    }
 
    
    
    @Override
    public List<People> findNearLocation(double latitude,  double longitude, double distancelimit, String unit) {
        
        List <People> peoplelist = new ArrayList <People> ();
        final String uri = "https://bpdts-test-app.herokuapp.com/users";
        RestTemplate restTemplate = new RestTemplate();
        People[] result = restTemplate.getForObject(uri, People[].class);
        
        for (int i=0; i<result.length; i++){
            double distance = distance(latitude, longitude, result[i].getLatitude(), result[i].getLongitude(), unit); 
            if (distance <= distancelimit) {
                People people = new People();
                people.setId(result[i].getId());    
                people.setFirst_name(result[i].getFirst_name());       
                people.setLast_name(result[i].getLast_name());
                people.setEmail(result[i].getEmail());
                people.setIp_address(result[i].getIp_address());
                people.setLatitude(result[i].getLatitude());
                people.setLongitude(result[i].getLongitude());
                peoplelist.add(people); 
            }
        }
        return peoplelist;
    }

    
    
    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
            if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
            }
            else {
		double theta = lon1 - lon2;
		double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;
		if (unit.equals("K")) {
                    dist = dist * 1.609344;
		} else if (unit.equals("N")) {
                    dist = dist * 0.8684;
		}
		return (dist);
            }
	}
    

}