package sort.cmp;

public class binarySearch {
    //һ���򵥵Ķ�������
	//�ݹ�д��
	 public static int  recursive(int[] array,int target,int begin,int end) {
		 //end ��ʾ���һ��Ԫ���±�+1 begin��ʾ��һ��Ԫ�ص��±�
		 if(end==begin) {
			 return -1;//û�ҵ�	 
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
     //�ǵݹ�д��
	 public static int noRecursive(int[] array,int target) {
		 //ע��begin��end�ı仯  begin��ʾ��һ��Ԫ�ص��±� end��ʾ���һ��Ԫ���±�+1
		 int begin = 0;
		 int end = array.length;
		 while(begin<end) {
			 if(target==array[(begin+end)/2]){
			   return (begin+end)/2;	 
			 }
			 //��Ҫ��������
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
