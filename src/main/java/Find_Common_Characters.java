import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode-1002
 * */
public class Find_Common_Characters {
    public static List<String> commonChars(String[] A)
    {
        List<String> result = new ArrayList();
        int [] commonCharsCount = new int[26];
        Arrays.fill(commonCharsCount, Integer.MAX_VALUE);

        // iterate each string in A
        for(String str : A)
        {
            int [] tempCharsCount = new int[26];

            // count char for this string
            for(char c : str.toCharArray())
                tempCharsCount[c - 'a']++;

            // update the commonCharsCount
            for(int i=0; i<commonCharsCount.length; i++)
                commonCharsCount[i] = Math.min(commonCharsCount[i], tempCharsCount[i]);
        }

        // iterate commonCharsCount to add each char
        for(int i=0; i<commonCharsCount.length; i++)
        {
            while(commonCharsCount[i] > 0)
            {
                result.add("" + (char)('a' + i));
                commonCharsCount[i]--;
            }
        }

        return result;
    }
}
