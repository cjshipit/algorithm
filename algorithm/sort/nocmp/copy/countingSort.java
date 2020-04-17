package sort.nocmp.copy;

public class countingSort {
   /**
    * ����ļ����������
    * ȱ��: �˷��ڴ�
    *       ���ȶ�
    *       ֻ���Ŵ���0����
    * 
    * 
    * 
    * */
   public static void sort(int[] array) {
     //�ҳ������е����ֵ
	 int max = array[0];
	 for(int i=1;i<array.length;i++) {
    	  if(array[i]>max) {
    		  max = array[i];
    	  }
     }
     //�������ֵ��ô����ڴ�ռ�
	 int[] newArray = new int[max+1] ;
	 //ͳ��ÿ�����ֳ��ֵĴ���
	 for(int i=0;i<array.length;i++) {
		 newArray[array[i]]++;	 
	 }
	 //����ͳ�Ƶĳ��ִ���������
	 int index = 0;//Ԫ��Ҫ�ŵ�λ��
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
    * �Ľ���ļ������� ˼·:
    *     1 ֻ����max-min+1 ��ô����ڴ� ���������-min ����Ԫ�ص�ֵ
    *     2 �����в���Ԫ�صĸ��� ���Ǵ�Ԫ�ظ���+С����������Ԫ�ظ���
    *       ��������ͨ�� newArray[i]-1�ķ�ʽ�жϳ���Ԫ�����ź�˳�������е�λ��(���ü���0)
    *       �������ҵ��������һ��λ�� �����Ϳ����ȶ���
    * 
    * */
   public static void sort2(int[] array) {
	   //�ҵ����ֵ����Сֵ
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
	  //��Ԫ�ظ�Ϊ Ԫ�ظ���+֮ǰ��ͳ�Ƹ���
	  for(int i=1;i<newArray.length;i++) {
		  newArray[i] = newArray[i-1] + newArray[i] ;		  
	  }
	  //ɨ��ԭ���� ���ҹ�λԪ��
	  int[] array2 = new int[array.length] ;
	  for(int i=array.length-1;i>=0;i--) {
		  
		  array2[newArray[array[i]-min]-1] = array[i] ;
		  newArray[array[i]-min]--;
		  
		  
	  }
	  //��array2����������д��array��
	  for(int i=0;i<array.length;i++) {
		  array[i] = array2[i] ;
		  
		  
	  }
	 return ;  
   }
	
}
