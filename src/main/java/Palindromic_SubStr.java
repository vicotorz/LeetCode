/**
 * LeetCode-647
 */
public class Palindromic_SubStr {
    public int countSubstrings(String s) {
        if(s==null||s.length()==0) {
            return 0;
        }

        char[] arrays = new char[s.length()*2+1];
        arrays[0] ='#';
        int t=0;
        for(int i=1;i<arrays.length;i=i+2) {
            arrays[i] = s.charAt(t);
            arrays[i+1] = '#';
            t++;
        }

        int result = 0;
        //以某个节点为中间节点，向两边扩散
        for(int med=0;med<arrays.length;med++) {

            int left = med-1;
            int right = med+1;
            //自身为回文
            if(arrays[med]!='#') {
                result ++;
            }

            for(;left>=0 && right<=arrays.length-1;left--,right++) {
                if(arrays[left]==arrays[right] && arrays[left]!='#') {
                    result++;
                }else if(arrays[left]==arrays[right] && arrays[left]=='#'){
                    continue;
                }else {
                    break;
                }
            }
        }
        return result;
    }
}
