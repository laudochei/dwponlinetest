/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.data;

import com.test.dwp.model.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laud.Ochei
 */

@Repository
public class MessageDaoImpl implements MessageDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
            this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
        
        
        @Override
	public Msg GetMessage(String successMsg) {
            Msg mg = new Msg();
            mg.setMessage(successMsg);
            return mg;
	}
        
        
        
    
        
      

}