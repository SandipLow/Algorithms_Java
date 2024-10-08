import java.util.*;

public class L8_Stack {
    private static boolean mergable(List<Integer> a, List<Integer> b) {
        return a.get(1) < b.get(0);
    }

    private static List<Integer> merge(List<Integer> a, List<Integer> b) {
        return Arrays.asList(a.get(0), b.get(1));
    }

    public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        int n = intervals.size();
        Stack<List<Integer>> st = new Stack<>();

        for (int i=0; i<n; i++) {
            List<Integer> interval = intervals.get(i);

            if (st.isEmpty()) {
                st.push(interval);
                continue;
            }

            if (mergable(st.peek(), interval)) {
                st.push(merge(st.pop(), interval));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        while(!st.empty()) {
            ans.add(st.pop());
        }

        return ans;

    }

    public static void main(String[] args) {
        
    }
}