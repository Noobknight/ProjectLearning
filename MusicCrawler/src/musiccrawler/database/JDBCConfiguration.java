/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musiccrawler.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tavv
 */
public class JDBCConfiguration {
    
    private String driverClass;
    private String dbUrl;
    private String userName;
    private String password;
    
    public JDBCConfiguration(){
        loadConfig();
    }
    
    private void loadConfig(){
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("configdatabase.properties");
            props.load(fis);
            driverClass = props.getProperty("DB_DRIVER_CLASS");
            dbUrl = props.getProperty("DB_URL");
            userName = props.getProperty("DB_USERNAME");
            password = props.getProperty("DB_PASSWORD");
        }catch (IOException e) {
            Logger.getLogger(JDBCConfiguration.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    
    
}
