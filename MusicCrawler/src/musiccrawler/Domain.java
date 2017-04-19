/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler;

import java.net.MalformedURLException;
import musiccrawler.validate.Validator;

/**
 *
 * @author Tavv
 */
public class Domain {

    private String urlDomain;

    public Domain(String urlDomain) {
        this.urlDomain = urlDomain;
    }

    public String getUrlDomain() throws MalformedURLException {
        if (Validator.isValidUrl(urlDomain)) {
            return urlDomain;
        }
        throw new MalformedURLException("URL not valid");
    }

    public void setUrlDomain(String urlDomain) {
        this.urlDomain = urlDomain;
    }
}
