import java.util.*;

public class L2_Array {
    static class Pair<E> {
        public E first;
        public E second;

        Pair() {}

        Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[j] = (arr[i]+arr[j])-(arr[i]=arr[j]);
    }


    public static Pair<Integer> kSumSubarray(int[] arr, int k) {
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

    public static int majorityElement(int[] arr) {
        // Element appearing > n/2 times :

        // int ans=-1, cnt=0, n=arr.length;

        // for (int i=0; i<n; i++) {
        //     if (arr[i]==ans) {
        //         cnt++;
        //     }
        //     else if (cnt<=1) {
        //         ans=arr[i];
        //         cnt=1;
        //     }
        //     else {
        //         cnt--;
        //     }
        // }

        // return ans;

        // Element appearing > n/3 times :

        int n = arr.length;
        int el1 = Integer.MIN_VALUE, cnt1 = 0;
        int el2 = Integer.MIN_VALUE, cnt2 = 0;

        for (int a: arr) {
            if (a==el1) {
                cnt1++;
            } 
            else if (a==el2) {
                cnt2++;
            }
            else if (cnt1==0) {
                cnt1=1;
                el1=a;
            }
            else if (cnt2==0) {
                cnt2=1;
                el2=a;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int a: arr) {
            if (a==el1) cnt1++;
            if (a==el2) cnt2++;
        }

        return cnt1 > n/3 ? el1 : cnt2 > n/3 ? el2 : -1;
    }

    public static int kadane(int[] arr) {
        int curr=0;
        int ans = Integer.MIN_VALUE;

        for (int a: arr) {
            curr = Math.max(a, curr+a);
            ans = Math.max(ans, curr);
        }

        return ans;
    }

    public static Pair<Integer> maxSumSubarray(int[] arr) {
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

    public static int[] nextPermutation(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        for (int i=0; i<n; i++) {
            ans[i] = arr[i];
        }

        int swapIdx = -1;
        
        for (int i=n-2; i>=0; i--) {
            if (ans[i] < ans[i+1]) {
                swapIdx = i;
                break;
            }
        }

        if (swapIdx==-1) {
            Arrays.sort(ans);
            return ans;
        }

        for (int i=n-1; i>=swapIdx; i--) {
            if (ans[i] > ans[swapIdx]) {
                swap(ans, swapIdx, i);
                break;
            }
        }

        Arrays.sort(ans, swapIdx+1, n);
        return ans;
    }

    public static void setMatrixZero(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }

        System.out.println();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rows[i]==0 || cols[j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void spiralTraversal(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int i=0, j=n-1, k=0, l=m-1;

        while (i<=j && k<=l) {
            // top left -> top right
            for (int t=i; t<=j; t++) {
                System.out.print(matrix[k][t]);
                System.err.print(" ");
            }
            k++;

            // top right -> down right
            for (int t=k; t<=l; t++) {
                System.out.print(matrix[t][j]);
                System.err.print(" ");
            }
            j--;

            if (k<=l) {
                // down right -> down left
                for (int t=j; t>=i; t--) {
                    System.out.print(matrix[l][t]);
                    System.err.print(" ");
                }
                l--;
            }

            if (i<=j) {
                // down left -> top left
                for (int t=l; t>=k; t--) {
                    System.out.print(matrix[t][i]);
                    System.err.print(" ");
                }
                i++;
            }
        }
    }

    public static void rotateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) break;

                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i=0; i<m; i++) {
            int s=0, e=n-1; 
            while (s<e) {
                swap(matrix[i], s, e);
                s++;
                e--;
            }
        }
    }

    public static List<List<Integer>> threesum(int[] arr, int target) {
        
        // int n = arr.length;
        // Set<List<Integer>> ans = new HashSet<>();
        
        // for (int i=0; i<n; i++) {
        //     Set<Integer> st = new HashSet<>();

        //     for (int j=i+1; j<n; j++) {
        //         int req = target-arr[j]-arr[i];
                
        //         if (st.contains(req)) {
        //             List<Integer> tmp = Arrays.asList(arr[i], req, arr[j]);
        //             Collections.sort(tmp);
        //             ans.add(tmp);
        //         }

        //         st.add(arr[j]);
        //     }
        // }

        // return new ArrayList<>(ans);

        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        for (int i=0; i<n; i++) {
            int j = i+1;
            int k = n-1;

            while (j<k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum > target) {
                    k--;
                }
                else if (sum < target) {
                    j++;
                }
                else { // sum == target
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j<k && arr[j]==arr[j+1]) j++;
                    while (j<k && arr[k]==arr[k-1]) k--;
                }
            }
        }

        return ans;
    }

    public static List<List<Integer>> foursum(int[] arr, int target) {
        // int n = arr.length;
        // Set<List<Integer>> ans = new HashSet<>();

        // for (int i=0; i<n; i++) {
        //     for (int j=i+1; j<n; j++) {

        //         Set<Long> st = new HashSet<>();

        //         for (int k=j+1; k<n; k++) {
        //             long sum = (long) arr[i] + arr[j] + arr[k];
        //             long req = (long) target - sum;

        //             if (st.contains(req)) {
        //                 List<Integer> tmp = Arrays.asList(arr[i], arr[j], arr[k], (int)req);
        //                 Collections.sort(tmp);
        //                 ans.add(tmp);
        //             }

        //             st.add((long) arr[k]);
        //         }
        //     }
        // }

        // return new ArrayList<>(ans);

        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        for (int i=0; i<n; i++) {

            if (i>0 && arr[i]==arr[i-1]) continue;

            for (int j=i+1; j<n; j++) {

                if (j>0 && arr[j]==arr[j-1]) continue;

                int k = j+1;
                int l = n-1;

                while (k<l) {
                    long sum = (long)arr[i] + arr[j] + arr[k] + arr[l];

                    if (sum < target) k++;
                    else if (sum > target) l--;
                    else {
                        List<Integer> tmp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        ans.add(tmp);
                        
                        k++;
                        l--;
                        while (k<l && arr[k]==arr[k-1]) k++;
                        while (k<l && arr[l]==arr[l+1]) l--;
                    }


                }
                
            }
        }

        return ans;
        
    }

    public static int[] missingRepeatingNumber(int[] arr) {
        int n = arr.length;

        int sum = n*(n+1)/2;
        int sum2 = n*(n+1)*(2*n+1)/6;

        for (int a: arr) {
            sum -= a;
            sum2 -= a*a;
        }

        int missing = (sum + sum2/sum) / 2;
        int repeating = missing - sum;


        return new int[]{missing, repeating};

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

        int[] ans = missingRepeatingNumber(arr);

        for (int a: ans) {
            System.out.print(a);
            System.out.print(" ");
        }
        System.out.println();


        sc.close();
    }
}