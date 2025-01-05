import java.util.ArrayList;
import java.util.Collections;

public class Greedy {
    // Job class to store index, deadline, and profit
    public static class Job {
        int idx;
        int deadline;
        int profit;

        public Job(int i, int d, int p) {
            idx = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        // Create a list of Job objects
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort jobs by profit in descending order
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        // Schedule jobs
        int time = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                ans.add(curr.idx);
                time += curr.deadline;
            }
        }

        // Output results
        System.out.println("max job = " + ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}