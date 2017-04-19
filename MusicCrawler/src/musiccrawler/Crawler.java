/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler;

import java.util.ArrayList;
import java.util.List;
import musiccrawler.constant.Constant;
import musiccrawler.model.Music;
import musiccrawler.service.MusicCrawlService;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Tavv
 * @param <T>
 */
public class Crawler<T> {

    private List<T> data;
    private String urlDomain;
    private Domain domain;
    private MusicCrawlService service;

    public Crawler(String urlDomain) {
        this.urlDomain = urlDomain;
    }

    public Crawler build() {
        if (StringUtils.isNotBlank(urlDomain)) {
            domain = new Domain(urlDomain);
            service = new MusicCrawlService(domain);
        }
        return this;
    }

    public List<Music> getMusicHotVn() {
        return service.getListMusicHotVn();
    }

    public List<String> getListStream(List<String> musicIds, String path) {
        String baseDomain = Constant.URLConst.BASE_DOMAIN;
        List<String> streams = new ArrayList<>();
        if (musicIds != null && !musicIds.isEmpty()) {
            musicIds.forEach(id -> {
                String url = baseDomain + String.format(Constant.URLConst.URL_MUSIC_TEMP, path, id);
                String stream = service.getLinkStream(url, true).getStream();
                streams.add(stream);
            });
        }
        return streams;
    }
    
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getUrlDomain() {
        return urlDomain;
    }

    public void setUrlDomain(String urlDomain) {
        this.urlDomain = urlDomain;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public MusicCrawlService getService() {
        return service;
    }

    public void setService(MusicCrawlService service) {
        this.service = service;
    }

}
