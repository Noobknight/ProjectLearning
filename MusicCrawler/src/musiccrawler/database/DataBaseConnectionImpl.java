/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tavv
 */
public class DataBaseConnectionImpl implements IConnection {

    private static final Logger LOG = Logger.getLogger(DataBaseConnectionImpl.class.getName());

    private static DataBaseConnectionImpl instance;
    private static JDBCConfiguration jdbc;
    private Connection connection;

    public static DataBaseConnectionImpl newInstance() {
        synchronized (DataBaseConnectionImpl.class) {
            if (instance == null) {
                instance = new DataBaseConnectionImpl();
                jdbc = new JDBCConfiguration();
            }
        }
        return instance;
    }

    @Override
    public Connection connect() {
        if (connection == null) {
            try {
                loadDriver();
                connection = DriverManager.getConnection(jdbc.getDbUrl(), jdbc.getUserName(), jdbc.getPassword());
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    @Override
    public void loadDriver() {
        try {
            Class.forName(jdbc.getDriverClass());
        } catch (ClassNotFoundException e) {
            errorHandler(LOG.getName(), e);
        }
    }

    @Override
    public void close() {
        if (connection == null) {
            errorHandler(LOG.getName(), new Exception("not found connection"));
        } else {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                errorHandler(LOG.getName(), e);
            }
        }
    }

    @Override
    public void errorHandler(String message, Exception e) {
        System.out.println(message);
        if (e != null) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
