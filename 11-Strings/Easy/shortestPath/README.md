
# ShortestPath Program

This Java program calculates the shortest path to a destination based on a series of directional movements provided as a string. It assumes the starting point is the origin `(0, 0)` on a 2D plane, and each character in the input string represents a movement in one of the four directions: North (`N`), South (`S`), East (`E`), and West (`W`).

## Table of Contents
- [How It Works](#how-it-works)
- [Code Explanation](#code-explanation)
- [Usage](#usage)
- [Examples](#examples)
- [Dry Run](#dry-run)

## How It Works
The program uses a `switch` statement to interpret each character in the input string:
- `N` (North) increments the y-coordinate.
- `S` (South) decrements the y-coordinate.
- `E` (East) increments the x-coordinate.
- `W` (West) decrements the x-coordinate.

After processing all movements, the program calculates the Euclidean distance from the origin `(0, 0)` to the final coordinates `(x, y)`, which represents the shortest path to the destination.

## Code Explanation

### `ShortestPath` Class
This class contains:
- A method `ShortestPath`, which computes the shortest distance from the origin based on the provided movements.
- A `main` method, which initializes a sample movement string and calls `ShortestPath` to calculate the shortest distance.

### `ShortestPath` Method
1. **Initialize Coordinates**: Starts with coordinates `x = 0` and `y = 0`.
2. **Loop Through Directions**: For each character in the string:
   - Updates the `x` or `y` coordinate based on the movement direction.
   - For example, `N` increments `y` by 1, and `S` decrements `y` by 1.
3. **Calculate Distance**: Computes the shortest path (Euclidean distance) from the origin to `(x, y)` using the formula:
   \[
   \text{distance} = \sqrt{x^2 + y^2}
   \]

### `main` Method
- **Initialization**: Sets a sample string `str` representing movements.
- **Method Call and Output**: Calls `ShortestPath(str)` and prints the resulting shortest path distance.

## Usage
To use this program:
1. Copy the code into a file named `ShortestPath.java`.
2. Run the program from the command line or an IDE.
3. Update the value of `str` in the `main` method to test different movement sequences.

### Example Code
```java
public class ShortestPath {
    public static float ShortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            char dir = str.charAt(i);
            switch (dir) {
                case 'S' -> y--;
                case 'N' -> y++;
                case 'W' -> x--;
                default -> x++;
            }
        }
        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);
    }

    public static void main(String[] args) {
        var str = "SSSNNN";
        System.out.println(ShortestPath(str));
    }
}
```

## Examples
| Input      | Output | Explanation                                      |
|------------|--------|--------------------------------------------------|
| `"SSSNNN"` | `0.0`  | Moves south 3 times, then north 3 times, returning to the origin. |
| `"SSSNEE"` | `2.236`| Moves south 3 times, north once, and east twice. |
| `"NNWW"`   | `2.828`| Moves north twice and west twice, resulting in a diagonal distance. |

## Dry Run

Let’s go through a dry run using the input string `"SSSNEE"` to understand how the program processes the steps.

### Initial State
- **Starting coordinates**: `(x, y) = (0, 0)`

### Iteration Steps

1. **First Iteration (`i = 0`):**
   - **Character**: `S`
   - **Action**: `y--` (moves South, decrement y by 1)
   - **New Coordinates**: `(x, y) = (0, -1)`

2. **Second Iteration (`i = 1`):**
   - **Character**: `S`
   - **Action**: `y--` (moves South again, decrement y by 1)
   - **New Coordinates**: `(x, y) = (0, -2)`

3. **Third Iteration (`i = 2`):**
   - **Character**: `S`
   - **Action**: `y--` (moves South again, decrement y by 1)
   - **New Coordinates**: `(x, y) = (0, -3)`

4. **Fourth Iteration (`i = 3`):**
   - **Character**: `N`
   - **Action**: `y++` (moves North, increment y by 1)
   - **New Coordinates**: `(x, y) = (0, -2)`

5. **Fifth Iteration (`i = 4`):**
   - **Character**: `E`
   - **Action**: `x++` (moves East, increment x by 1)
   - **New Coordinates**: `(x, y) = (1, -2)`

6. **Sixth Iteration (`i = 5`):**
   - **Character**: `E`
   - **Action**: `x++` (moves East again, increment x by 1)
   - **New Coordinates**: `(x, y) = (2, -2)`

### Final Calculation
- **Final Coordinates**: `(x, y) = (2, -2)`
- **Shortest Path Calculation**:
  \[
  \text{distance} = \sqrt{(2)^2 + (-2)^2} = \sqrt{4 + 4} = \sqrt{8} \approx 2.236
  \]

### Output
The output for this input string `"SSSNEE"` is `2.236`, representing the shortest distance from the origin to the final position.

## Notes
- The program assumes all directions are represented by uppercase characters (`N`, `S`, `E`, `W`).
- The output distance is calculated as a float for precision.

