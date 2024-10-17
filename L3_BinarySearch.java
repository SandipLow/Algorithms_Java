import java.util.*;

public class L3_BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int n = arr.length, s, e;

        s = 0;
        e = n-1;

        while (s<=e) {
            int mid = (s+e)/2;

            if (arr[mid]==key) return mid;
            else if (arr[mid] < key) s = mid+1;
            else e = mid-1;
        }

        return -1;
    }

    public static int searchRotatedSortedArray(int[] arr, int target) {
        int n = arr.length, s, e, mid;
        
        s = 0;
        e = n-1;

        // zone 1:
        if (target >= arr[s]) {
            while (s<=e) {
                mid = (s+e)/2;

                if (arr[mid]==target) return mid;
                else if (arr[s]==arr[mid] && arr[e]==arr[mid]) {
                    s++;
                    e--;
                }
                else if (arr[mid] >= arr[s]) {
                    if (arr[mid] > target) e = mid-1;
                    else s = mid+1;
                }
                else e = mid-1;
            }
        }
        // zone 2:
        else {
            while (s<=e) {
                mid = (s+e)/2;

                if (arr[mid]==target) return mid;
                else if (arr[s]==arr[mid] && arr[e]==arr[mid]) {
                    s++;
                    e--;
                }
                else if (arr[mid] <= arr[e]) {
                    if (arr[mid] > target) e = mid-1;
                    else s = mid+1;
                }
                else s = mid+1;
            }
        }

        return -1;
    }

    public static int pivotRotatedSortedArray(int[] arr) {
        int n = arr.length, s, e, mid, ans;

        s=0;
        e=n-1;
        ans = -1;

        while (s<=e) {
            mid = (s+e)/2;

            if (arr[mid]<=arr[n-1]) {
                e=mid-1;
                ans = arr[mid];
            }
            else s=mid+1;
        }

        return ans;
    }

    private static boolean isPossible(int val, int[] arr, int k) {
        int curr=0;
        
        for (int a: arr) {
            if (curr+a > val) {
                curr = a;
                k--;
            }
            else curr+=a;
        }
        return k>=0;
    } 

    public static int maximizeMinimum(int[] arr, int k) {
        int s, e, mid, ans;

        ans = -1;
        s = 0;
        e = 0;

        for (int a: arr) e+=a;

        while(s<=e) {
            mid = (s+e)/2;

            if (isPossible(mid, arr, k)) {
                ans = mid;
                s = mid+1;
            }
            else {
                e = mid-1;
            }
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

        int ans = pivotRotatedSortedArray(arr);

        System.out.println(ans);

        sc.close();
    }
    
}