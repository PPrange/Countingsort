import java.util.Scanner;

class CountingSort
{
	void sort(int array[])
	{
		int arrayLength = array.length;

		//creates swapArray where the sorted array is cached
		int[] swapArray = new int[arrayLength];

		//finds biggest variable in array
		int max = 0;
		for(int x = 0; x < array.length; x++) {
			if(array[x] > max) max = array[x] + 1;
		}

		//creates a count array and fills it up with zeros
		int count[] = new int[max];
		for (int x=0; x<max; x++)
			count[x] = 0;

		//count each character and stores in count array
		for (int x=0; x<arrayLength; x++)
			count[array[x]]++;

		//change count to store the right place per number
		for (int x=1; x<=max-1; x++)
			count[x] += count[x-1];

		//store unsorted numbers from array in right order in swapArray
		for (int x = arrayLength-1; x>=0; x--)
		{
			swapArray[count[array[x]]-1] = array[x];
			count[array[x]]--;
		}

		//override the input array with sorted swapArray
		for (int x = 0; x<arrayLength; x++)
			array[x] = swapArray[x];
	}


	public static void main(String args[])
	{
		//create scanner
		Scanner s = new Scanner(System.in);

		//ask user for input
		System.out.println("How many numbers should be sorted?");
		int arrayLength = s.nextInt();

		System.out.println("Enter " +arrayLength+ " numbers to be sorted!");
		int[] array = new int[arrayLength];
		for(int i=0; i<arrayLength; i++ ) {
			array[i] = s.nextInt();
		}

		//create sortMe object
		CountingSort sortMe = new CountingSort();

		//use sort method to sort array
		sortMe.sort(array);

		//print the input numbers in sorted order
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
