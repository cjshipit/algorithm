package kmp;

import java.util.Arrays;

//�ַ�����ģʽƥ���㷨
public class kmp {
	
   public static void main(String[] args) {
	  String s1 ="abcabcabcdbdb";
	  String s2 = "dbdb" ;
	  int[] next = kmpNext(s2);
	  System.out.println(Arrays.toString(next));
	  System.out.println(kmpSerch(s1,s2,next));
	  
   }
   //�õ��ַ����Ĳ���ƥ���
   public static int kmpSerch(String s1,String s2,int[]next) {
	   int res = -1;
	   //kmp�㷨����һ���ѵ�
	   /*i��ʾָ�򳤴� j��ʾ�̴�
	    *�ʱ�临�Ӷ� s1.length iû�ؼ�һ whileѭ������ԶС�� s1.length 
	    * 
	    * */
	   for(int i=0,j=0;i<s1.length();i++) {
		   //���ֲ�ƥ�� �Ӵ����Ų���ĳ��Ȳ���1 ���� ����ֱ����i��ǰ׺(j-1)����β��һ���ַ�ƥ��
		  while(j>0&&s1.charAt(i)!=s2.charAt(j)) {
			  j = next[j-1];
		  }
		   if(s1.charAt(i)==s2.charAt(j)) {
			   //�ҵ��� ��ʱiָ�� ��������� jָ��̴������(�̴��ĳ���)
			   if(j==s2.length()-1) {
				   return i - j + 1 ;
			   }
			   else {
				   j++;
			   }
			   
			   
		   }
		   
	   }
	   return res ;
   }
   //�ú���ʱ�临�Ӷ�Ϊ
   public static int[] kmpNext(String s2) {
	   int[] next = new int[s2.length()];
	   //��һ����0
	   next[0] = 0;
	   for(int i=1;i<next.length;i++) {
		   //kmp�㷨��һ���ѵ� ����ͨ���ݹ��˼�����󲿷�ƥ���
		   /*
		    * �⴦����Ƚϸ��� 
		    * ����˼����  ��next[i]ʱ��  ������next[i-1] 
		    * ���� next[i-1] = k
		    * ��ô ǰk���Ѿ�ƥ������ һ������ƥ��� ֻҪ����k+1�����i���ǲ�����ȵ�
		    * ������ next[i] = next[i-1]+1
		    * �������� ��Ҫ�ݹ� next[k]
		    * 
		    * 		     
		    * 
		    * */
		   int j = next[i-1];
		   //whileѭ���Ĵ���nҪԶС��next.length (m) ����ʱ�临�Ӷ�O(m*n)�е�nʡ����
		   while(j>0&&s2.charAt(j)!=s2.charAt(i)) {
			   j = next[j] ;
		   }
		   if(s2.charAt(j)==s2.charAt(i)) {
			   next[i] =j+1;
			   j++;
		   }
		   else {
			   next[i]=0;
		   }
		   
	   }

	   return next ;
	   
	   
	   
   }
}
