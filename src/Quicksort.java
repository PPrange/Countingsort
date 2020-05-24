import java.util.Scanner;

public class Quicksort {

	
 	//int p = 1;
	int swap;
	int[] array;
	//int r = array.length;

	public Quicksort(int[] array) {
		this.array = array;
	}
	
	public int partition (int p, int r) {
		int x = array[r];
		int i = p - 1;

		for (int j=p; j < r; j++) {
	
			if (array[j] <= x) {
			i = i + 1;
			swap = array[i];
			array[i] = array[j];
			array[j] = swap;
			}

		}
		swap = array[i+1];
		array[i+1] = array[r];
		array[r] = swap;
		return i++;
	}


	public int[] quicksort(int p, int r) {
		int q;

		if (p < r) {
			q = partition (p, r);
			System.out.println(q);
			quicksort(p, q-1);
			quicksort(q + 1, r);
		}
		return array;
	}




	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the amount of numbers to sort:");
		int length = s.nextInt();

		System.out.println("Enter the numbers to sort:");
		int[] array = new int[length];
		for(int i=0; i<length; i++ ) {
			array[i] = s.nextInt();
		}

		Quicksort sortMe = new Quicksort(array);

		sortMe.quicksort(0,array.length-1);

		for (int i=0; i<array.length; ++i) {
			if(i == 0) {
				System.out.print(array[i]);
			}else{
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

while partially orderring the arrays

puts all the arrays
	
*/