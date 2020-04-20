package kmp;

import java.util.Arrays;

//字符串的模式匹配算法
public class kmp {
	
   public static void main(String[] args) {
	  String s1 ="abcabcabcdbdb";
	  String s2 = "dbdb" ;
	  int[] next = kmpNext(s2);
	  System.out.println(Arrays.toString(next));
	  System.out.println(kmpSerch(s1,s2,next));
	  
   }
   //得到字符串的部分匹配表
   public static int kmpSerch(String s1,String s2,int[]next) {
	   int res = -1;
	   //kmp算法的另一大难点
	   /*i表示指向长串 j表示短串
	    *最坏时间复杂度 s1.length i没回加一 while循环次数远小于 s1.length 
	    * 
	    * */
	   for(int i=0,j=0;i<s1.length();i++) {
		   //发现不匹配 子串向后挪动的长度不是1 而是 而是直接让i和前缀(j-1)串结尾下一个字符匹配
		  while(j>0&&s1.charAt(i)!=s2.charAt(j)) {
			  j = next[j-1];
		  }
		   if(s1.charAt(i)==s2.charAt(j)) {
			   //找到了 此时i指向 长串的最后 j指向短串的最后(短串的长度)
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
   //该函数时间复杂度为
   public static int[] kmpNext(String s2) {
	   int[] next = new int[s2.length()];
	   //第一个是0
	   next[0] = 0;
	   for(int i=1;i<next.length;i++) {
		   //kmp算法的一大难点 就是通过递归的思想来求部分匹配表
		   /*
		    * 这处代码比较复杂 
		    * 核心思想是  求next[i]时候  用上了next[i-1] 
		    * 假设 next[i-1] = k
		    * 那么 前k项已经匹配完了 一定部分匹配的 只要看看k+1项与第i项是不是相等的
		    * 如果相等 next[i] = next[i-1]+1
		    * 如果不相等 需要递归 next[k]
		    * 
		    * 		     
		    * 
		    * */
		   int j = next[i-1];
		   //while循环的次数n要远小于next.length (m) 所以时间复杂度O(m*n)中的n省掉了
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
