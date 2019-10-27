/**
 * LeetCode-167
 */
public class Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int x = 0;
        int y = numbers.length - 1;

        while (x < y) {
            if (numbers[x] + numbers[y] == target) {
                result[0] = x + 1;
                result[1] = y + 1;
                break;
            }
            if (numbers[x] + numbers[y] > target) {
                y--;
            }
            if (numbers[x] + numbers[y] < target) {
                x++;
            }
        }
        return result;
    }
}
