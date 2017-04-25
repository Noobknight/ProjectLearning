package com.tvo.indianproject.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Tavv
 * on 24/04/2017.
 */

public class JsonUtils {
    public static JSONObject getJsonResponse(String link) throws IOException, JSONException {
        StringBuilder sBuilder = new StringBuilder();
        String result = "";
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(30000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                "UTF-8"), 8);
        String line = null;
        while ((line = reader.readLine()) != null) {
            sBuilder.append(line).append("\n");
        }
        result = sBuilder.toString();
        return new JSONObject(result);
    }

}
