/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.model;

import musiccrawler.constant.Constant;
import musiccrawler.constant.MusicQualityType;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Tavv
 */
public class Music {

    private String id;
    private String title;
    private String image;
    private String url;
    private String lyric;
    private MusicQualityType qualityType;
    private String description;
    private Singer singer;
    private String strQuality;
    private String stream;

    public Music() {
    }

    /**
     * @param id
     * @param title
     * @param image
     * @param url
     * @param lyric
     * @param description
     * @param singer
     * @param strQuality
     * @param stream 
     */
    public Music(String id, String title, String image, String url, String lyric, String description, Singer singer, String strQuality, String stream) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.url = url;
        this.lyric = lyric;
        this.description = description;
        this.singer = singer;
        this.strQuality = strQuality;
        this.stream = stream;
    }
    /**
     * @param id
     * @param title
     * @param image
     * @param url
     * @param lyric
     * @param qualityType
     * @param description
     * @param singer
     * @param strQuality
     */
    public Music(String id, String title, String image, String url, String lyric, MusicQualityType qualityType, String description, Singer singer, String strQuality) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.url = url;
        this.lyric = lyric;
        this.qualityType = qualityType;
        this.description = description;
        this.singer = singer;
        this.strQuality = strQuality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public MusicQualityType getQualityType() {
        handleQuality(this.strQuality);
        return qualityType;
    }

    public void setQualityType(MusicQualityType qualityType) {
        this.qualityType = qualityType;
    }

    public String getStrQuality() {
        return strQuality;
    }

    public void setStrQuality(String strQuality) {
        this.strQuality = strQuality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    private void handleQuality(String strQuality) {
        if (StringUtils.isNotBlank(strQuality)) {
            try {
                strQuality = strQuality.replace(Constant.SUFFIXES_BITRATE_MUSIC, "");
                int quality = Integer.parseInt(strQuality);
                if (quality >= 32 && quality < 500) {
                    qualityType = MusicQualityType.MP3;
                } else if (quality > 500 && quality < 1000) {
                    qualityType = MusicQualityType.M4A;
                } else if (quality >= 1000) {
                    qualityType = MusicQualityType.FLAC;
                }
            } catch (NumberFormatException e) {
                qualityType = MusicQualityType.FLAC;
            }
        } else {
            qualityType = MusicQualityType.NOT_FOUND;
        }
    }

    @Override
    public String toString() {
        return "Music{" + "id=" + id + ", title=" + title + ", image=" + image + ", url=" + url + ", lyric=" + lyric + ", qualityType=" + qualityType + ", description=" + description + ", singer=" + singer + ", strQuality=" + strQuality + ", stream=" + stream + '}';
    }
    
}
