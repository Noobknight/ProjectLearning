/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import musiccrawler.constant.Constant;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Tavv
 */
public class Validator {

    public static boolean isValidUrl(String url) {
        if (StringUtils.isNotBlank(url)) {
            Pattern pattern = Pattern.compile(Constant.URL_VALID_PATTERN);
            Matcher matcher = pattern.matcher(url);
            return matcher.find();
        }
        return false;
    }

    public static String validPath(String input) {
        if (StringUtils.isNotBlank(input)) {
            if (!input.startsWith(Constant.CharacterSpec.FORWARD_SLASH)) {
                return Constant.CharacterSpec.FORWARD_SLASH + input;
            } else if (!input.endsWith(Constant.CharacterSpec.FORWARD_SLASH)) {
                return input + Constant.CharacterSpec.FORWARD_SLASH;
            } else {
                return Constant.CharacterSpec.FORWARD_SLASH + input + Constant.CharacterSpec.FORWARD_SLASH;
            }
        }
        return input;
    }

}
