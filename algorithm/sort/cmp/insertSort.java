package sort.cmp;

public class insertSort extends sort {
	  public static int[] sort(int[] array) {
		  //����Ԫ�� ��ǰ����
		  for(int i=1;i<array.length;i++) {
			 int temp = array[i];
			 int cut =  i - 1 ;
			 while(cut>=0&&temp<array[cut]) {
				  array[cut+1]=array[cut];//���Ų��Ԫ��	
	              cut = cut-1;//����ǰһ��Ԫ��		
 			 }
			 array[cut+1] = temp;
			  
			  
		  }
			  
		  
		  
		  
		  
		  return array ;
		  
		  
		  
	  }
      /*
       * �Ż��汾:������λ�õķ����ı�Ϊ���ֲ���
       * 
       * */
	  public static int[] sort2(int[] array) {
		  for(int i=1;i<array.length;i++) {
			  int temp = array[i];
			  //���ұȸ�Ԫ�ش�ĵ�һ��Ԫ�ص��±� �øĽ��Ķ��ֲ���
			  int index = binarySerch(array,temp,i);
			  //������֮���Ԫ�������ƶ�һλ
			  for(int j=i-1;j>=index;j--) {
				  array[j+1] = array[j];
			  }  
			  array[index] = temp ;
			  }	    
	     return array ;
		  
	  }
	  
	  private static int binarySerch(int[] array,int target,int end) {
			 //ע��begin��end�ı仯  begin��ʾ��һ��Ԫ�ص��±� end��ʾ���һ��Ԫ���±�+1
		     //>=���ұ߲��� <����߲��� ֪��end==begin
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
