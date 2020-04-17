package sort.cmp;

public class heapSort extends sort{
	//返回最大值的下标
	private static int max(int parent,int left,int right,int[] array){
		 if(array[parent]>=array[left]) {
		     if(array[parent]>=array[right]) {
		    	 return parent ;
		     }
		     else {
		    	 
		    	 
		    	 return right ;
		     } 
			 
		 }
		 else {
			 if(array[left]>=array[right]) {
				 return left ;
				 
			 }
			 else {
				 
				 return right ;
				 
			 }
			 
				 
			 
			 
		 }
	}
    private static void downAdjust(int[] array,int parentIndex,int length)
    {   //将父节点和父左右孩子的最大值交换 使得父节点的值最大 然后循环调整左右子树
    	//先将左右孩子的下标和值抽出来 方便比较
    	while(parentIndex<length) {	
	    	int leftIndex = (parentIndex+1)*2-1;//左下标
	        int rightIndex = (parentIndex+1)*2 ;//右下标
	    	if(rightIndex <length){    //右节点存在
	    	  int temp =  max(parentIndex,leftIndex, rightIndex,array);
	    	      swap(parentIndex,temp,array);
	    	      if(temp==parentIndex) {
	    	    	  break;
	    	      }
	    	      else if(temp==leftIndex){
	    	    	  parentIndex = leftIndex ;//如果与左子节点交换 左树可能不再是一个堆 再次进入while 进行调整
	    	      }
	    	      else {
	    	    	  parentIndex = rightIndex; 
	    	    	  
	    	      }
	    	  	}
	    		
	    	else if(leftIndex<length) { //右节点不存在
	    		if(array[parentIndex]<=array[leftIndex]) {
	    			swap(parentIndex,leftIndex,array);
	    			parentIndex = leftIndex ;
	    		}
	    		else {
	    			break;
	    		}
    		
    		
    	    }
	    	else {
	    		break ;
	    	}
    }
    }
	 public static int[] sort(int[] array) {
		 //对数组进行建堆 选取从下往上的方法建立堆(将原数组看做满二叉树 然后调整顺序成堆)
		 //从最后一个节点依次往前调整成堆
		  for(int j=(array.length-2)/2;j>=0;j--) {
			  downAdjust(array,j,array.length);  
		  }
		  int length = array.length;
		   
	     while(length>1) {
	    	 //将堆顶元素和末尾元素进行交换
	    	 swap(0,length-1,array);
	    	 //堆的大小-1
	    	 length = length -1;
	    	 //根节点下沉
	    	 downAdjust(array,0,length);  
	    	 
	    	 
	    	 
	    	 
	     }
		 //堆的大小-1 并且调整堆
		 return array;
	 }

}
