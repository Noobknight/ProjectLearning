/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.database;

import java.sql.Connection;

/**
 *
 * @author PC
 */
public interface IConnection {
    void loadDriver();  
    Connection connect();
    void close();
    void errorHandler(String message, Exception e);
}
