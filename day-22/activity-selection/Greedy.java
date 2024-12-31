import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // Step 1: Represent activities with index, start, end
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;        // Activity index
            activities[i][1] = start[i]; // Start time
            activities[i][2] = end[i];   // End time
        }

        // Step 2: Sort activities by end time
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // Step 3: Select activities
        int maxAct = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) { // Non-overlapping condition
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        // Output the results
        System.out.println("max activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}