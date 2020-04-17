package sort.nocmp.copy;


public class redixSort {
	private static void countingSort(int redix,int[] array) {
		//��Ϊֻ��0-9 �����ó���Ϊ9���������
		int[] newArray = new int[10] ;
		//ͳ��ÿ�����ֳ��ֵĴ���
		for(int i=0;i<array.length;i++) {
			newArray[(array[i]/redix)%10]++;
		}
		//�޸�newArray����Ϊ��һ��+����
		for(int i=1;i<newArray.length;i++) {
			  newArray[i] = newArray[i-1] + newArray[i] ;		  
		  }
		
		
		int[] array2 = new int[array.length] ;
		for(int i=array.length-1;i>=0;i--) {
			  
			  array2[newArray[(array[i]/redix)%10]-1] = array[i] ;
			  newArray[(array[i]/redix)%10]--;
			  
			  
		 }
		  //��array2����������д��array��
		  for(int i=0;i<array.length;i++) {
			  array[i] = array2[i] ;
			  
			  
		  }
		 return ;  
		
	}
	
	
	
	
	public static void sort(int[] array) {
	   //����ѡȡ��������� ÿ������(ÿ��λ�ϵ�����)��������
	   int max = array[0];
	   for(int i=1;i<array.length;i++) {
		   if(array[i]>max) {
			   max = array[i];   
		   }
	   }
	   /*
	    * ȡ����λ�� i/1%10
	    * ȡ��ʮλ��i/10%10
	    * ......
	    * */
	   //��ÿһλ�����ü�������
	   for(int i=1;i<=max;i=i*10) {
		   countingSort(i,array);   
	   }
		return ;
		
		
	}
                
}
