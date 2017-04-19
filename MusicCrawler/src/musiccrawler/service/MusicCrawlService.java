/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import musiccrawler.ConnectionBuilder;
import musiccrawler.Domain;
import musiccrawler.common.HtmlToolFix;
import musiccrawler.constant.Constant;
import musiccrawler.model.Music;
import musiccrawler.model.Singer;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;

/**
 *
 * @author Tavv
 */
public class MusicCrawlService {

    private static final Logger LOG = Logger.getLogger(MusicCrawlService.class.getName());

    private final Domain domain;

    public MusicCrawlService(Domain domain) {
        this.domain = domain;
    }

    public <T extends Music> List<T> getListMusicHotVn() {
        List<T> musics = new ArrayList<>();
        try {
            Connection builder = new ConnectionBuilder(domain.getUrlDomain()).build();
            Document document = builder.get();
            document.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            Element rootNodeVnHot = document.select(".h-main4").first();
            Elements elesVnTopHot = rootNodeVnHot.select(".list-r.list-1");
            elesVnTopHot.forEach(element -> {
                String avatar = element.select(".texte1x").first().children().attr("src");
                Elements eles = element.select(".text2.text2x").first().children();
                String link = eles.attr("href");
                String description = element.attr("title");
                String title = eles.get(0).text();
                String singerName = eles.get(1).text();
                String id = HtmlToolFix.fixId(link);
                String quality = element.select(".texte2.texte2x span").text();
                Singer singer = new Singer(id, singerName, 0, Constant.EMPTY, avatar);
                T music = (T) getLinkStream(link, false);
                music.setUrl(link);
                music.setDescription(description);
                music.setTitle(title);
                music.setSinger(singer);
                music.setId(id);
                music.setStrQuality(quality);
                musics.add(music);
            });
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return musics;
    }

    public Music getLinkStream(String url, boolean isOnlyStream) {
        Music music = new Music();
        try {
            Connection builder = new ConnectionBuilder(url).build();
            Document document = builder.get();
            String scriptNode = document.select("script").toString();
            String temp = HtmlToolFix.searchStreamLink(scriptNode);
            String link = HtmlToolFix.fixLinkStream(temp);
            if (!isOnlyStream) {
                String lyric = getLyric(document);
                music.setLyric(lyric);
            }
            music.setStream(link);
        } catch (IOException ex) {
            Logger.getLogger(MusicCrawlService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return music;
    }

    private String getLyric(Document doc) {
        String nodeLyric = doc.select("p.genmed").toString();
        return HtmlToolFix.fixLyric(nodeLyric);
    }

}
