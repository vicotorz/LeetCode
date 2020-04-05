import java.util.ArrayList;

/**
 * leetcode-500
 * */
public class Keyboard_Row {
    public static String[] findWords(String[] words) {

        if (words == null || words.length <= 0) {
            return words;
        }

        String sequence1 = "QWERTYUIOPqwertyuiop";
        String sequence2 = "ASDFGHJKLasdfghjkl";
        String sequence3 = "ZXCVBNMzxcvbnm";
        String sequence = "";

        ArrayList<String> result = new ArrayList();

        for (int i = 0; i < words.length; i++) {
            if (sequence1.contains(String.valueOf(words[i].charAt(0)))) {
                sequence = sequence1;
            } else if (sequence2.contains(String.valueOf(words[i].charAt(0)))) {
                sequence = sequence2;
            } else {
                sequence = sequence3;
            }

            if (checkWord(sequence, words[i])) {
                result.add(words[i]);
            }
        }

        String[] str = new String[result.size()];

        for (int t = 0; t < result.size(); t++) {
            str[t] = result.get(t);
        }

        return str;
    }

    public static boolean checkWord(String sequence, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!sequence.contains(String.valueOf(word.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
