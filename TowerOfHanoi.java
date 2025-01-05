import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4; 
        int pegs = 5; 
        solveTowerOfHanoi(n, pegs);
    }

    public static void solveTowerOfHanoi(int n, int pegs) {
        if (pegs < 3) {
            System.out.println("At least 3 pegs are required for the Tower of Hanoi problem.");
            return;
        }
       
        Stack<Integer>[] towers = new Stack[pegs];
        for (int i = 0; i < pegs; i++) {
            towers[i] = new Stack<>();
        }
      
        for (int i = n; i > 0; i--) {
            towers[0].push(i);
        }

       
        moveDisks(n, 0, pegs - 1, towers, pegs);

       
        System.out.println("All disks moved successfully!");
    }

    private static void moveDisks(int n, int source, int target, Stack<Integer>[] towers, int pegs) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
           
            int disk = towers[source].pop();
            towers[target].push(disk);
            System.out.println("Move disk " + disk + " from peg " + (source + 1) + " to peg " + (target + 1));
            return;
        }

        int aux = findAuxiliaryPeg(source, target, pegs);

       
        moveDisks(n - 1, source, aux, towers, pegs);

        
        moveDisks(1, source, target, towers, pegs);

       
        moveDisks(n - 1, aux, target, towers, pegs);
    }

    private static int findAuxiliaryPeg(int source, int target, int pegs) {
        for (int i = 0; i < pegs; i++) {
            if (i != source && i != target) {
                return i;
            }
        }
        return -1; 
    }
}
