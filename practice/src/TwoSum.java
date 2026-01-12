
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7};
        int target = 8;
        int[] result = twoSum(nums, target);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (index.containsKey(target - num)) {
                return new int[] { i, index.get(target - num) };
            }
            index.put(num, i);
        }

        return null;
    }
}