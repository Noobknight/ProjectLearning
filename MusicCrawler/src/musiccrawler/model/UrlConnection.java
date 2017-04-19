/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.model;

import musiccrawler.ConnectionBuilder;
import musiccrawler.constant.Constant;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author Tavv
 */
public class UrlConnection {

    private final String url;
    private final String userAgent;
    private final int timeOut;

    public UrlConnection(ConnectionBuilder builder) {
        this.url = builder.url;
        this.userAgent = builder.userAgent;
        this.timeOut = builder.timeOut;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public Connection settings() {
        Connection connection = Jsoup.connect(url);
        connection.userAgent(StringUtils.isBlank(userAgent) ? Constant.USER_AGENT_BROWSER : userAgent);
        connection.timeout(timeOut == 0 ? Constant.CONNECT_TIME_OUT : timeOut);
        return connection;
    }
}
