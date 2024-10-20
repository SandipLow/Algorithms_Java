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

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i=n-1; i>=0; i--) {
            while (!st.empty() && arr[st.peek()]<=arr[i])
                st.pop();

            ans[i] = st.empty() ? -1 : st.peek();

            st.add(i);
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        int[] ans = nextGreaterElement(arr);

        for (int a: ans) {
            System.out.print(a);
            System.out.print(" ");
        }
        System.out.println();

        sc.close();
    }
}