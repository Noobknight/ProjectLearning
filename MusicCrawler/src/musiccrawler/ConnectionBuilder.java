/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler;

import musiccrawler.model.UrlConnection;
import org.jsoup.Connection;

/**
 *
 * @author Tavv
 */
public class ConnectionBuilder {

    public String url;
    public String userAgent;
    public int timeOut;

    public ConnectionBuilder(String url) {
        this.url = url;
    }

    public ConnectionBuilder setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public ConnectionBuilder setTimeOut(int timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public Connection build() {
        return new UrlConnection(this).settings();
    }

}
