

# 🛠️ Greedy Job Scheduling Problem  

## 1️⃣ **Problem Description**  
Imagine you're running a freelance platform where clients post jobs with deadlines and rewards (profits). You, as the owner, need to assign the jobs to workers. But there’s a catch!  

- Each job can only be done **within its deadline**.  
- A worker can only do **one job at a time**.  

Your goal? Maximize the **profit** by selecting jobs wisely. 💸  

For example:  
- Job A: Deadline = 1 day, Profit = $40  
- Job B: Deadline = 4 days, Profit = $20  
Which jobs should you assign to maximize profit? Let’s find out! 🚀  

---

## 2️⃣ **Step-by-Step Explanation of the Code**  

1. **Define the Job Class**  
   - A `Job` has three properties:  
     - `idx`: The job's unique ID.  
     - `deadline`: The day by which the job must be completed.  
     - `profit`: The money you earn if this job is completed.  
     
2. **Initialize Job Information**  
   - Input is a 2D array where each row contains the job's `deadline` and `profit`.  
   - Example: `{{4,20},{1,10},{1,40},{1,30}}` represents four jobs.  

3. **Store Jobs in a List**  
   - Convert the raw job data into `Job` objects and store them in an `ArrayList`.  

4. **Sort Jobs by Profit**  
   - Use `Collections.sort` to sort jobs in descending order of profit. This ensures we prioritize the most lucrative jobs first.  

5. **Assign Jobs Greedily**  
   - Start from the most profitable job and check if it can fit within the deadline. If yes, schedule it! 🎯  

6. **Output the Results**  
   - Print the maximum number of jobs and their indices (IDs) in the optimal order.  

---

## 3️⃣ **Example Walkthrough** 🌟  

### Input  
```  
jobsInfo = {{4,20},{1,10},{1,40},{1,30}}  
```  

### Steps  
1. **Convert to Job Objects**  
   ```
   Job 0: Deadline = 4, Profit = 20  
   Job 1: Deadline = 1, Profit = 10  
   Job 2: Deadline = 1, Profit = 40  
   Job 3: Deadline = 1, Profit = 30  
   ```  

2. **Sort by Profit (Descending)**  
   ```
   Sorted Jobs:  
   Job 2 (Profit $40), Job 3 (Profit $30), Job 0 (Profit $20), Job 1 (Profit $10)  
   ```  

3. **Assign Jobs Greedily**  
   - Job 2 ✅ (Deadline = 1)  
   - Job 3 ❌ (Deadline = 1, already taken)  
   - Job 0 ✅ (Deadline = 4)  
   - Job 1 ❌ (Deadline = 1, already taken)  

4. **Result**  
   - Maximum Jobs: 2  
   - Job Indices: [2, 0]  

---

## 4️⃣ **Approach**  
The strategy is simple but effective:  
1. Prioritize high-profit jobs (hence, sort by profit).  
2. Assign jobs if their deadline fits within the available time slots.  

Why is this method efficient?  
- By focusing on profit first, we maximize the reward early on.  
- Checking deadlines ensures we don’t overcommit and leave enough time for other jobs. 💡  

---

## 5️⃣ **Pseudo Code** 📝  

```
Input: jobsInfo (array of [deadline, profit])  

Step 1: Create Job objects with idx, deadline, and profit.  
Step 2: Sort the jobs in descending order of profit.  
Step 3: Initialize a variable `time = 0` and an empty list `ans`.  

For each job in the sorted list:  
   If the job's deadline > time:  
      Add the job's index to `ans`.  
      Increment `time` by 1.  

Output the size of `ans` and the indices of selected jobs.  
```  

---

## 6️⃣ **Full Code with Comments** 🖥️💬  

```java
import java.util.ArrayList;
import java.util.Collections;

public class Greedy {
    // Class to represent a Job
    public static class Job {
        int idx;        // Job index
        int deadline;   // Deadline for the job
        int profit;     // Profit from the job

        // Constructor to initialize a job
        public Job(int i, int d, int p) {
            idx = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        // Input: Each job has [deadline, profit]
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
       
        ArrayList<Job> jobs = new ArrayList<>();

        // Step 1: Convert input to Job objects
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Step 2: Sort jobs by profit (descending)
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        int time = 0; // Tracks used time slots
        ArrayList<Integer> ans = new ArrayList<>();

        // Step 3: Schedule jobs
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) { // Check if job fits within deadline
                ans.add(curr.idx);
                time++;
            }
        }

        // Output results
        System.out.println("Max jobs = " + ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}
```  

---

## 7️⃣ **Complexity Analysis** 🔍  

- **Time Complexity**:  
  - Sorting the jobs: `O(n log n)`  
  - Scheduling jobs: `O(n)`  
  Total: **`O(n log n)`**  

- **Space Complexity**:  
  - Storing jobs and results: `O(n)`  

---

## 8️⃣ **Key Takeaways** 🚀  
- Greedy algorithms focus on **local optimization** for a globally efficient solution.  
- Sorting by profit helps tackle the most rewarding jobs early on.  
- Breaking problems into small, logical steps simplifies coding.  

💡 **Keep practicing greedy strategies—you’re on your way to becoming a coding pro!** 💻🎉  