# Activity Selection Problem ⚡

## 1⃣ **Problem Description**
Imagine you’re a super-organized event planner 🎡. You’ve got a list of activities, each with a start time and an end time. Your goal? Maximize the number of activities you can complete without any overlap! ⏰

Here’s the twist: You can only attend one activity at a time, so you have to pick wisely! The question is: Which activities should you choose to maximize your fun? 🎩

---

## 2⃣ **Step-by-Step Explanation of the Code** 🛠️

### Step 1: Representing the Activities
We store the activities in a 2D array where each activity has three values:
- **Index**: Identifies the activity.
- **Start Time**: When the activity begins.
- **End Time**: When the activity ends.

```java
int activities[][] = new int[start.length][3];
for (int i = 0; i < start.length; i++) {
    activities[i][0] = i;        // Activity index
    activities[i][1] = start[i]; // Start time
    activities[i][2] = end[i];   // End time
}
```

---

### Step 2: Sorting Activities by End Time 🔄
We sort the activities based on their end times. Why? Because completing the earliest-ending activity leaves more room for future activities!

```java
Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
```

---

### Step 3: Selecting Activities 🏅
- Start by picking the first activity (it ends the earliest).
- For each subsequent activity, check if its start time is greater than or equal to the end time of the last selected activity.
- If yes, select it!

```java
int maxAct = 1;
ArrayList<Integer> ans = new ArrayList<>();
ans.add(activities[0][0]);
int lastEnd = activities[0][2];

for (int i = 1; i < end.length; i++) {
    if (activities[i][1] >= lastEnd) {
        maxAct++;
        ans.add(activities[i][0]);
        lastEnd = activities[i][2];
    }
}
```

---

## 3⃣ **Example Walkthrough** 🌟
Let’s take the following input:

**Start Times:** [1, 3, 0, 5, 8, 5]  
**End Times:** [2, 4, 6, 7, 9, 9]

### Step-by-Step Execution:
1. **Initial Sorting by End Time:**  
   Activities after sorting:  
   [A0: (1, 2)], [A1: (3, 4)], [A2: (0, 6)], [A3: (5, 7)], [A4: (8, 9)], [A5: (5, 9)]

2. **Selection Process:**  
   - Select A0 (ends at 2). Last End = 2.
   - A1 starts at 3 (✓), select it. Last End = 4.
   - A2 starts at 0 (✘), skip it.
   - A3 starts at 5 (✓), select it. Last End = 7.
   - A4 starts at 8 (✓), select it. Last End = 9.
   - A5 starts at 5 (✘), skip it.

3. **Result:** Max Activities = 4. Selected: A0, A1, A3, A4.

---

## 4⃣ **Approach** 💡
The "greedy approach" ensures we always pick the optimal solution at each step:
1. Sort by earliest end time.
2. Select the first activity.
3. Continue picking activities that don’t overlap with the last selected one.

Why is this clever? By focusing on the earliest end time, we leave the maximum room for future activities!

---

## 5⃣ **Pseudo Code** 🖋
```plaintext
Input: start[], end[]
Create activities[] with index, start, end.
Sort activities by end time.
Initialize maxAct = 1, lastEnd = activities[0].end.
Add activities[0].index to ans.

For i = 1 to activities.length:
    If activities[i].start >= lastEnd:
        Increment maxAct.
        Add activities[i].index to ans.
        Update lastEnd = activities[i].end.

Output maxAct and ans.
```

---

## 6⃣ **Full Code with Comments** 💻✨
```java
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
```

---

## 7⃣ **Complexity Analysis** 🔍
- **Time Complexity:**
  - Sorting the activities: \(O(n \log n)\)  
  - Selecting activities: \(O(n)\)  
  **Overall:** \(O(n \log n)\).

- **Space Complexity:** \(O(n)\), for the activities array and answer list.

---

## 8⃣ **Key Takeaways** 🚀
- The greedy algorithm is a powerful tool for optimization problems.
- Sorting by the right criterion (end time here) is often the key to success.
- Always think about minimizing future constraints while solving greedy problems!

You’re one step closer to mastering greedy algorithms! Keep going, and soon you’ll be solving even more complex optimization problems. 🎉✨

