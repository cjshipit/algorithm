package sort.cmp.copy;

public class quickSort extends sort{
	/*
	 * 很容易范的错误：必须把基准元素放在 它应该存在的位置 不然会出问题
	 * 
	 * 单指针移动的写法
	 *    本程序的基准元素 必须从数组中选 如果在数组外选 肯能陷入死递归 
	 *        因为如果所有元素都小于基准元素那么就得换元素
	 *     
	 * 
	 * */
	  public static int[] sort(int[] array) {
		  int begin = 0;
		  int end = array.length-1;
		  int temp = array[0];//需要比较的基准元素
		  while(begin<end) {
			       //=保证 在 1 2 2 2 2  情况下右边至少有一个元素(如果全部小于基准值 除了array[begin])保证至少一个排好 防止死递归
				   if(array[end]>=temp) {
				   end--;
				   }
				   else if(array[end]<temp) { 
					  //先交换 再++  2 1 这种情况 先++再交换就相当于没交换
					  swap(begin,end,array);//交换begin和end的元素
					  begin++;  
				   }   		  
		  }
		  if(array[begin]<=temp) {
		  sort(array,0,begin);
		  sort(array,begin+1,array.length-1);
		  }
		  else {
			  sort(array,0,begin-1);
			  sort(array,begin,array.length-1);
			  
		  }
		  
		  return array;
		  
		  
	  }
		  
		  
       public static void sort(int[] array,int begin,int end) {
		  //begin表示第一个元素的下标 end表示最后一个元素下标
    	   
    	   //必须是<= 因为可能传进来 0 -1这种情况
    	   if(end<=begin) {
    		   //数组只有一个元素 那么直接返回
    		   return ;
    	   }
    	   int be = begin; 
    	   int ed = end;//备份一下
    	   int temp = array[begin];
    	   while(begin<end) {
			   if(array[end]>=temp) {
			   end--;
			   }
			   if(array[end]<temp) { 
				  swap(begin,end,array);//交换begin和end的元素
				  begin++;  
			   }   		  
	     }
    	   //判断一下 基准点时归左还是右 因为上面的循环在begin==end就停住了 没法判断此时的情况
    	   //==保证在1 0 0 0 0 0的情况下左边至少一个元素
    	   if(array[begin]<=temp) {
    			  sort(array,be,begin);
    			  sort(array,begin+1,ed);
    			  }
    			  else {
    				  sort(array,be,begin-1);
                      sort(array,begin,ed);
    			  }

}

      /*
       * 双指针写法(对细节要求不是很高)
       * */
       public  static int[] sort2(int[] array) {
    	   int begin = 0;
    	   int end   = array.length-1;
    	   int temp = array[0];
    	   while(begin<end) {
    		   //当右边指针指向的元素大于temp时 指针左移动 该指针右边元素全部大于temp
    		   while(end>begin&&array[end]>=temp) {
    			   end--;  
    		   }
    		   //此时end指向元素小于temp 把他放到左边 
    		   array[begin] = array[end];
    		   while(end>begin&&array[begin]<temp) {
    			   begin++;
    		   }
    		   array[end] = array[begin] ;
    		   
    		   
    		   
    	   }
    	   //temp 放在临界点 左边小于temp 右边大于temp
    	   array[end] = temp;
    	   sort2(array,0,begin-1);
    	   sort2(array,begin+1,array.length-1);
    	   return array;
    	   
       }
       public static void sort2(int[] array,int begin,int end) {
    	   //必须时>= 而不是== 因为可能传 0 -1 这种情况 (临界点在0)
    	   if(begin>=end) {
    		   
    		   return ;
    		   
    	   }
    	   int be = begin ;
    	   int ed = end;
    	   int temp = array[begin];
    	   
     	   while(begin<end) {
    		   //当右边指针指向的元素大于temp时 指针左移动 该指针右边元素全部大于temp
    		   while(end>begin&&array[end]>=temp) {
    			   end--;  
    		   }
    		   //此时end指向元素小于temp 把他放到左边 
    		   array[begin] = array[end];
    		   while(end>begin&&array[begin]<=temp) {
    			   begin++;
    		   }
    		   array[end] = array[begin] ;
    		   
    		   
    		   
    	   }
    	   //temp 放在临界点 左边小于temp 右边大于temp
    	   array[end] = temp;
    	   sort2(array,be,begin-1);
    	   sort2(array,begin+1,ed);
    	   
    	   
       }
    	   




}