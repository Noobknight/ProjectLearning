/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import musiccrawler.common.Utils;
import musiccrawler.constant.Constant;
import musiccrawler.model.Music;
import musiccrawler.model.Singer;

/**
 *
 * @author Tavv
 */
public class DAOImpl implements ObjectDAO {

    private final Connection connection;

    public DAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insert(String queryMusic, String querySinger, Map<String, Object> params) {
        boolean success;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryMusic);
            preparedStatement.setString(1, (String) params.get("music_id"));
            preparedStatement.setString(2, (String) params.get("title"));
            preparedStatement.setString(3, (String) params.get("image"));
            preparedStatement.setString(4, (String) params.get("url"));
            preparedStatement.setString(5, (String) params.get("lyric"));
            preparedStatement.setString(6, (String) params.get("description"));
            preparedStatement.setString(7, (String) params.get("stream"));
            preparedStatement.setString(8, (String) params.get("quality"));
            int count = preparedStatement.executeUpdate();
            success = count > 0;
            if (success) {
                preparedStatement = connection.prepareStatement(querySinger);
                preparedStatement.setString(1, (String) params.get("music_id"));
                preparedStatement.setString(2, (String) params.get("name"));
                preparedStatement.setInt(3, (int) params.get("age"));
                preparedStatement.setString(4, (String) params.get("description"));
                preparedStatement.setString(5, (String) params.get("avatar"));
                count = preparedStatement.executeUpdate();
                success = count > 0;
            }
        } catch (SQLException ex) {
            success = false;
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean update(String query, Object[] params) {
        return true;
    }

    @Override
    public boolean delete(String id) {
        return true;
    }

    public int updateStream(String query, String id, String stream) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Utils.addParams(preparedStatement, stream, id);
            int count = preparedStatement.executeUpdate();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Music> getMusicByOption(String query, String whereClause, String value) {
        List<Music> musics = new ArrayList<>();
        try {
            String validQuery;
            if (whereClause.contains("id")) {
                validQuery = query.replace("$column_name", whereClause).replace("$operator", "=");
            } else {
                validQuery = query.replace("$column_name", whereClause).replace("$operator", "LIKE");
                value = "%" + value + "%";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(validQuery);
            Utils.addParams(preparedStatement, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String music_id = resultSet.getString("music_id");
                String title = resultSet.getString("title");
                String image = resultSet.getString("image");
                String url = resultSet.getString("url");
                String lyric = resultSet.getString("lyric");
                String description = resultSet.getString("description");
                String stream = resultSet.getString("stream");
                String quality = resultSet.getString("quality");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String desSinger = resultSet.getString("description");
                String avatar = resultSet.getString("avatar");
                Singer singer = new Singer(music_id, name, age, desSinger, avatar);
                musics.add(new Music(music_id, title, image, url, lyric, description, singer, quality, stream));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return musics;
    }

    public List<Music> getAllMusic(String query) {
        List<Music> musics = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String music_id = resultSet.getString("music_id");
                String title = resultSet.getString("title");
                String image = resultSet.getString("image");
                String url = resultSet.getString("url");
                String lyric = resultSet.getString("lyric");
                String description = resultSet.getString("description");
                String stream = resultSet.getString("stream");
                String quality = resultSet.getString("quality");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String desSinger = resultSet.getString("description");
                String avatar = resultSet.getString("avatar");
                Singer singer = new Singer(music_id, name, age, desSinger, avatar);
                musics.add(new Music(music_id, title, Constant.EMPTY, url, lyric, description, singer, quality, stream));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return musics;
    }

    public List<String> getAllMusicId(String query) {
        List<String> listMusicIds = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("music_id");
                listMusicIds.add(id);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listMusicIds;
    }

}
