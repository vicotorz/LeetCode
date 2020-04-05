
/**
 * leetcode-168
 * */
public class Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        StringBuilder st = new StringBuilder();

        while (n>0) {
            n--;
            int temp = n%26;
            st.insert(0, (char) (temp+65));
            n = n/26;
        }

        return st.toString();
    }
}
