/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.constant;

import java.util.Properties;

/**
 *
 * @author Tavv
 */
public class JdbcResourceConstant {

    public final String SQL_INSERT_MUSIC;
    public final String SQL_INSERT_SINGER;
    public final String SQL_DELETE_MUSIC;
    public final String SQL_UPDATE_STREAM;
    public final String SQL_GET_ALL_MUSIC_ID;
    public final String SQL_INSERT_OR_UPDATE_MUSIC;
    public final String SQL_INSERT_OR_UPDATE_SINGER;
    public final String SQL_GET_MUSIC_BY_OPTION;
    public final String SQL_GET_ALL_MUSIC;
    
    
    public JdbcResourceConstant(Properties props) {
        SQL_INSERT_MUSIC = props.getProperty("INSERT_MUSIC");
        SQL_INSERT_SINGER = props.getProperty("INSERT_SINGER");
        SQL_DELETE_MUSIC = props.getProperty("DELETE_MUSIC");
        SQL_UPDATE_STREAM = props.getProperty("UPDATE_LINK_STREAM");
        SQL_GET_ALL_MUSIC_ID = props.getProperty("GET_ALL_ID_MUSIC");
        SQL_INSERT_OR_UPDATE_MUSIC = props.getProperty("INSERT_OR_UPDATE_MUSIC");
        SQL_INSERT_OR_UPDATE_SINGER = props.getProperty("INSERT_OR_UPDATE_SINGER");
        SQL_GET_MUSIC_BY_OPTION = props.getProperty("GET_MUSIC_BY_OPTION");
        SQL_GET_ALL_MUSIC = props.getProperty("GET_ALL_MUSIC");
    }

}
