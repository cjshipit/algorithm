package sort.cmp;

public class bubbleSort{
    //冒泡排序 双层for循环
	public static int[] sort(int[] array){
		for(int i=0;i<array.length;i++){
		    //第一个for 表示一共要进行多少趟排序 选出多少个最大值 
			for(int j=0;j<array.length-i-1;j++){
			//第二个for循环表示要排序几个元素
		    	 if(array[j]<array[j+1]){
		    		int temp = array[j];
		    		array[j] = array[j+1];
		    		array[j+1] = temp;	 
		    	 }	    	 
		     }	
		}	
		return array ;
	}
	/*
	* 冒泡排序的优化版(1)
	 *   思路:
	 *     如果一趟排序 没有进行交换 说明没有逆序对 数组已经有序了
	 *     这样最快时间复杂度为O(n²)  
	 *   实现方法:
	 *      用sorted判断是否进行了比较
	 * */
	public static int[] sort2(int[] array){
	   for(int i=0;i<array.length;i++){
		   //第一个for 表示一共要进行多少趟排序 选出多少个最大值 
		   boolean sorted = true ;
			  for(int j=0;j<array.length-i-1;j++){
			   //第二个for循环表示要排序几个元素
				  if(array[j]<array[j+1]){
				     int temp = array[j];
				     array[j] = array[j+1];
				     array[j+1] = temp;
				     sorted =  false ;
				  }	    	 
			  }	
			  if(sorted==true){
				  return array ;	  
			  }
	   }
			return array ;
	  }
/*
	 * 冒泡排序优化版本(2)
	 *   思路:
	 *     在每次排序时 记录最后一个交换元素的位置 在这个位置之后不存在逆序对
	 *   所以下一趟排序就只用比较到交换的位置。(因为冒泡的比较是从左到右扫描 所以可以判断是否有逆序对)
	 *   实现: 
	 *      用一个整形保存比较的位置 
	 * 
	 * */
	public static int[] sort3(int[] array){
		int end = array.length-1;
		for(int i=0;i<array.length;i++){
		    //第一个for 表示一共要进行多少趟排序 选出多少个最大值 
			int sortedIndex = 0; //完全有序时只循环一次
			for(int j=0;j<end;j++){
			//第二个for循环表示要排序几个元素
		    	 if(array[j]<array[j+1]){
		    		int temp = array[j];
		    		array[j] = array[j+1];
		    		array[j+1] = temp;	
		    		sortedIndex = j ;
		    	 }	    	 
		     }	
			end = sortedIndex;
	    }	
	return array ;
    }


}
