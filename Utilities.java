package firstproject;
import java.util.*;

public class Utilities {

    // boxed hi (for start of program)

    void print_rectangle(int n, int m)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (i == 1 || i == n ||j == 1 || j == m){
                    System.out.print("*");		
                }
				else{
                    if(i == (n/2)+1){
                        if(j == m/2 -1){
                            System.out.print("h");
                        }
                        else if(j == m/2){
                            System.out.print("i");
                        }
                        else if(j == m/2 +1){
                            System.out.print("!");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    else{ System.out.print(" ");}
                }
			}
			System.out.println();
        }
	}

    // binary search algorithm, time complexity: O(logN)

    int binsearch(int[] a, int target){
        
        int left = 0;
        int right = a.length;

        if(right == 1) return (a[0] == target) ? 0 : -1;

        while(left <= right){

            int mid = (left + right)/2;
            if (a[mid] == target) return mid;
            if(a[mid] > target) right=mid-1; else left=mid+1;

        }

        return -1;
    }

    boolean checkEquality(int[] x, int[] y){

        Sorting msort = new Sorting();
        msort.mergesort(x, 0, x.length-1);
        msort.mergesort(y, 0, y.length-1);

        if(x.length != y.length){
            return false;
        }

        for(int i = 0; i < x.length-1; i++){
            if(x[i] == x[i+1] || y[i] == y[i+1]){
                return false;
            }
        }

        return Arrays.equals(x, y);
    }

    // check if String is an integer value

    boolean isInt(String s){

        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
