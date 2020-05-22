import java.util.Scanner;

// Java implementation of Counting Sort
class CountingSort
{
	void sort(int arr[])
	{
		int n = arr.length;

		// The output character array that will have sorted arr
		int[] output = new int[n];

		//finds biggest variable in array
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) max = arr[i] +10;
		}

		// Create a count array to store count of inidividul 
		// characters and initialize count array as 0 
		int count[] = new int[max];
		for (int i=0; i<max; ++i)
			count[i] = 0;

		// store count of each character 
		for (int i=0; i<n; ++i)
			++count[arr[i]];

		// Change count[i] so that count[i] now contains actual 
		// position of this character in output array 
		for (int i=1; i<=max-1; ++i)
			count[i] += count[i-1];

		// Build the output character array 
		// To make it stable we are operating in reverse order. 
		for (int i = n-1; i>=0; i--)
		{
			output[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}

		// Copy the output array to arr, so that arr now 
		// contains sorted characters 
		for (int i = 0; i<n; ++i)
			arr[i] = output[i];
	}


	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the length of the array:");
		int length = s.nextInt();

		System.out.println("Enter the elements of the array:");
		int[] arr = new int[length];
		for(int i=0; i<length; i++ ) {
			arr[i] = s.nextInt();
		}

		CountingSort ob = new CountingSort();

		ob.sort(arr);

		for (int i=0; i<arr.length; ++i) {
			if(i == 0) {
				System.out.print(arr[i]);
			}else{
				System.out.print(" : ");
				System.out.print(arr[i]);
			}
		}
	}
}

/* geht nur bis zahl 256*/