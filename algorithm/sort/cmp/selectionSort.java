package sort.cmp;

public class selectionSort extends sort{
	public static int[] sort(int[] array) {
	    for(int i=0;i<array.length;i++) {
	    	int max = array[0];
	    	int index = 0;//最大值的下标
	    	for(int j=1;j<(array.length)-i;j++) {
	    		if(array[j]>=max) {
	    			max = array[j];
	    			index = j ;
	    		}    		
	    	}
	     array[index] = array[array.length-i-1];
         array[array.length-i-1] = max;	
	    	
	    	
	  }
	   return array;
	    
		
	}
		
		
		
}
