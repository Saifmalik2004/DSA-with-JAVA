import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// Class to find the majority element in an array using a HashMap to count frequencies.
public class Better {

    // Method to find the majority element in the array.
    // A majority element is an element that appears more than n/2 times in the array.
    public static void majorityElement(int arr[]) {
        // Create a HashMap to store the frequency of each element.
        Map<Integer, Integer> countFreq = new HashMap<>();

        // Traverse the array and count the frequency of each element.
        for (int i = 0; i < arr.length; i++) {
            // If the element is already in the map, increment its count; otherwise, add it with count 1.
            countFreq.put(arr[i], countFreq.getOrDefault(arr[i], 0) + 1);
        }

        // Iterate through the entries of the HashMap to find the majority element.
        for (Entry<Integer, Integer> elem : countFreq.entrySet()) {
            int val = elem.getValue(); // Get the frequency of the current element.
            // Check if the frequency is greater than n/2.
            if (val > arr.length / 2) {
                System.out.println(elem.getKey()); // Print the majority element.
                return; // Exit the function once the majority element is found.
            }
        }
    }

    // Main method to test the functionality.
    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 1, 1, 1, 1}; // Input array.
        majorityElement(arr); // Call the majorityElement method.
    }
}
