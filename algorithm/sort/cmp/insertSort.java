package sort.cmp;

public class insertSort extends sort {
	  public static int[] sort(int[] array) {
		  //考察元素 向前插入
		  for(int i=1;i<array.length;i++) {
			 int temp = array[i];
			 int cut =  i - 1 ;
			 while(cut>=0&&temp<array[cut]) {
				  array[cut+1]=array[cut];//向后挪动元素	
	              cut = cut-1;//考察前一个元素		
 			 }
			 array[cut+1] = temp;
			  
			  
		  }
			  
		  
		  
		  
		  
		  return array ;
		  
		  
		  
	  }
      /*
       * 优化版本:将查找位置的方法改变为二分查找
       * 
       * */
	  public static int[] sort2(int[] array) {
		  for(int i=1;i<array.length;i++) {
			  int temp = array[i];
			  //查找比该元素大的第一个元素的下标 用改进的二分查找
			  int index = binarySerch(array,temp,i);
			  //将索引之后的元素往后移动一位
			  for(int j=i-1;j>=index;j--) {
				  array[j+1] = array[j];
			  }  
			  array[index] = temp ;
			  }	    
	     return array ;
		  
	  }
	  
	  private static int binarySerch(int[] array,int target,int end) {
			 //注意begin和end的变化  begin表示第一个元素的下标 end表示最后一个元素下标+1
		     //>=在右边查找 <在左边查找 知道end==begin
			 int begin = 0;
			 while(begin<end) {
				 if(target<=array[(begin+end)/2]){
					 end = (begin+end)/2 ;	 
				 }
				 else if(target>array[(begin+end)/2]) {
					 begin = (begin+end)/2 + 1 ;	 
				 }
				 
			 }
				 
			 return begin;
			 
			 
		 }
}
