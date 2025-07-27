
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        int count = 0;
        int index = 0;

        for (int num : nums) {
            if (num < target) {
                index++;
            } else if (num == target) {
                count++;
            }
        }

        if (count == 0) return list;

        for (int i = index; i < index + count; i++) {
            list.add(i);
        }

        return list;
    }
}
