import java.util.regex.Pattern;

/**
 * leetcode-65
 * */
public class Valid_Number {
    public boolean isNumber(String s) {
        String p1 = "[+-]?(([0-9]+\\.?[0-9]*)|([0-9]*\\.?[0-9]+))(e[+-]?[0-9]+)?";

        s = s.trim();
        return Pattern.matches(p1, s);
    }
}
