/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import musiccrawler.constant.Constant;
import musiccrawler.validate.Validator;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Tavv
 */
public class HtmlToolFix {

    public static String fixUrl(String inUrl) {
        if (Validator.isValidUrl(inUrl)) {
            return inUrl;
        }
        return Constant.EMPTY;
    }

    public static String fixId(String strInput) {
        if (StringUtils.isNotBlank(strInput)) {
            return strInput.substring(strInput.lastIndexOf(Constant.CharacterSpec.TILDE) + 1, strInput.length() - 5).trim();
        }
        return Constant.EMPTY;
    }

    public static String fixName(String name) {
        if (StringUtils.isNotBlank(name)) {
            return StringUtils.replace(name, Constant.CharacterSpec.SEMI_COLON, " " + Constant.SINGER_FEATURING).trim();
        }
        return Constant.EMPTY;
    }

    public static String fixLyric(String input) {
        if (StringUtils.isNotBlank(input)) {
            String temp = StringUtils.replaceAll(input, Constant.HTML_SPAN_TAG_PATTERN, Constant.EMPTY);
            return temp.replaceAll(Constant.HTML_TAG_PATTERN, Constant.BREAK_LINE).replaceAll(Constant.SPACE_START_LINE_PATTERN, Constant.EMPTY).trim();
        }
        return Constant.EMPTY;
    }

    public static String searchStreamLink(String script) {
        if (StringUtils.isNoneBlank(script)) {
            Pattern pattern = Pattern.compile(Constant.STREAM_LINK_PATTERN);
            Matcher matcher = pattern.matcher(script);
            if (matcher.find()) {
                return matcher.group(1).trim();
            }
        }
        return Constant.EMPTY;
    }

    public static String fixLinkStream(String input) {
        if (StringUtils.isNoneBlank(input)) {
            return StringUtils.replaceAll(input, Constant.FIX_STREAM_PATTERN, Constant.EMPTY).trim();
        }
        return Constant.EMPTY;
    }
}
