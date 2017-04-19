/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.constant;

/**
 *
 * @author PC
 */
public enum MusicQualityType {
    
    NOT_FOUND("UNKNOW"), MP3("MP3"), M4A("M4A"), FLAC("LOSSLESS");
    
    private final String value;

    private MusicQualityType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
    
}
