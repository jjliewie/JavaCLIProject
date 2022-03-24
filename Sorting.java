package firstproject;

public class Sorting {

    // merge sort

    void merge(int arr[], int p, int q, int r) {
  
        int n1 = q-p+1;
        int n2 = r-q;
    
        int first[] = new int[n1];
        int second[] = new int[n2];
    
        for (int i = 0; i < n1; i++) first[i] = arr[p + i];
        for (int j = 0; j < n2; j++) second[j] = arr[q + 1 + j];

        int i = 0;
        int j = 0;
        int k = p;

        while (i < n1 && j < n2) {
            if (first[i] <= second[j]) {
                arr[k] = first[i];
                i++;
            } else {
                arr[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = first[i];
            i++;
            k++;
        }
    
        while (j < n2) {
            arr[k] = second[j];
            j++;
            k++;
        }

    }

    void mergesort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // bubble sort

    void bubblesort(int [] arr){

        int n = arr.length;  
        int temp;

        for(int i = 0; i < n; i++){  
            for(int j = 1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;  
                }             
            }  
        } 
    } 

    void bubbleswapsort(int [] arr){

        boolean swap = true;
        int temp;
        while(swap){
            swap = false;
            for(int i = 0; i<arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    temp = arr[i];  
                    arr[i] = arr[i+1];  
                    arr[i+1] = temp;  
                    swap = true;
                }
            }
        }

    }

    // selection sort

    void selectionsort(int[] arr){
        int temp;
        for(int i = 0; i < arr.length-1; i++){
            int min = i; 
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
    
}