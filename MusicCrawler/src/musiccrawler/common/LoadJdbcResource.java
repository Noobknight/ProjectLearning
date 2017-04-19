/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musiccrawler.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tavv
 */
public class LoadJdbcResource {
    
    private static Properties props;
    
    private static LoadJdbcResource instance;
    
    
    public static LoadJdbcResource newInstance(){
        if(instance == null){
            instance = new LoadJdbcResource();
            props = instance.loadResource();
        }
        return instance;
    }
    
    private Properties loadResource(){
        Properties properties = null;
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("JdbcQuery.properties");
            properties.load(fis);
        } catch (IOException ex) {
            Logger.getLogger(LoadJdbcResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }
    
    public Properties getProperties(){
        return props;
    }
}
