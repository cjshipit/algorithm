package sort.cmp;

public class binarySearch {
    //一个简单的二分搜索
	//递归写法
	 public static int  recursive(int[] array,int target,int begin,int end) {
		 //end 表示最后一个元素下标+1 begin表示第一个元素的下标
		 if(end==begin) {
			 return -1;//没找到	 
		 }
		 if(target==array[(end+begin)/2]) {	 
			 return (end+begin)/2 ;	 
		 }
		 else if(target>array[(end+begin)/2]) {
			  return recursive(array,target,(end+begin)/2+1,end); 
		 }
		 else {
			 
			 return recursive(array,target,begin,(end+begin)/2);
		 }
		 
		 
	 }
     //非递归写法
	 public static int noRecursive(int[] array,int target) {
		 //注意begin和end的变化  begin表示第一个元素的下标 end表示最后一个元素下标+1
		 int begin = 0;
		 int end = array.length;
		 while(begin<end) {
			 if(target==array[(begin+end)/2]){
			   return (begin+end)/2;	 
			 }
			 //需要从左半边找
			 else if(target<array[(begin+end)/2]){
				 end = (begin+end)/2 ;	 
			 }
			 else if(target>array[(begin+end)/2]) {
				 begin = (begin+end)/2 + 1 ;	 
			 }
			 
		 }
			 
		 return -1;
		 
		 
	 }
     

}
