public class LargestString {  
    public static String largestString(String[] arr) { 
        String largest = arr[0]; 
        
        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Compare the current largest string with the current array element
            if (largest.compareTo(arr[i]) < 0) { 
                largest = arr[i]; // Update largest if the current element is "larger"
            }
        }

        return largest; 
    }

    public static void main(String[] args) { 
        String arr[] = {"apple", "banana", "mango"}; 
        System.out.println(largestString(arr)); 
    }
}
