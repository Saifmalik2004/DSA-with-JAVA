

# **Find the Missing Number in an Array**

---

## **Problem Description**  
You are given an array containing `n - 1` distinct integers in the range `1` to `n`. Your task is to find the missing number in the array.  

💡 **Real-Life Analogy**:  
Imagine a sequence of numbered tickets from `1` to `n` 🎟️. If one ticket is missing, how can you figure out which one it is without manually counting them all?

---

## **Example Input and Output**  

### **Example 1**  
**Input**:  
`arr = [1, 2, 3, 5]`  
`n = 5`  

**Output**:  
`4`  

### **Example 2**  
**Input**:  
`arr = [0, 1, 3]`  
`n = 4`  

**Output**:  
`2`  

---

## **Link to Problem**  
This problem is common in coding interviews and can be practiced on platforms like LeetCode or GeeksforGeeks.

---

## **Approaches**

### **1. Brute Force Approach**  

---

#### **Step-by-Step Explanation of Code**  

1. **Iterate through all numbers from `1` to `n`.**  
   ```java
   for (int i = 1; i <= n; i++) {
   ```
2. **Check if each number exists in the array.**  
   ```java
   boolean found = false;
   for (int j = 0; j < arr.length; j++) {
       if (arr[j] == i) {
           found = true;
           break;
       }
   }
   ```
3. **If a number is not found, return it.**  
   ```java
   if (!found) {
       return i;
   }
   ```

---

#### **Dry Run**  
**Input**: `[1, 2, 4]`, `n = 4`  

| Step | Number Checked | Found in Array? | Missing Number |  
|------|----------------|-----------------|----------------|  
| 1    | 1              | Yes             | -              |  
| 2    | 2              | Yes             | -              |  
| 3    | 3              | No              | 3              |  

**Output**: `3`  

---

#### **Code**  
```java
public class Brute {

    public static int missing(int arr[], int n) {
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4};
        int n = 4;
        System.out.println(missing(arr, n));
    }
}
```

---

#### **Time and Space Complexity**  
- **Time Complexity**: O(N²)  
- **Space Complexity**: O(1)  

---

### **2. Hashing Approach**

---

#### **Step-by-Step Explanation of Code**  

1. **Create a hash array of size `n + 1`.**  
   ```java
   int hash[] = new int[n + 1];
   ```
2. **Mark the presence of numbers in the hash array.**  
   ```java
   for (int i = 0; i < arr.length; i++) {
       hash[arr[i]]++;
   }
   ```
3. **Identify the missing number by finding the index where the hash value is 0.**  
   ```java
   for (int i = 1; i <= n; i++) {
       if (hash[i] == 0) {
           return i;
       }
   }
   ```

---

#### **Dry Run**  
**Input**: `[1, 2, 4]`, `n = 4`  

| Step | Hash Array         | Missing Number |  
|------|--------------------|----------------|  
| Init | `[0, 0, 0, 0, 0]`  | -              |  
| Mark | `[0, 1, 1, 0, 1]`  | 3              |  

**Output**: `3`  

---

#### **Code**  
```java
public class Better {

    public static int missing(int arr[], int n) {
        int hash[] = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4};
        int n = 4;
        System.out.println(missing(arr, n));
    }
}
```

---

#### **Time and Space Complexity**  
- **Time Complexity**: O(N)  
- **Space Complexity**: O(N)  

---

### **3. Optimized Approach (Using Sum Formula)**  

---

#### **Step-by-Step Explanation of Code**  

1. **Calculate the expected sum using the formula.**  
   ```java
   int expectedSum = n * (n + 1) / 2;
   ```
2. **Calculate the actual sum of the array elements.**  
   ```java
   int actualSum = 0;
   for (int i = 0; i < arr.length; i++) {
       actualSum += arr[i];
   }
   ```
3. **Return the difference between the expected and actual sums.**  
   ```java
   return expectedSum - actualSum;
   ```

---

#### **Dry Run**  
**Input**: `[1, 2, 4]`, `n = 4`  

| Step            | Calculation         | Result |  
|------------------|---------------------|--------|  
| Expected Sum     | `4 * (4 + 1) / 2`   | 10     |  
| Actual Sum       | `1 + 2 + 4`         | 7      |  
| Missing Number   | `10 - 7`            | 3      |  

**Output**: `3`  

---

#### **Code**  
```java
public class Optimize {

    public static int missing(int arr[], int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4};
        int n = 4;
        System.out.println(missing(arr, n));
    }
}
```

---

#### **Time and Space Complexity**  
- **Time Complexity**: O(N)  
- **Space Complexity**: O(1)  

---

### **4. Bit Manipulation Approach (Using XOR)**  

---

#### **Step-by-Step Explanation of Code**  

1. **Initialize variables to store XOR of array elements and XOR of numbers from `1` to `n`.**  
   ```java
   int xorArr = 0;
   int xorFull = 0;
   ```
2. **Perform XOR on all array elements.**  
   ```java
   for (int num : arr) {
       xorArr ^= num;
   }
   ```
3. **Perform XOR on all numbers from `1` to `n`.**  
   ```java
   for (int i = 1; i <= n; i++) {
       xorFull ^= i;
   }
   ```
4. **The missing number is the XOR of `xorArr` and `xorFull`.**  
   ```java
   return xorArr ^ xorFull;
   ```

---

#### **Dry Run**  
**Input**: `[1, 2, 4]`, `n = 4`  

| Step            | Calculation | Result |  
|------------------|-------------|--------|  
| XOR of Array     | `1 ^ 2 ^ 4` | 7      |  
| XOR of Full Range| `1 ^ 2 ^ 3 ^ 4` | 4  |  
| Missing Number   | `7 ^ 4`     | 3      |  

**Output**: `3`  

---

#### **Code**  
```java
public class XORApproach {

    public static int missing(int arr[], int n) {
        int xorArr = 0, xorFull = 0;

        for (int num : arr) {
            xorArr ^= num;
        }

        for (int i = 1; i <= n; i++) {
            xorFull ^= i;
        }

        return xorArr ^ xorFull;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4};
        int n = 4;
        System.out.println(missing(arr, n));
    }
}


```

---

#### **Time and Space Complexity**  
- **Time Complexity**: O(N)  
- **Space Complexity**: O(1)  

--- 

Let me know if this is complete or needs further tweaks! 😊