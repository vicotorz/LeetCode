import java.util.HashMap;

/**
 * LeetCode-76
 */
public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        if(s==null||t==null||s.length()==0||t.length()==0||s.length()<t.length()) {
            return "";
        }
        /**
         * 寻找S中包含T的最短字符串
         *
         * 窗口的方法:
         * 先将T中所有字符保存在hash表中，值为每个字符出现的次数
         * 从头开始遍历，判断该字符是否在hash表中，如果在，则将该字符对应的值减1，并记录此时已包含T中字符总数
         * 如果字符总数等于T的长度说明找到一个子串，找到第一个包含T的字符串，然后将此时子串的长度和之前最小长度比较，更新最小字串的长度，并记录此时子串的起始位置
         * 然后移动子串的左边界，略过不再T中的字符
         * 当遍历完成的时候，记录的最小字串的起始位置和最小字串的长度可以得到包含T的最小字串
         */
        //先將t內容存入到hashmap中，然后在查找s过程中操作hashmap中的内容
        //left++  hashmap内容+1 ， right++  hashmap内容-1
        //right+1时，length+1,一直到length==t.length,

        HashMap<Character,Integer> hashmap = new HashMap<Character,Integer>();

        for(int i=0;i<t.length();i++) {
            hashmap.put(t.charAt(i), hashmap.getOrDefault(t.charAt(i), 0)+1);
        }

        //滑动窗口访问s字符串
        int left =0;
        int right=0;
        int count=0;
        int minLength=s.length()+1;
        String res ="";

        //先开始右移
        for(;right<s.length();right++) {
            if(hashmap.containsKey(s.charAt(right))) {
                hashmap.put(s.charAt(right), hashmap.get(s.charAt(right))-1);
                if(hashmap.get(s.charAt(right))>=0) {
                    count++;
                }
            }
            //把所有字母都包括了
            //再开始左移
            while(count==t.length()) {
                //System.out.println("left:"+left);
                if(hashmap.containsKey(s.charAt(left))) {
                    hashmap.put(s.charAt(left), hashmap.get(s.charAt(left))+1);
                    //计算最小长度
                    if(hashmap.get(s.charAt(left))>0) {
                        if(minLength>(right-left+1)) {
                            //System.out.println(left+"---"+right);
                            res = s.substring(left,right+1);
                            minLength = right-left+1;
                        }
                        count--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
