package sort.util;
import java.lang.Math;
//产生一个随机数组用于测试排序算法
public class randArray {
	//给一个 允许的最大值 产生(0 max] 的随机数
	 public static int[] produceArray(int max,int size) {
		 int[] array = new int[size];
		 for(int i=0;i<array.length;i++) {
			 array[i] =(int)(Math.random()*max+1);		 
		 }
		 
		 
		 return array ;
		 
	 }

}
