import java.util.*;

public class Arrays {
    static class Pair<E> {
        public E first;
        public E second;

        Pair() {}

        Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }
    }

    @SuppressWarnings("unused")
    private static Pair<Integer> kSumSubarray(int[] arr, int k) {
        Pair<Integer> ans = new Pair<>();
        ans.first=0; 
        ans.second=0;
        
        // only positives TC->O(2N) SC->O(1)
        // int i=0, j=0, n=arr.length, curr=arr[0], maxi=0;

        // while (j<n) {
        //     while (i<=j && curr>k) {
        //         curr-=arr[i++];
        //     }

        //     if (curr==k && maxi<j-i+1) {
        //         maxi = j-i+1;
        //         ans = new Pair(i, j)
        //     }
            
        //     j++;
        //     if (j<n) curr+=arr[j];
        // }

        // both +ve and -ve TC->O(N) SC->O(N)
        Map<Integer, Integer> map = new HashMap<>();
        int curr=0, n=arr.length, maxi=0;

        for (int i=0; i<n; i++) {
            curr+=arr[i];
            
            if (!map.containsKey(curr)) {
                map.put(curr, i);
            }

            if (curr==k && i+1>maxi) {
                maxi = i+1;
                ans = new Pair<>(0, i);
            }

            if (map.containsKey(curr-k)) {
                int start = map.get(curr-k)+1;
                if (i-start+1 > maxi) {
                    maxi = i-start+1;
                    ans = new Pair<>(start, i);
                }
            }
        }



        return ans;
    }


    @SuppressWarnings("unused")
    private static int majorityElement(int[] arr) {
        int ans=-1, cnt=0, n=arr.length;

        for (int i=0; i<n; i++) {
            if (arr[i]==ans) {
                cnt++;
            }
            else if (cnt<=1) {
                ans=arr[i];
                cnt=1;
            }
            else {
                cnt--;
            }
        }

        return ans;
    }

    
    @SuppressWarnings("unused")
    private static int kadane(int[] arr) {
        int curr=0;
        int ans = Integer.MIN_VALUE;

        for (int a: arr) {
            curr = Math.max(a, curr+a);
            ans = Math.max(ans, curr);
        }

        return ans;
    }

    
    private static Pair<Integer> maxSumSubarray(int[] arr) {
        int start=0, end=0, n=arr.length, s=0, e=0;

        int curr = 0;
        int ans = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            curr = Math.max(arr[i], curr+arr[i]);

            if (curr==arr[i]) {
                s = i;
            }

            if (curr > ans) {
                ans = curr;
                e = i;
                start = s;
                end = e;
            }
        }

        return new Pair<>(start, end);

    }

    public static void main(String[] args) {
        int arr[] = {1, -2, 3, 4, -2, 6, -8, 3};
        Pair<Integer> ans = maxSumSubarray(arr);

        for (int i=ans.first; i<=ans.second; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}