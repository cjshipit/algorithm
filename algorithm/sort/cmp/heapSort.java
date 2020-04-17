package sort.cmp;

public class heapSort extends sort{
	//�������ֵ���±�
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
    {   //�����ڵ�͸����Һ��ӵ����ֵ���� ʹ�ø��ڵ��ֵ��� Ȼ��ѭ��������������
    	//�Ƚ����Һ��ӵ��±��ֵ����� ����Ƚ�
    	while(parentIndex<length) {	
	    	int leftIndex = (parentIndex+1)*2-1;//���±�
	        int rightIndex = (parentIndex+1)*2 ;//���±�
	    	if(rightIndex <length){    //�ҽڵ����
	    	  int temp =  max(parentIndex,leftIndex, rightIndex,array);
	    	      swap(parentIndex,temp,array);
	    	      if(temp==parentIndex) {
	    	    	  break;
	    	      }
	    	      else if(temp==leftIndex){
	    	    	  parentIndex = leftIndex ;//��������ӽڵ㽻�� �������ܲ�����һ���� �ٴν���while ���е���
	    	      }
	    	      else {
	    	    	  parentIndex = rightIndex; 
	    	    	  
	    	      }
	    	  	}
	    		
	    	else if(leftIndex<length) { //�ҽڵ㲻����
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
		 //��������н��� ѡȡ�������ϵķ���������(��ԭ���鿴���������� Ȼ�����˳��ɶ�)
		 //�����һ���ڵ�������ǰ�����ɶ�
		  for(int j=(array.length-2)/2;j>=0;j--) {
			  downAdjust(array,j,array.length);  
		  }
		  int length = array.length;
		   
	     while(length>1) {
	    	 //���Ѷ�Ԫ�غ�ĩβԪ�ؽ��н���
	    	 swap(0,length-1,array);
	    	 //�ѵĴ�С-1
	    	 length = length -1;
	    	 //���ڵ��³�
	    	 downAdjust(array,0,length);  
	    	 
	    	 
	    	 
	    	 
	     }
		 //�ѵĴ�С-1 ���ҵ�����
		 return array;
	 }

}
