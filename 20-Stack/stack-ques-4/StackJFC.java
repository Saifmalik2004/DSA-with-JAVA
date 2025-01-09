import java.util.Stack;

public class StackJFC {
    
    // Method to calculate the stock span for each day
    public static void stockSpan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;  // The span for the first day is always 1
        s.push(0);  // Push the index of the first day onto the stack

        // Loop through each day (from the second day onward)
        for (int i = 1; i < stock.length; i++) {
            int currPrice = stock[i];  // Current stock price for the day

            // While the stack is not empty and the current price is greater than the price at the top of the stack
            while (!s.isEmpty() && currPrice > stock[s.peek()]) {
                s.pop();  // Pop elements from the stack as long as the current price is greater
            }

            // If the stack is empty, it means the current price is higher than all previous prices
            if (s.isEmpty()) {
                span[i] = i + 1;  // The span is the number of days from the start (i + 1)
            } else {
                // Otherwise, the span is the difference between the current day and the last day with a higher price
                int preH = s.peek();
                span[i] = i - preH;  // Calculate the span based on the previous day's index with a higher price
            }

            s.push(i);  // Push the index of the current day onto the stack
        }
    }

    public static void main(String[] args) {
        int stock[] = {100, 80, 60, 70, 60, 85, 100};  // Stock prices for each day
        int span[] = new int[stock.length];  // Array to store the stock span for each day

        stockSpan(stock, span);  // Calculate the stock span for each day

        // Print the stock span for each day
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
    }
}
