/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.service;

import com.test.dwp.data.MessageDao;
import com.test.dwp.model.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laud.Ochei
 */

@Service("MessageService")
public class MessageServiceImpl implements MessageService {

        MessageDao messageDao;
	@Autowired
	public void setMessaageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

        @Override
        public Msg GetMessage(String msg) {
            return messageDao.GetMessage(msg);
        }
        
        
}