
public class CountSetBits {
    
   
    public static int Count(int n) {
        
        int count = 0;
        
        // This loop will keep going as long as "n" is greater than 0
        while (n > 0) {
            // Check if the last bit (rightmost bit) of "n" is 1
            if ((n & 1) != 0) {
                // If it is, increase the "count" by 1
                count++;
            }
            // Shift "n" one bit to the right to check the next bit in the next loop round
            n = n >> 1;
        }
        
        return count;
    }

        public static void main(String[] args) {
       
        System.out.println(Count(15));
    }
}
