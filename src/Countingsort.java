import java.util.Scanner;

// Java implementation of Counting Sort
class CountingSort
{
	void sort(int arr[])
	{
		int n = arr.length;

		// The swapArray character array that will have sorted arr
		int[] swapArray = new int[n];

		//finds biggest variable in array
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) max = arr[i] + 1;
		}

		// Create a count array to store count of individual
		// characters and initialize count array as 0
		int count[] = new int[max];
		for (int i=0; i<max; ++i)
			count[i] = 0;

		// store count of each character
		for (int i=0; i<n; ++i)
			++count[arr[i]];

		// Change count[i] so that count[i] now contains actual
		// position of this character in swapArray array
		for (int i=1; i<=max-1; ++i)
			count[i] += count[i-1];

		// Build the swapArray character array
		// To make it stable we are operating in reverse order.
		for (int i = n-1; i>=0; i--)
		{
			swapArray[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}

		// Copy the swapArray array to arr, so that arr now
		// contains sorted characters
		for (int i = 0; i<n; ++i)
			arr[i] = swapArray[i];
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

		CountingSort sortMe = new CountingSort();

		sortMe.sort(array);

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

/* geht nur mit bis zu 9-stelligen positiven Zahlen*/