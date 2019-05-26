import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Problem problem = new Problem();

        long t0 = System.currentTimeMillis();
        int nbSequences = in.nextInt();
        for (int i = 0; i < nbSequences; i++) {
            String sequence = in.next();
            problem.addSequence(sequence.toUpperCase());
        }
        long t1 = System.currentTimeMillis();
        System.err.println("Init in " + (t1 - t0) + "ms");

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        ProblemSolver solver = new ProblemSolver(problem);
        int result = solver.solve();
        System.out.println(result);
    }
}

class Problem {
    List<String> sequences = new ArrayList<>();

    void addSequence(String word) {
        sequences.add(word);
    }
}

class ProblemSolver {
    Problem problem;

    ProblemSolver(Problem problem) {
        this.problem = problem;
    }

    int solve() {
        // loop through all combinations of all sequences
        int arr[] = new int[problem.sequences.size()];
        for (int i = 0; i < problem.sequences.size(); i++) {
            arr[i] = i;
        }

        Combination combination = new Combination();
        combination.permuteHelper(arr, 0);
        List<int[]> indexCombinations = combination.combinations;

        int min = Integer.MAX_VALUE;
        for (int[] indexCombi : indexCombinations) {
            int length = mergeCombination(indexCombi);
            min = Math.min(min, length);
        }

        return min;
    }

    private String combiToString(int[] indexCombi) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < indexCombi.length; i++) {
            buf.append(problem.sequences.get(indexCombi[i])).append("-");
        }
        return buf.toString();
    }

    private int mergeCombination(int[] indexCombi) {
        StringBuilder buf = new StringBuilder(problem.sequences.get(indexCombi[0]));
        for (int i = 1; i < indexCombi.length; i++) {
            String mergedString = mergeStrings(buf.toString(), problem.sequences.get(indexCombi[i]));
            buf.append(mergedString);
        }
        System.err.println(combiToString(indexCombi) + " becomes " + buf + " of length " + buf.length());
        return buf.length();
    }

    /**
     * Remove all characters at the end of s1 matching starting chars of s2.
     * ARRRYU merged to YUGTTT --> GTTT
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String mergeStrings(String s1, String s2) {
        char[] char1s = s1.toCharArray();
        char[] char2s = s2.toCharArray();
        boolean matching = false;
        int indexToCheck = 0;

        if (s1.contains(s2)) {
            return "";
        }

        for (int i = 0; i < char1s.length; i++) {
            if (indexToCheck < char2s.length && char1s[i] == char2s[indexToCheck]) {
                if (!matching) { // starting of matching sequence
                    matching = true;
                }
                indexToCheck++;
            } else {
                matching = false; // finally, the candidate sequence doesn't match
                indexToCheck = 0;

                if (indexToCheck < char2s.length && char1s[i] == char2s[indexToCheck]) {
                    matching = true;
                    indexToCheck++;
                }
            }
        }

        StringBuilder buf = new StringBuilder();
        if (matching) {
            for (int i = indexToCheck; i < char2s.length; i++) {
                buf.append(char2s[i]);
            }
        } else {
            buf.append(s2);
        }

        return buf.toString();
    }
}

class Combination {

    List<int[]> combinations = new ArrayList<>();

    void permuteHelper(int[] arr, int index) {
        if (index >= arr.length - 1) { //If we are at the last element - nothing left to permute
            registerCombination(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) { //For each index in the sub array arr[index...end]
            //Swap the elements at indices index and i
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;

            //Recurse on the sub array arr[index+1...end]
            permuteHelper(arr, index + 1);

            //Swap the elements back
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

    private void registerCombination(int[] src) {
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        combinations.add(dest);
    }
}