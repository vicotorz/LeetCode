import java.util.HashMap;
import java.util.Map;

/**
 * leetcode-383
 * */
public class Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        if (ransomNote.equals("")) {
            return true;
        }

        HashMap<String, Integer> ransomMap = new HashMap();
        HashMap<String, Integer> magazineMap = new HashMap();

        for (int i = 0; i < ransomNote.length(); i++) {
            ransomMap.put(String.valueOf(ransomNote.charAt(i)),
                    ransomMap.getOrDefault(String.valueOf(ransomNote.charAt(i)), 0) + 1);
        }

        for (int j = 0; j < magazine.length(); j++) {
            magazineMap.put(String.valueOf(magazine.charAt(j)),
                    magazineMap.getOrDefault(String.valueOf(magazine.charAt(j)), 0) + 1);
        }

        boolean flag = true;

        for (Map.Entry<String,Integer> entry : ransomMap.entrySet()) {
            if (!magazineMap.containsKey(entry.getKey())
                    || magazineMap.get(entry.getKey()) < entry.getValue()) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
