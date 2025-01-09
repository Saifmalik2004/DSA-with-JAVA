import java.util.ArrayList;

public class PairSumRotated {
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int bp = -1;

        // Find the breaking point (pivot)
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        // Pointers
        int left = (bp + 1) % list.size(); // Smallest element
        int right = bp; // Largest element

        // Two-pointer approach
        while (left != right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left = (left + 1) % list.size(); // Move to next larger element
            } else {
                right = (right - 1 + list.size()) % list.size(); // Move to next smaller element
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(pairSum(list, 16)); // Output: true
        System.out.println(pairSum(list, 20)); // Output: false
    }
}
