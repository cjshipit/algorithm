package sort;

import java.util.ArrayList;

import sort.cmp.heapSort;
import sort.cmp.insertSort;
import sort.cmp.quickSort;
import sort.nocmp.countingSort;
import sort.nocmp.redixSort;
import sort.util.arrayUtil;
import sort.util.randArray;
import unionFind.quickFind;

public class Main
{
   
	public static void main(String[] args)
	{
	  
		quickFind q = new quickFind(10);
		System.out.println(q.find(1));
		q.union(1, 2);
		q.union(2, 3);
		System.out.println(q.compare(1, 3));
	}
}
