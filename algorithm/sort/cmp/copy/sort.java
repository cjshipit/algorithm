package sort.cmp.copy;

public abstract class sort {
    public static void swap(int i,int j,int[] array)
    {
    	int temp = array[i] ;
    	array[i] = array[j] ;
    	array[j] = temp ;
    	
    }
}
