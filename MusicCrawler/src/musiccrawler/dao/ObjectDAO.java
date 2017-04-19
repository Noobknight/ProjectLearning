/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.dao;

import java.util.Map;

/**
 *
 * @author PC
 */
public interface ObjectDAO {
    
    boolean insert(String queryMusic, String querySinger, Map<String, Object> params);
    
    boolean update(String query, Object[] params);
    
    boolean delete(String id);
    
    
    
}
