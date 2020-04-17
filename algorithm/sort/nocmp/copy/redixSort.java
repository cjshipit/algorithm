package sort.nocmp.copy;


public class redixSort {
	private static void countingSort(int redix,int[] array) {
		//因为只有0-9 所以用长度为9的数组就行
		int[] newArray = new int[10] ;
		//统计每个数字出现的次数
		for(int i=0;i<array.length;i++) {
			newArray[(array[i]/redix)%10]++;
		}
		//修改newArray数组为起一个+本次
		for(int i=1;i<newArray.length;i++) {
			  newArray[i] = newArray[i-1] + newArray[i] ;		  
		  }
		
		
		int[] array2 = new int[array.length] ;
		for(int i=array.length-1;i>=0;i--) {
			  
			  array2[newArray[(array[i]/redix)%10]-1] = array[i] ;
			  newArray[(array[i]/redix)%10]--;
			  
			  
		 }
		  //将array2数组中数据写入array中
		  for(int i=0;i<array.length;i++) {
			  array[i] = array2[i] ;
			  
			  
		  }
		 return ;  
		
	}
	
	
	
	
	public static void sort(int[] array) {
	   //我们选取计数排序对 每个基数(每个位上的数字)进行排序
	   int max = array[0];
	   for(int i=1;i<array.length;i++) {
		   if(array[i]>max) {
			   max = array[i];   
		   }
	   }
	   /*
	    * 取出个位数 i/1%10
	    * 取出十位数i/10%10
	    * ......
	    * */
	   //对每一位数调用计数排序
	   for(int i=1;i<=max;i=i*10) {
		   countingSort(i,array);   
	   }
		return ;
		
		
	}
                
}
