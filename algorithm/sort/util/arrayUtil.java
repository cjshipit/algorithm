package sort.util;

//如果 不是增加序列 抛出此运行时异常
class arrayNotRiseException extends RuntimeException{
	
	@Override
	public String getMessage() {
		System.out.println("数组不是增加序列 排序算法出现错误");
		return null ;
	}
	@Override
	public void printStackTrace() {
		System.out.println("数组不是增加序列 排序算法出现错误");
	}
	
} 
class arrayIsNullException extends RuntimeException{
	public String getMessage() {
		System.out.println("数组为空");
		return null ;
	}
	@Override
	public void printStackTrace() {
		System.out.println("数组为空");
	}
	
	
	
}

public class arrayUtil {
   //判断一个数组是否为曾序列 如果否 抛出异常
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
