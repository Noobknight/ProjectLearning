/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.constant;

/**
 *
 * @author Tavv
 */
public class Constant {

    public static final String EMPTY = "";
    public static final String URL_VALID_PATTERN = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    public static final int CONNECT_TIME_OUT = 15000;
    public static final String USER_AGENT_BROWSER = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36";
    public static final String USER_AGENT_MOBILE = "";
    public static final String HTML_CONTENT_TAG_PATTERN = "<[^>](.+?)*>";
    public static final String HTML_TAG_PATTERN = "<[^>](.+?)>";
    public static final String STREAM_LINK_PATTERN = "mp3(.*?),";
    public static final String FIX_STREAM_PATTERN = ": \\B\"|\"\\B";
    public static final String SINGER_FEATURING = "ft";
    public static final String HTML_SPAN_TAG_PATTERN = "<span(.+?)span>";
    public static final String SPACE_START_LINE_PATTERN = "(?m)^ +";
    public static final String BREAK_LINE = "\n";
    public static final String SUFFIXES_BITRATE_MUSIC = "kbps";

    public static class URLConst {
        public static final String BASE_DOMAIN = "http://chiasenhac.vn";
        public static final String PATH_URL_BXH_VN = "/mp3/vietnam/";
        public static final String PATH_URL_MUSIC_HOT = "/nhac-hot/";
        public static final String URL_MUSIC_TEMP = "%smusic~%s.html";
    }

    public static class CharacterSpec {

        public static final String BACK_SLASH = "\\";
        public static final String FORWARD_SLASH = "/";
        public static final String TILDE = "~";
        public static final String COMMA = ",";
        public static final String SEMI_COLON = ";";
        public static final String SINGLE_QUOTE = "'";
    }

    public static class DatabaseConst {

        public static final String STR_CONNECTION = "jdbc:mysql://localhost:3306/music_crawl?user=root&password=\"\"";
    }
}
