package sort.nocmp.copy;

public class countingSort {
   /**
    * 经典的计数排序代码
    * 缺点: 浪费内存
    *       不稳定
    *       只能排大于0的数
    * 
    * 
    * 
    * */
   public static void sort(int[] array) {
     //找出数组中的最大值
	 int max = array[0];
	 for(int i=1;i<array.length;i++) {
    	  if(array[i]>max) {
    		  max = array[i];
    	  }
     }
     //开辟最大值那么大的内存空间
	 int[] newArray = new int[max+1] ;
	 //统计每个数字出现的次数
	 for(int i=0;i<array.length;i++) {
		 newArray[array[i]]++;	 
	 }
	 //根据统计的出现次数来排序
	 int index = 0;//元素要放的位置
     for(int i=0;i<=max;i++) {
    	 while(newArray[i]!=0) {
    		array[index] = i ;
    		index++;
    		newArray[i]--;
    		 
    		 
    		 
    	 }
    	 
    	 
    	 
     }	 
    	 return ;
   }
   /*
    * 改进版的计数排序 思路:
    *     1 只开辟max-min+1 这么大的内存 数组的索引-min 就是元素的值
    *     2 数组中不存元素的个数 而是存元素个数+小于他的数的元素个数
    *       这样可以通过 newArray[i]-1的方式判断出该元素在排号顺序数组中的位置(不用减到0)
    *       而且先找到的是最后一个位置 这样就可以稳定了
    * 
    * */
   public static void sort2(int[] array) {
	   //找到最大值和最小值
	   int max = array[0];
	   int min = array[0];
		 for(int i=1;i<array.length;i++) {
	    	  if(array[i]>max) {
	    		  max = array[i];
	    	  }
	    	  if(array[i]<min) {
	    		  min = array[i];		  
	    	  }
	     }
	  int[] newArray = new int[max-min+1] ;
	  for(int i=0;i<array.length;i++) {
			 newArray[array[i]-min]++;	 
		 }
	  //将元素改为 元素个数+之前的统计个数
	  for(int i=1;i<newArray.length;i++) {
		  newArray[i] = newArray[i-1] + newArray[i] ;		  
	  }
	  //扫描原数组 并且归位元素
	  int[] array2 = new int[array.length] ;
	  for(int i=array.length-1;i>=0;i--) {
		  
		  array2[newArray[array[i]-min]-1] = array[i] ;
		  newArray[array[i]-min]--;
		  
		  
	  }
	  //将array2数组中数据写入array中
	  for(int i=0;i<array.length;i++) {
		  array[i] = array2[i] ;
		  
		  
	  }
	 return ;  
   }
	
}
