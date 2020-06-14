/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dwp.data;

import com.test.dwp.model.Msg;

/**
 *
 * @author Laud.Ochei
 */
public interface MessageDao {
    Msg GetMessage(String msg);
    
}
