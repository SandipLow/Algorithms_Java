import java.util.PriorityQueue;

public class L1_Sorting {
    public static void swap(int[] arr, int i, int j) {
        arr[j] = (arr[i]+arr[j])-(arr[i]=arr[j]);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i=0; i<n; i++) {
            int minIdx = i;

            for (int j=i+1; j<n; j++) {
                if (arr[minIdx] > arr[j]) 
                    minIdx = j;
            }

            swap(arr, i, minIdx);

        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i=0; i<n; i++) {
            int j = i;

            while (j>0 && arr[j-1] > arr[j]) {
                swap(arr, j-1, j);

                j--;
            }
        }
    }

    public static void merge(int[] arr, int s, int e, int mid) {
        int[] ans = new int[e-s+1];

        int i=s, j=mid+1, k=0;
        
        while (i<=mid && j<=e) {
            if (arr[i] < arr[j]) {
                ans[k++] = arr[i];
                i++;
            }

            else {
                ans[k++] = arr[j];
                j++;
            }
        }

        while (i<=mid) {
            ans[k++] = arr[i];
            i++;
        }

        while (j<=e) {
            ans[k++] = arr[j];
            j++;
        }

        for (int idx=0; idx<e-s+1; idx++) {
            arr[s+idx] = ans[idx];
        }

    }

    public static void mergeSort(int[] arr, int s, int e) {
        if (s>=e) return;
        
        int mid = (s+e)/2;

        mergeSort(arr, s, mid);
        mergeSort(arr, mid+1, e);

        merge(arr, s, e, mid);
    }

    public static void mergeSort(int[] arr)  {
        mergeSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int s, int e) {
        if (s >= e) return;
    
        int pivot = arr[s];
        int pivotIdx = s;
    
        // Partitioning the array
        for (int i = s + 1; i <= e; i++) {
            if (arr[i] < pivot) {
                pivotIdx++;
                int tmp = arr[pivotIdx];
                arr[pivotIdx] = arr[i];
                arr[i] = tmp;
            }
        }
    
        // Swap pivot to its correct position
        int tmp = arr[pivotIdx];
        arr[pivotIdx] = arr[s];
        arr[s] = tmp;
    
        // Recursively sort the subarrays
        quickSort(arr, s, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, e);
    }
    
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void countSort(int arr[]) {
        int maxi = Integer.MIN_VALUE, n = arr.length;

        for (int a: arr) {
            maxi = Integer.max(a, maxi);
        }

        int[] count = new int[maxi+1];

        for (int a: arr) {
            count[a]++;
        }

        int j=0, i=0;

        while (i<n && j<=maxi) {
            while (count[j]>0) {
                arr[i++] = j;
                count[j]--;
            }
            j++;
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int a: arr) heap.add(a);

        for (int i=0; i<n; i++) {
            arr[i] = heap.poll();
        }
    }

    public static void dutchNationalFlag(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1;

        while (mid<=high) {
            if (arr[mid]==0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid]==1) {
                mid++;
            }
            else { // arr[mid]==2
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 4, 2, 1, 4 };
        int n = arr.length;

        heapSort(arr);


        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}