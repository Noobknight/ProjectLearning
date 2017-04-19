/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import musiccrawler.constant.Constant;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tavv
 */
public class Utils {

    public static JSONObject getJsonResponse(String link) throws IOException, JSONException {
        StringBuilder sBuilder = new StringBuilder();
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(Constant.CONNECT_TIME_OUT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                "UTF-8"), 8);
        String line;
        while ((line = reader.readLine()) != null) {
            sBuilder.append(line).append("\n");
        }
        String result = sBuilder.toString();
        return new JSONObject(result);
    }
    
    public static boolean isNull(Object o){
        return Objects.isNull(o);
    }
    
    public static void addParams(PreparedStatement preparedStatement, Object... params) throws SQLException {
    for (int i = 0; i < params.length; i++) {
        Object param = params[i];
        preparedStatement.setObject(i+1, param);
    }
}

}
