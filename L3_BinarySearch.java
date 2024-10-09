import java.util.*;

public class L3_BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int n = arr.length;
        int s = 0;
        int e = n-1;

        while (s<e) {
            int mid = (s+e)/2;

            if (arr[mid]==key) return mid;
            else if (arr[mid] < key) s = mid+1;
            else e = mid-1;
        }

        return -1;
    }

    public static int lowerBound(int[] arr, int key) {
        int n = arr.length;
        int s = 0;
        int e = n-1;

        int ans = -1;

        while (s<=e) {
            int mid = (s+e)/2;

            if (arr[mid]<=key) {
                s = mid+1;
                ans = mid;
            }
            else if (arr[mid] > key) e = mid-1;
        }

        return ans;
    }

    public static int upperBound(int[] arr, int key) {
        int n = arr.length;
        int s = 0;
        int e = n-1;

        int ans = -1;

        while (s<=e) {
            int mid = (s+e)/2;

            if (arr[mid] < key) s=mid+1;
            else if (arr[mid] >= key) {
                e = mid-1;
                ans = mid;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int target = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        int ans = upperBound(arr, target);

        System.out.println(ans);

        sc.close();
    }
    
}