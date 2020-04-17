package sort.cmp.copy;

public class quickSort extends sort{
	/*
	 * �����׷��Ĵ��󣺱���ѻ�׼Ԫ�ط��� ��Ӧ�ô��ڵ�λ�� ��Ȼ�������
	 * 
	 * ��ָ���ƶ���д��
	 *    ������Ļ�׼Ԫ�� �����������ѡ �����������ѡ �����������ݹ� 
	 *        ��Ϊ�������Ԫ�ض�С�ڻ�׼Ԫ����ô�͵û�Ԫ��
	 *     
	 * 
	 * */
	  public static int[] sort(int[] array) {
		  int begin = 0;
		  int end = array.length-1;
		  int temp = array[0];//��Ҫ�ȽϵĻ�׼Ԫ��
		  while(begin<end) {
			       //=��֤ �� 1 2 2 2 2  ������ұ�������һ��Ԫ��(���ȫ��С�ڻ�׼ֵ ����array[begin])��֤����һ���ź� ��ֹ���ݹ�
				   if(array[end]>=temp) {
				   end--;
				   }
				   else if(array[end]<temp) { 
					  //�Ƚ��� ��++  2 1 ������� ��++�ٽ������൱��û����
					  swap(begin,end,array);//����begin��end��Ԫ��
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
		  //begin��ʾ��һ��Ԫ�ص��±� end��ʾ���һ��Ԫ���±�
    	   
    	   //������<= ��Ϊ���ܴ����� 0 -1�������
    	   if(end<=begin) {
    		   //����ֻ��һ��Ԫ�� ��ôֱ�ӷ���
    		   return ;
    	   }
    	   int be = begin; 
    	   int ed = end;//����һ��
    	   int temp = array[begin];
    	   while(begin<end) {
			   if(array[end]>=temp) {
			   end--;
			   }
			   if(array[end]<temp) { 
				  swap(begin,end,array);//����begin��end��Ԫ��
				  begin++;  
			   }   		  
	     }
    	   //�ж�һ�� ��׼��ʱ�������� ��Ϊ�����ѭ����begin==end��ͣס�� û���жϴ�ʱ�����
    	   //==��֤��1 0 0 0 0 0��������������һ��Ԫ��
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
       * ˫ָ��д��(��ϸ��Ҫ���Ǻܸ�)
       * */
       public  static int[] sort2(int[] array) {
    	   int begin = 0;
    	   int end   = array.length-1;
    	   int temp = array[0];
    	   while(begin<end) {
    		   //���ұ�ָ��ָ���Ԫ�ش���tempʱ ָ�����ƶ� ��ָ���ұ�Ԫ��ȫ������temp
    		   while(end>begin&&array[end]>=temp) {
    			   end--;  
    		   }
    		   //��ʱendָ��Ԫ��С��temp �����ŵ���� 
    		   array[begin] = array[end];
    		   while(end>begin&&array[begin]<temp) {
    			   begin++;
    		   }
    		   array[end] = array[begin] ;
    		   
    		   
    		   
    	   }
    	   //temp �����ٽ�� ���С��temp �ұߴ���temp
    	   array[end] = temp;
    	   sort2(array,0,begin-1);
    	   sort2(array,begin+1,array.length-1);
    	   return array;
    	   
       }
       public static void sort2(int[] array,int begin,int end) {
    	   //����ʱ>= ������== ��Ϊ���ܴ� 0 -1 ������� (�ٽ����0)
    	   if(begin>=end) {
    		   
    		   return ;
    		   
    	   }
    	   int be = begin ;
    	   int ed = end;
    	   int temp = array[begin];
    	   
     	   while(begin<end) {
    		   //���ұ�ָ��ָ���Ԫ�ش���tempʱ ָ�����ƶ� ��ָ���ұ�Ԫ��ȫ������temp
    		   while(end>begin&&array[end]>=temp) {
    			   end--;  
    		   }
    		   //��ʱendָ��Ԫ��С��temp �����ŵ���� 
    		   array[begin] = array[end];
    		   while(end>begin&&array[begin]<=temp) {
    			   begin++;
    		   }
    		   array[end] = array[begin] ;
    		   
    		   
    		   
    	   }
    	   //temp �����ٽ�� ���С��temp �ұߴ���temp
    	   array[end] = temp;
    	   sort2(array,be,begin-1);
    	   sort2(array,begin+1,ed);
    	   
    	   
       }
    	   




}