import java.util.Scanner;

public class Quicksort {

	int swap; //integer to swap position i and j in array
	int[] array; //stores array to sort

	public Quicksort(int[] array) { //constructor gets an array
		this.array = array;
	}
	
	public int partition (int p, int r) { //partition gets position of first and last element of array
		int i = p; //stores copy of value p in i
		int x = array[r]; //stores pivot element

		for (int j=p; j < r; j++) { //iterates over each element and compares with pivot element
			if (array[j] < x) { //condition if value of element at j position smaller than x
			swap = array[i]; //if it's the case switch value of i with value of j
			array[i] = array[j];
			array[j] = swap;
			i++; //increases i after every loop in if condition
			}

		}
		swap = array[i]; //swaps value of i with value of r each partition
		array[i] = array[r];
		array[r] = swap;
		return i; //returns value of i
	}


	public int[] quicksort(int p, int r) { //quicksort action
		int q; //new datatype q

		if (p < r) { //as long as p smaller r do the partition
			q = partition (p, r); //do partition and set q equal i
			quicksort(p, q-1); //quicksort for elements left of pivot
			quicksort(q + 1, r); //quicksort for elements right of pivot
		}
		return array; //returns quicksorted array
	}




	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in); //new object of class scanner

		System.out.println("Enter the amount of numbers to sort:");
		int length = s.nextInt(); //stores value which represents amount of numbers we need for array

		System.out.println("Enter the numbers to sort:");
		int[] array = new int[length]; //creates new array with wished length
		for(int i=0; i<length; i++ ) { //stores incoming values in array
			array[i] = s.nextInt();
		}

		Quicksort sortMe = new Quicksort(array); //creates new object which possess array

		sortMe.quicksort(0,array.length-1); //do quicksort

		for (int i=0; i<array.length; ++i) { //gives sorted array out
			if(i == 0) { //for first element in array
				System.out.print(array[i]);
			}else{ //all other elements
				System.out.print(" : ");
				System.out.print(array[i]);
			}
		}
	}
}

/*
3. steps
1. partition array divided in two part - sorts the two parts by quicksort

p = position in the array of the first element of the considered part
r = last position in the considered part

first one p = 1 and r = length array
empty array p and r are the same -> nothing to do -> reason for if p<r

while partially ordering the arrays

puts all the arrays
	
*/