public class Quicksort {

	
 	int p = 1;
	int swap; //perhaps = 0
	int[] array;
	int r = array.length;

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

		swap = array[i+1];
		array[i+1] = array[r];
		array[r] = swap;

		}
		return i++;
	}


	public int[] quicksort(int p, int r) {
		int q;
		if (p < r) {
			q = partition (r, p);
			quicksort(p, q);
			quicksort(q + 1, r);
		}
		return array;
	}




	public static void main(String[] args) {

	Quicksort array1 = new Quicksort (new int[]{5,7,4,2,3,1,9,8,6});


	int[] sortArray1 = array1.quicksort(1,9);

	System.out.println(sortArray1[1]);
	
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