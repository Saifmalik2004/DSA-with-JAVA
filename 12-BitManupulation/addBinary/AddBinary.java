public class AddBinary {
    public static String addBinary(String a, String b) {
        int carry = 0;
        int aLen = a.length() - 1;  // Starting from the last character of string a
        int bLen = b.length() - 1;  // Starting from the last character of string b
       
        StringBuilder ans = new StringBuilder();
        
        // Process each bit starting from the least significant bit
        while (aLen >= 0 || bLen >= 0 || carry == 1) {
            if (aLen >= 0) {
                carry += a.charAt(aLen--) - '0'; // Convert char to int by subtracting '0'
            }
            if (bLen >= 0) {
                carry += b.charAt(bLen--) - '0'; // Convert char to int by subtracting '0'
            }
            
            ans.append(carry % 2); // Append the result of current bit
            carry = carry / 2;     // Update carry for the next iteration
        }
        
        // Reverse the result to get the correct binary representation
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1")); // Expected output: "100"
    }
}
