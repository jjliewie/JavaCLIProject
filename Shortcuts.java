package firstproject;

public class Shortcuts{
    
    void printArray(int[] arr){

        for(int i = 0; i < arr.length; i++) System.out.println(arr[i]);
    }

    int getMin(int[] arr){

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }

    int getMax(int[] arr){

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    int getSum(int[] arr){

        int sum = 0;
        for(int i = 0; i < arr.length; i++) sum += arr[i];
        return sum;
    }

    double getAverge(int[] arr){

        int sum = 0;
        for(int i = 0; i < arr.length; i++) sum += arr[i];
        return (double)sum/arr.length;
    }

    boolean hasDuplicate(int[] arr){

        for(int i = 0; i < arr.length-1; i++) if(arr[i] == arr[i+1]) return false;
        return true;
    }

    boolean sorted(int[] arr){
        
        for(int i = 0; i < arr.length-1; i++) if (arr[i] > arr[i+1]) return false;
        return true;
    }

    void spacedLines(String a){
        System.out.println(a);
        System.out.println();
    }

}