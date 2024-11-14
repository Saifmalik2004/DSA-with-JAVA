
 
public class FriendsPairing {
    public static int friendsPairing(int n) {
        // Base cases
        if(n == 1 || n == 2) {
            return n;
        }

        // Recursive call based on two options:
        // Option 1: Last friend stays single
        // Option 2: Last friend pairs up with someone
        return friendsPairing(n - 1) + ((n - 1) * friendsPairing(n - 2));
    }

    public static void main(String[] args) {
        
        System.out.println(friendsPairing(5));
    
    }
}
