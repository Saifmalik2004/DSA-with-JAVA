

# **Find the First Palindrome in an Array of Words**

## **Overview**
This program is designed to find the **first palindrome** from an array of words. A palindrome is a word that reads the same forward and backward, such as "aba" or "level". The goal of this program is to scan through an array of strings and return the first palindrome it encounters. If no palindrome is found, the program returns an empty string.

---

## **How It Works**

### **1. Input:**
The program accepts an array of words as input. For example:
```java
String[] words = {"abc", "def", "ghi", "aba"};
```

### **2. Process:**
The program checks each word in the array to see if it is a palindrome. It compares characters starting from both ends of the word:
- If any pair of characters from the start and end do not match, the word is **not** a palindrome.
- If all the characters match, the word is a **palindrome**.

### **3. Output:**
The program returns the first palindrome word found in the array. If no palindrome is found, it returns an empty string.

---

## **Step-by-Step Explanation**

### **Main Components of the Program**

1. **`firstPalindrome` Method:**
   - This method iterates through each word in the input array.
   - For each word, it checks if the word is a palindrome by comparing characters from both ends.
   - If the word is a palindrome, it is returned immediately. If no palindromes are found after checking all words, an empty string is returned.

2. **`main` Method:**
   - The `main` method initializes an array of words and calls the `firstPalindrome` method to find and print the first palindrome.

---

## **Code Breakdown**

### **1. Loop Through Each Word**
The program uses a `for` loop to iterate through each word in the array. The loop checks whether the current word is a palindrome.

### **2. Palindrome Check**
For each word, the program uses another loop to compare characters from the beginning and the end. It continues comparing until it reaches the middle of the word.

- If characters match, it continues checking.
- If characters don't match, the program stops and moves to the next word.

### **3. Return the Palindrome**
If a palindrome is found, it is returned immediately. If no palindrome is found after checking all words, the method returns an empty string.

---

## **Example**

Consider the following example:
```java
String[] words = {"abc", "def", "ghi", "aba"};
System.out.println(firstPalindrome(words));
```

**Output:**
```
aba
```

### **Explanation:**
- "abc" is not a palindrome.
- "def" is not a palindrome.
- "ghi" is not a palindrome.
- "aba" is a palindrome, so the program returns `"aba"`.

---

## **Key Concepts**

- **Palindrome:** A word that reads the same backward as forward (e.g., "madam", "level").
- **String Comparison:** The program compares characters from the start and end of each string to check for symmetry.
- **Efficient Looping:** The program uses two loops:
  1. One to iterate through words.
  2. Another to check characters in each word.

---

## **Conclusion**

This program demonstrates a simple yet effective approach to identifying palindromes in an array of words. It is a great exercise in string manipulation and loops, providing a foundation for solving similar problems in coding interviews or competitive programming.

---

## **Running the Program**

To run the program, simply execute the `FindFirstPalin` class in a Java environment. Make sure to modify the input array `words[]` to test different sets of words.

---

## **Key Takeaways**

- A palindrome is a word that reads the same forward and backward.
- String manipulation using loops and character comparisons is essential for this problem.
- The program efficiently identifies and returns the first palindrome found in the array of words.

---

Happy coding! 🎉

