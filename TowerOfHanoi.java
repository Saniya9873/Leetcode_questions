import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4; // Number of disks
        int pegs = 5; // Number of towers
        solveTowerOfHanoi(n, pegs);
    }

    public static void solveTowerOfHanoi(int n, int pegs) {
        if (pegs < 3) {
            System.out.println("At least 3 pegs are required for the Tower of Hanoi problem.");
            return;
        }
        // Initialize pegs
        Stack<Integer>[] towers = new Stack[pegs];
        for (int i = 0; i < pegs; i++) {
            towers[i] = new Stack<>();
        }
        // Add disks to the first peg
        for (int i = n; i > 0; i--) {
            towers[0].push(i);
        }

        // Solve using recursive Frame-Stewart algorithm
        moveDisks(n, 0, pegs - 1, towers, pegs);

        // Output the result
        System.out.println("All disks moved successfully!");
    }

    // Recursive function
    private static void moveDisks(int n, int source, int target, Stack<Integer>[] towers, int pegs) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            // Move a single disk directly
            int disk = towers[source].pop();
            towers[target].push(disk);
            System.out.println("Move disk " + disk + " from peg " + (source + 1) + " to peg " + (target + 1));
            return;
        }

        int aux = findAuxiliaryPeg(source, target, pegs);

        // Move top n-1 disks to an auxiliary peg
        moveDisks(n - 1, source, aux, towers, pegs);

        // Move the nth disk to the target peg
        moveDisks(1, source, target, towers, pegs);

        // Move the n-1 disks from auxiliary peg to target peg
        moveDisks(n - 1, aux, target, towers, pegs);
    }

    private static int findAuxiliaryPeg(int source, int target, int pegs) {
        for (int i = 0; i < pegs; i++) {
            if (i != source && i != target) {
                return i;
            }
        }
        return -1; // This shouldn't happen
    }
}
