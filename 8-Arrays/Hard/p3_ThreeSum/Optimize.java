import java.util.*;

class Optimize {
    // Finds all unique triplets such that arr[i] + arr[j] + arr[k] == 0
    public static List<List<Integer>> triplet(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // Skip duplicate i
            if (arr[i] > 0) break; // Since sorted, no need to proceed if arr[i] > 0

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    res.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    // Skip duplicates for j and k
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> result = triplet(arr);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}