package sort.util;

//��� ������������ �׳�������ʱ�쳣
class arrayNotRiseException extends RuntimeException{
	
	@Override
	public String getMessage() {
		System.out.println("���鲻���������� �����㷨���ִ���");
		return null ;
	}
	@Override
	public void printStackTrace() {
		System.out.println("���鲻���������� �����㷨���ִ���");
	}
	
} 
class arrayIsNullException extends RuntimeException{
	public String getMessage() {
		System.out.println("����Ϊ��");
		return null ;
	}
	@Override
	public void printStackTrace() {
		System.out.println("����Ϊ��");
	}
	
	
	
}

public class arrayUtil {
   //�ж�һ�������Ƿ�Ϊ������ ����� �׳��쳣
   public static void isRise(int[] array) {
	   if(array==null) {
		   throw new arrayIsNullException() ;
	   }
	   if(array.length==0){
		   return ;
	   }
	   for(int i=1;i<array.length;i++) {
		   if(array[i]<array[i-1]) {
			   throw new arrayNotRiseException() ;
			   
		   }
		   
		   
	   }
	   
   }
}
