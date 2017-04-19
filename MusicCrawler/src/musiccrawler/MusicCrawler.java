/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import musiccrawler.common.LoadJdbcResource;
import musiccrawler.common.Utils;
import musiccrawler.constant.Constant;
import musiccrawler.constant.JdbcResourceConstant;
import musiccrawler.dao.DAOImpl;
import musiccrawler.database.DataBaseConnectionImpl;
import musiccrawler.model.Music;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author PC
 */
public class MusicCrawler {

    public static Properties props;
    public static Connection connection;
    public static DataBaseConnectionImpl database;
    public JdbcResourceConstant resourceConstant;
    public DAOImpl objectDao;

    public void init() {
        database = DataBaseConnectionImpl.newInstance();
        connection = database.connect();
        props = LoadJdbcResource.newInstance().getProperties();
        resourceConstant = new JdbcResourceConstant(props);
        objectDao = new DAOImpl(connection);
    }

    public List<Music> crawl(String path) {
        Crawler<Music> crawler = new Crawler(Constant.URLConst.BASE_DOMAIN + path).build();
        List<Music> musics = crawler.getMusicHotVn();
        musics.forEach(music -> {
            Map<String, Object> params = settingParams(music);
            objectDao.insert(resourceConstant.SQL_INSERT_OR_UPDATE_MUSIC, resourceConstant.SQL_INSERT_OR_UPDATE_SINGER, params);
        });
        return musics;
    }

    public List<String> getAllMusicId() {
        return objectDao.getAllMusicId(resourceConstant.SQL_GET_ALL_MUSIC_ID);
    }

    public List<Music> getMusicByOption(Map<String, String> values) {
        List<Music> music = null;
        if (values != null) {
            String key = values.get("condition");
            String value = values.get("value");
            if (!StringUtils.isBlank(key)) {
                music = objectDao.getMusicByOption(resourceConstant.SQL_GET_MUSIC_BY_OPTION, key, value);
            }
        }
        return music;
    }

    public Map<String, List<String>> getNewStream(String path) {
        Map<String, List<String>> maps = new HashMap<>();
        Crawler<Music> crawler = new Crawler(path).build();
        List<String> musicIds = getAllMusicId();
        List<String> listStream = crawler.getListStream(musicIds, crawler.getUrlDomain());
        maps.put("id", musicIds);
        maps.put("stream", listStream);
        return maps;
    }

    public void updateNewStreamToDB(List<String> musicIds, List<String> listStream) {
        for (int i = 0; i < musicIds.size(); i++) {
            objectDao.updateStream(resourceConstant.SQL_UPDATE_STREAM, musicIds.get(i), listStream.get(i));
        }
    }

    public List<Music> getAllMusic() {
        return objectDao.getAllMusic(resourceConstant.SQL_GET_ALL_MUSIC);
    }
    public Map<String, List<String>> reCrawlLinkStream(String path) {
        Map<String, List<String>> results = getNewStream(path);
        List<String> musicIds = results.get("id");
        List<String> listStream = results.get("stream");
        if (CollectionUtils.isNotEmpty(musicIds) && CollectionUtils.isNotEmpty(listStream)) {
            updateNewStreamToDB(musicIds, listStream);
        }
        return results;
    }
    
    public Map<String, Object> settingParams(Music music) {
        Map<String, Object> params = new HashMap<>();
        params.put("music_id", music.getId());
        params.put("title", music.getTitle());
        params.put("image", music.getImage());
        params.put("url", music.getUrl());
        params.put("lyric", music.getLyric());
        params.put("description", music.getDescription());
        params.put("stream", music.getStream());
        params.put("quality", music.getQualityType().toString());
        params.put("music_id", music.getId());
        params.put("name", music.getSinger().getName());
        params.put("age", music.getSinger().getAge());
        params.put("description", music.getSinger().getDescription());
        params.put("avatar", music.getSinger().getAvatar());
        return params;
    }

    public static void main(String[] args) {
        String test = "\"Yeu";
        String regex = "^\"|\"$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(test);
        System.out.println(test);
        if(m.find()){
            System.out.println(test.replaceAll(regex, ""));
        }
    }
    
}
